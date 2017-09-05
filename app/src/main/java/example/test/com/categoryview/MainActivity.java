package example.test.com.categoryview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import static example.test.com.categoryview.R.id.category_recy;

public class MainActivity extends AppCompatActivity {

    private String[] category = {"常见分类", "京东超市", "国际名牌"};
    private CategoryAdapte mAdapte;
    private RecyclerView mCategory_recy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCategory_recy = (RecyclerView) findViewById(category_recy);

        initView();
    }

    private void initView() {
        mAdapte = new CategoryAdapte(this, category);
        mCategory_recy.setAdapter(mAdapte);
        mCategory_recy.setLayoutManager(new LinearLayoutManager(this));

        showCategory(0);
    }

    private void showCategory(int i) {
        CategoryItemFragment fragment = new CategoryItemFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position", i);
        fragment.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(R.id.category_container, fragment).commit();
    }
}
