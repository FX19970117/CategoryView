package example.test.com.categoryview;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;

import butterknife.BindView;

/**
 * Created by Pan on 2017/8/27 0027 18:31
 * Desc:
 */

public class CategoryItemFragment extends BaseFragment {

    @BindView(R.id.category_recy)
    RecyclerView category_recy;

    private int mPosition;


    @Override
    protected View initLayout() {
        return View.inflate(mContext, R.layout.category_item_layout, null);
    }

    @Override
    protected void initData() {
        super.initData();
        Bundle bundle = getArguments();
        if (bundle != null) {
            mPosition = bundle.getInt("position");
        }

        Gson gson = new Gson();
        CategoryBean2 data2 = gson.fromJson(Constants.test_json,CategoryBean2.class);
        CategoryAdapter2 adapter2 = new CategoryAdapter2(mContext,data2.data);
        category_recy.setLayoutManager(new LinearLayoutManager(mContext));
        category_recy.setAdapter(adapter2);

    }

    @Override
    protected void initView() {
        super.initView();

    }
}
