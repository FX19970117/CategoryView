package example.test.com.categoryview;

import java.util.List;

/**
 * Created by Pan on 2017/9/5 0005 22:31
 * Desc:
 */

public class CategoryBean2 {


    public String code;
    public List<DataBean> data;

    public static class DataBean {
        public int cid;
        public int columNum;
        public boolean hideClearIcon;
        public String name;
        public boolean rankingFlag;
        public List<CatelogyListBean> catelogyList;

        public static class CatelogyListBean {
            public int cid;
            public int columNum;
            public String icon;
            public boolean isMerger;
            public String name;
            public String path;
        }
    }
}
