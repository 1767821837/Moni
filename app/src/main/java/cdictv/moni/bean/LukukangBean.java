package cdictv.moni.bean;

import java.util.List;

public class LukukangBean {

    /**
     * code : 1
     * data : {"wendu":"17","shidu":"58","pm":"19","lukuang":[{"id":1,"state":3},{"id":2,"state":5},{"id":3,"state":5},{"id":4,"state":2},{"id":5,"state":1},{"id":6,"state":5},{"id":7,"state":3}]}
     */

    public int code;
    public DataBean data;

    public static class DataBean {
        /**
         * wendu : 17
         * shidu : 58
         * pm : 19
         * lukuang : [{"id":1,"state":3},{"id":2,"state":5},{"id":3,"state":5},{"id":4,"state":2},{"id":5,"state":1},{"id":6,"state":5},{"id":7,"state":3}]
         */

        public String wendu;
        public String shidu;
        public String pm;
        public List<LukuangBean> lukuang;

        public static class LukuangBean {
            /**
             * id : 1
             * state : 3
             */

            public int id;
            public int state;
        }
    }
}
