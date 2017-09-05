package example.test.com.categoryview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Pan on 2017/9/5 0005 22:21
 * Desc:
 */

public class CategoryAdapter2 extends RecyclerView.Adapter implements OnBannerListener {

    private Context mContext;
    private final LayoutInflater mInflater;
    private List<CategoryBean2.DataBean> mData;

    // 测试轮播图数据
    private String[] images = {
            "http://ww4.sinaimg.cn/large/006uZZy8jw1faic1xjab4j30ci08cjrv.jpg",
            "http://ww4.sinaimg.cn/large/006uZZy8jw1faic21363tj30ci08ct96.jpg",
            "http://ww4.sinaimg.cn/large/006uZZy8jw1faic259ohaj30ci08c74r.jpg",
            "http://ww4.sinaimg.cn/large/006uZZy8jw1faic2b16zuj30ci08cwf4.jpg"
    };

    public CategoryAdapter2(Context context, List<CategoryBean2.DataBean> data) {
        mContext = context;
        mData = data;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return new BannerViewHolder(mInflater.inflate(R.layout.category_banner_item, parent, false));
        }
        return new DataViewHolder(mInflater.inflate(R.layout.category_data_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == 0) {
            BannerViewHolder viewHolder = (BannerViewHolder) holder;
            List<?> list = Arrays.asList(images);
            viewHolder.mBanner.setImages(list)
                    .setImageLoader(new GlideImageLoader())
                    .setOnBannerListener(this);
            //设置自动轮播
            viewHolder.mBanner.startAutoPlay();
            //设置轮播时间
            viewHolder.mBanner.setDelayTime(4000);
            //banner设置方法全部调用完毕时最后调用
            viewHolder.mBanner.start();
        } else {
            DataViewHolder viewHolder = (DataViewHolder) holder;
            CategoryBean2.DataBean dataBean = mData.get(position - 1);
            String name = dataBean.name;
            viewHolder.mName.setText(name);
            CategoryItemAdapter2 adapter = new CategoryItemAdapter2(mContext, dataBean.catelogyList);
            viewHolder.mGridView.setAdapter(adapter);
        }
    }

    @Override
    public int getItemCount() {
        return mData.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        }
        return 1;
    }

    @Override
    public void OnBannerClick(int position) {

    }

    //todo 1.banner
    public class BannerViewHolder extends RecyclerView.ViewHolder {

        private final Banner mBanner;

        public BannerViewHolder(View itemView) {
            super(itemView);

            mBanner = (Banner) itemView.findViewById(R.id.banner);
        }
    }

    //todo 2.内容
    public class DataViewHolder extends RecyclerView.ViewHolder {

        private final MyGridView mGridView;
        private final TextView mName;

        public DataViewHolder(View itemView) {
            super(itemView);
            mName = (TextView) itemView.findViewById(R.id.category_name);
            mGridView = (MyGridView) itemView.findViewById(R.id.item_grid);
        }
    }

    public class GlideImageLoader extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);

        }
    }
}
