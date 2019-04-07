package cdictv.moni.bean;

import java.io.Serializable;
import java.util.List;

public class CarCradBean implements Serializable {
    /**
     * code : 1
     * data : {"chepai":"川a10001","weichuli":"2","koufen":"2","fankuan":"250","xiangqing":[{"time":"2017-08-25  17:55:00","state":"未处理","luduan":"学院路","yuanyin":"驾驶超速","koufen":1,"fakuan":200},{"time":"2017-08-25  17:55:00","state":"未处理","luduan":"一元路","yuanyin":"驾驶超速","koufen":1,"fakuan":200},{"time":"2017-08-25  17:55:00","state":"未处理","luduan":"神奇路","yuanyin":"驾驶超速","koufen":1,"fakuan":200}]}
     */

    public int code;
    public DataBean data;

    public static class DataBean implements Serializable{
        /**
         * chepai : 川a10001
         * weichuli : 2
         * koufen : 2
         * fankuan : 250
         * xiangqing : [{"time":"2017-08-25  17:55:00","state":"未处理","luduan":"学院路","yuanyin":"驾驶超速","koufen":1,"fakuan":200},{"time":"2017-08-25  17:55:00","state":"未处理","luduan":"一元路","yuanyin":"驾驶超速","koufen":1,"fakuan":200},{"time":"2017-08-25  17:55:00","state":"未处理","luduan":"神奇路","yuanyin":"驾驶超速","koufen":1,"fakuan":200}]
         */

        public String chepai;
        public String weichuli;
        public String koufen;
        public String fankuan;
        public List<XiangqingBean> xiangqing;

        public static class XiangqingBean implements Serializable{
            /**
             * time : 2017-08-25  17:55:00
             * state : 未处理
             * luduan : 学院路
             * yuanyin : 驾驶超速
             * koufen : 1
             * fakuan : 200
             */

            public String time;
            public String state;
            public String luduan;
            public String yuanyin;
            public int koufen;
            public int fakuan;
        }
    }
}
