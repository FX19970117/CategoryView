package example.test.com.categoryview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Pan on 2017/8/27 0027 17:30
 * Desc:
 */

public class CategoryAdapte extends RecyclerView.Adapter {

    private Context mContext;
    private String[] mCategory;
    private OnClick mItemClick;
    private final LayoutInflater mInflater;

    public CategoryAdapte(Context context, String[] category) {
        mInflater = LayoutInflater.from(context);
        mContext = context;
        mCategory = category;
    }

    //初始化位置
    private int clickStatus = 0;

    public void setSeclection(int position) {
        clickStatus = position;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CategoryViewHolder(mInflater.inflate(R.layout.category_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        CategoryViewHolder viewHolder = (CategoryViewHolder) holder;
        viewHolder.mRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mItemClick.onClick(position);
            }
        });

        if (clickStatus == position) {
            //选中
            viewHolder.mName.setTextColor(mContext.getResources().getColor(R.color.tab_selected_color));
            viewHolder.mRl.setBackgroundColor(mContext.getResources().getColor(R.color.white));
        } else {
            viewHolder.mName.setTextColor(mContext.getResources().getColor(R.color.black));
            viewHolder.mRl.setBackgroundColor(mContext.getResources().getColor(R.color.little_gray02));
        }
        viewHolder.mName.setText(mCategory[position]);
    }

    @Override
    public int getItemCount() {
        return mCategory.length;
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {

        private final TextView mName;
        private final RelativeLayout mRl;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            mRl = (RelativeLayout) itemView.findViewById(R.id.rl1);
            mName = (TextView) itemView.findViewById(R.id.name);
        }
    }

    public interface OnClick {
        void onClick(int position);
    }

    public void setOnItemClick(OnClick itemClick) {

        mItemClick = itemClick;
    }
}
