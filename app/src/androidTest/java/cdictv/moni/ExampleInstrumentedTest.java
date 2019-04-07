package cdictv.moni;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import cdictv.moni.network.Mycall;
import cdictv.moni.network.OkhttpApi;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void show(){
        OkhttpApi.showtest("https://www.easy-mock.com/mock/5c8f3515c42b1c0235654282/jiaotong/chepai"
                , new Mycall() {
                    @Override
                    public void success(String json) {
                        System.out.println(json);
                    }

                    @Override
                    public void faild(IOException e) {
                        System.out.println(e.getMessage());
                    }
                });
    }
}
