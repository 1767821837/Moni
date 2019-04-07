package cdictv.moni.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import cdictv.moni.R;
import cdictv.moni.bean.WeatherBean;
import cdictv.moni.network.Mycall;
import cdictv.moni.network.OkhttpApi;

public class tianqiActivity extends AppCompatActivity {

    private ImageView mButRefresh;
    private TextView mTvAddress;
    private TextView mTvTime;
    private TextView mTvTitleTemperature;
    private TextView mTvContentTimeOne;
    private ImageView mImgContentOne;
    private TextView mTvContentWeatherOne;
    private TextView mTvContentTemperatureOne;
    private LinearLayout mLlContentBackSecondOne;
    private LinearLayout mLlContentBackFirstOne;
    private TextView mTvContentTimeTow;
    private ImageView mImgContentTow;
    private TextView mTvContentWeatherTow;
    private TextView mTvContentTemperatureTow;
    private LinearLayout mLlContentBackSecondTow;
    private LinearLayout mLlContentBackFirstTwo;
    private TextView mTvContentTimeThree;
    private ImageView mImgContentThree;
    private TextView mTvContentWeatherThree;
    private TextView mTvContentTemperatureThree;
    private LinearLayout mLlContentBackSsecondThree;
    private LinearLayout mLlContentBackFirstThree;
    private TextView mTvContentTimeFour;
    private ImageView mImgContentFour;
    private TextView mTvContentWeatherFour;
    private TextView mTvContentTemperatureFour;
    private LinearLayout mLlContentBackSecondFour;
    private LinearLayout mLlContentBackFirstFour;
    private TextView mTvContentTimeFive;
    private ImageView mImgContentFive;
    private TextView mTvContentWeatherFive;
    private TextView mTvContentTemperatureFive;
    private LinearLayout mLlContentBackSecondFive;
    private LinearLayout mLlContentBackFirstFive;
    private WeatherBean weatherBean;
    private int[] img;
    private int[] colors;
    private SimpleDateFormat format;
    private SimpleDateFormat format1;
    private SimpleDateFormat format2;
    private Date date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tianqi);
        format = new SimpleDateFormat("yyyy-MM-dd");
        format1 = new SimpleDateFormat("dd");
        format2 = new SimpleDateFormat("dd日(EEEE)");
        mLlContentBackSecondFive.getChildAt(0);
        initView();
        initdata();
    }

    private void initdata() {
        OkhttpApi.weather(new Mycall() {
            @Override
            public void success(String json) {
                weatherBean = new Gson().fromJson(json, WeatherBean.class);
                setview();
            }

            @Override
            public void faild(IOException e) {

            }
        });

    }

    private void setview() {
        mTvAddress.setText(weatherBean.result.city + "");
        date = new Date();
        mTvTime.setText(format.format(date));
        mTvTitleTemperature.setText(weatherBean.result.realtime.temperature);
        mTvContentTimeOne.setText(format1.format(date) + "(今天)");
        mTvContentTimeTow.setText(format1.format(date.getTime() + 1000 * 60 * 60 * 24) + "(明天)");
        mTvContentTimeThree.setText(format1.format(date.getTime() + 1000 * 60 * 60 * 24 * 2) + "(后天)");
        mTvContentTimeFour.setText(format2.format(date.getTime() + 1000 * 60 * 60 * 24 * 3));
        mTvContentTimeFive.setText(format2.format(date.getTime() + 1000 * 60 * 60 * 24 * 4));
        mTvContentWeatherOne.setText(weatherBean.result.future.get(0).weather);
        mTvContentWeatherTow.setText(weatherBean.result.future.get(1).weather);
        mTvContentWeatherThree.setText(weatherBean.result.future.get(2).weather);
        mTvContentWeatherFour.setText(weatherBean.result.future.get(3).weather);
        mTvContentWeatherFive.setText(weatherBean.result.future.get(4).weather);
        mTvContentTemperatureOne.setText(weatherBean.result.future.get(0).temperature);
        mTvContentTemperatureTow.setText(weatherBean.result.future.get(1).temperature);
        mTvContentTemperatureThree.setText(weatherBean.result.future.get(2).temperature);
        mTvContentTemperatureFour.setText(weatherBean.result.future.get(3).temperature);
        mTvContentTemperatureFive.setText(weatherBean.result.future.get(4).temperature);
        for (int i = 0; i < weatherBean.result.future.size(); i++) {
            WeatherBean.ResultBean.FutureBean beans = weatherBean.result.future.get(i);
            switch (i) {
                case 0:
                    switch (beans.weather) {
                        case "晴":
                          mImgContentOne.setImageResource(img[2]);
                            break;
                        default:
                            mLlContentBackSecondTow.setBackgroundColor(colors[3]);
                            mLlContentBackFirstTwo.setBackgroundColor(colors[2]);
                            mImgContentOne.setImageResource(img[0]);
                            break;
                    }
                    break;
                case 1:
                    switch (beans.weather) {
                        case "晴":
                            mImgContentTow.setImageResource(img[2]);
                            mLlContentBackSecondTow.setBackgroundColor(colors[1]);
                            mLlContentBackFirstTwo.setBackgroundColor(colors[0]);
                            break;
                        default:
                            mImgContentTow.setImageResource(img[1]);
                            mLlContentBackSecondTow.setBackgroundColor(colors[3]);
                            mLlContentBackFirstTwo.setBackgroundColor(colors[2]);
                            break;
                    }
                    break;
                    case 2:
                    switch (beans.weather) {
                        case "晴":
                            mImgContentThree.setImageResource(img[2]);
                            mLlContentBackSsecondThree.setBackgroundColor(colors[1]);
                              mLlContentBackFirstThree.setBackgroundColor(colors[0]);

                            break;
                        default:
                            mImgContentThree.setImageResource(img[0]);
                           mLlContentBackSsecondThree.setBackgroundColor(colors[3]);
                             mLlContentBackFirstThree.setBackgroundColor(colors[2]);
                            break;
                    }
                    break;
                case 3:
                    switch (beans.weather) {
                        case "晴":
                            mImgContentFour.setImageResource(img[2]);
                            mLlContentBackSecondFour.setBackgroundColor(colors[1]);
                            mLlContentBackFirstFour.setBackgroundColor(colors[0]);
                            break;
                        default:
                            mImgContentFour.setImageResource(img[1]);
                            mLlContentBackSecondFour.setBackgroundColor(colors[3]);
                            mLlContentBackFirstFour.setBackgroundColor(colors[2]);
                            break;
                    }
                    break;
                case 4:
                    switch (beans.weather) {
                        case "晴":
                            mImgContentFive.setImageResource(img[2]);
                            mLlContentBackSecondFive.setBackgroundColor(colors[1]);
                            mLlContentBackFirstFive.setBackgroundColor(colors[0]);
                            break;
                        default:
                            mImgContentFive.setImageResource(img[1]);
                            mLlContentBackSecondFive.setBackgroundColor(colors[3]);
                             mLlContentBackFirstFive.setBackgroundColor(colors[2]);
                            break;
                    }
                    break;
            }

        }
    }

    private void setbackcolor(WeatherBean.ResultBean.FutureBean future, int i) {


    }

    private void initView() {
        mButRefresh = (ImageView) findViewById(R.id.but_refresh);
        mTvAddress = (TextView) findViewById(R.id.tv_address);
        mTvTime = (TextView) findViewById(R.id.tv_time);
        mTvTitleTemperature = (TextView) findViewById(R.id.tv_title_temperature);
        mTvContentTimeOne = (TextView) findViewById(R.id.tv_content_time_one);
        mImgContentOne = (ImageView) findViewById(R.id.img_content_one);
        mTvContentWeatherOne = (TextView) findViewById(R.id.tv_content_weather_one);
        mTvContentTemperatureOne = (TextView) findViewById(R.id.tv_content_temperature_one);
        mLlContentBackSecondOne = (LinearLayout) findViewById(R.id.ll_content_back_second_one);
        mLlContentBackFirstOne = (LinearLayout) findViewById(R.id.ll_content_back_first_one);
        mTvContentTimeTow = (TextView) findViewById(R.id.tv_content_time_tow);
        mImgContentTow = (ImageView) findViewById(R.id.img_content_tow);
        mTvContentWeatherTow = (TextView) findViewById(R.id.tv_content_weather_tow);
        mTvContentTemperatureTow = (TextView) findViewById(R.id.tv_content_temperature_tow);
        mLlContentBackSecondTow = (LinearLayout) findViewById(R.id.ll_content_back_second_tow);
        mLlContentBackFirstTwo = (LinearLayout) findViewById(R.id.ll_content_back_first_two);
        mTvContentTimeThree = (TextView) findViewById(R.id.tv_content_time_three);
        mImgContentThree = (ImageView) findViewById(R.id.img_content_three);
        mTvContentWeatherThree = (TextView) findViewById(R.id.tv_content_weather_three);
        mTvContentTemperatureThree = (TextView) findViewById(R.id.tv_content_temperature_three);
        mLlContentBackSsecondThree = (LinearLayout) findViewById(R.id.ll_content_back_ssecond_three);
        mLlContentBackFirstThree = (LinearLayout) findViewById(R.id.ll_content_back_first_three);
        mTvContentTimeFour = (TextView) findViewById(R.id.tv_content_time_four);
        mImgContentFour = (ImageView) findViewById(R.id.img_content_four);
        mTvContentWeatherFour = (TextView) findViewById(R.id.tv_content_weather_four);
        mTvContentTemperatureFour = (TextView) findViewById(R.id.tv_content_temperature_four);
        mLlContentBackSecondFour = (LinearLayout) findViewById(R.id.ll_content_back_second_four);
        mLlContentBackFirstFour = (LinearLayout) findViewById(R.id.ll_content_back_first_four);
        mTvContentTimeFive = (TextView) findViewById(R.id.tv_content_time_five);
        mImgContentFive = (ImageView) findViewById(R.id.img_content_five);
        mTvContentWeatherFive = (TextView) findViewById(R.id.tv_content_weather_five);
        mTvContentTemperatureFive = (TextView) findViewById(R.id.tv_content_temperature_five);
        mLlContentBackSecondFive = (LinearLayout) findViewById(R.id.ll_content_back_second_five);
        mLlContentBackFirstFive = (LinearLayout) findViewById(R.id.ll_content_back_first_five);
        img = new int[]{R.mipmap.duoyun, R.mipmap.duoyunyin, R.mipmap.taiy, R.mipmap.xuayu};
        colors = new int[]{Color.parseColor("#1C88E2"), Color.parseColor("#409EE8")
                , Color.parseColor("#8FAFCE"), Color.parseColor("#A7C2D9")};
    }
}
