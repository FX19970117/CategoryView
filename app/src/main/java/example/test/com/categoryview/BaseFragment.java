package example.test.com.categoryview;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by Pan
 * desc: Fragmen的基类
 */

public abstract class BaseFragment extends Fragment {

    protected Context mContext;
    private View mView;
    private ProgressDialog mProgressDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        mView = initLayout();
        ButterKnife.bind(this, mView);
        return mView;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        initData();
        initView();
        initListener();
    }

    protected void initListener() {
    }

    protected abstract View initLayout();

    /**
     * 初始化数据
     */
    protected void initData() {

    }

    /**
     * 初始化视图
     */
    protected void initView() {

    }

    /**
     * 子类实现该方法执行初始化操作
     */
    protected void init() {

    }


    /**
     * 加载等待界面
     *
     * @param message
     */
    protected void loadProgressDialog(String message) {
        if (mProgressDialog != null)
            mProgressDialog.dismiss();

        mProgressDialog = new ProgressDialog(mContext);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressDialog.setMessage(message);
        mProgressDialog.show();
    }

    /**
     * 销毁等待界面
     */
    protected void dismissProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing())
            mProgressDialog.dismiss();

        mProgressDialog = null;

    }
}
