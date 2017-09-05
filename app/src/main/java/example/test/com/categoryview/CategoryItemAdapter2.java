package example.test.com.categoryview;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Panfuya on 2017/9/1.
 * desc:
 */

public class CategoryItemAdapter2 extends BaseAdapter {

    private Context mContext;
    private List<CategoryBean2.DataBean.CatelogyListBean> mData;

    public CategoryItemAdapter2(Context context, List<CategoryBean2.DataBean.CatelogyListBean> data) {
        mContext = context;
        mData = data;
    }

    @Override
    public int getCount() {
        if (mData == null) {
            return 0;
        }
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        if (mData != null) {
            return mData.get(i);
        }
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = View.inflate(mContext, R.layout.category_grid_item_layout, null);
            holder = new ViewHolder();
            holder.name = (TextView) view.findViewById(R.id.name);
            holder.imag = (ImageView) view.findViewById(R.id.imag);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        CategoryBean2.DataBean.CatelogyListBean catelogyListBean = mData.get(i);
        holder.name.setText(catelogyListBean.name);
        Glide.with(mContext).load(catelogyListBean.icon).into(holder.imag);
        Log.i("imag", "imag: " + catelogyListBean.icon);
        return view;
    }

    class ViewHolder {
        ImageView imag;
        TextView name;
    }
}
