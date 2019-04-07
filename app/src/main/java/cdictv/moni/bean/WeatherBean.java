package cdictv.moni.bean;

import java.util.List;

public class WeatherBean {



    public String reason;
    public ResultBean result;
    public int error_code;

    public static class ResultBean {


        public String city;
        public RealtimeBean realtime;
        public List<FutureBean> future;

        public static class RealtimeBean {
            /**
             * temperature : 30
             * humidity : 28
             * info : 晴
             * wid : 00
             * direct : 西风
             * power : 2级
             * aqi : 75  空气指数
             */

            public String temperature;
            public String humidity;
            public String info;
            public String wid;
            public String direct;
            public String power;
            public String aqi;
        }

        public static class FutureBean {
            /**
             * date : 2019-04-07
             * temperature : 16/29℃
             * weather : 晴
             * wid : {"day":"00","night":"00"}
             * direct : 持续无风向
             */

            public String date;
            public String temperature;
            public String weather;
            public WidBean wid;
            public String direct;

            public static class WidBean {
                /**
                 * day : 00
                 * night : 00
                 */

                public String day;
                public String night;
            }
        }
    }
}
