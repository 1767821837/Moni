package cdictv.moni.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {
    public static String showData(){
        String data=null;
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar=Calendar.getInstance();
        data=simpleDateFormat.format(calendar.getTime());
        return data;
    }
    public static String showWeek(){
        String[] weeks = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(cal.getTime());
        int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if(week_index<0){
            week_index = 0;
        }
        return weeks[week_index];
    }
}
