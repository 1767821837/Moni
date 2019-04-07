package cdictv.moni.network;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

public class OkhttpApi {
    public static void  showOkhttp(String uri,Mycall mycall){
        RequestBody body= new FormBody.Builder().build();
        Request request=new  Request.Builder().post(body)
                .url(uri).build();
        NetworkApi.request(request,mycall);
    }
    public static void  showtest(String uri,Mycall mycall){
        RequestBody body= new FormBody.Builder().add("chepai","aaa").build();
        Request request=new  Request.Builder().post(body)
                .url(uri).build();
        NetworkApi.request(request,mycall);
    }
    public static  void login(String name, String password, Mycall myCall) {

        RequestBody body = new FormBody.Builder()
                .add("username",name)
                .add("password", password)
                .build();
        Request request = new Request.Builder()
                .url("https://www.easy-mock.com/mock/5c8f3515c42b1c0235654282/jiaotong/login")
                .post(body)
                .build();
        NetworkApi.request(request,myCall);
    }
    public static  void chongzhi(String json, Mycall myCall) {
        MediaType parse = MediaType.parse("application/json;chartset=utf-8");
        RequestBody body = RequestBody.create(parse,json);
        Request request = new Request.Builder()
                .url("https://www.easy-mock.com/mock/5c8f3515c42b1c0235654282/jiaotong/recharge")
                .post(body)
                .build();
        NetworkApi.request(request,myCall);
    }

    public static  void weather(Mycall myCall) {
        MediaType parse = MediaType.parse("application/json;chartset=utf-8");
        RequestBody body = RequestBody.create(parse,"");
        Request request = new Request.Builder()
                .url("http://apis.juhe.cn/simpleWeather/query?city=%E6%88%90%E9%83%BD&key=814e668753bef85b705022af5e45a6b5")
                .get()
                .build();
        NetworkApi.request(request,myCall);
    }
}
