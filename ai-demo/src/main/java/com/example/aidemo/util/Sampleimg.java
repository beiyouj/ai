package com.example.aidemo.util;

import com.baidu.aip.imageclassify.AipImageClassify;
import org.json.JSONObject;

import java.util.HashMap;

public class Sampleimg {
    //设置APPID/AK/SK
    public static final String APP_ID = "47226476";
    public static final String API_KEY = "KknIWaTVl4fIQGk2wuPHalbV";
    public static final String SECRET_KEY = "656h2K7FZthDaKGTu21HEgnfkC41eLxY";

    public static void main(String[] args) {

         String APP_ID = "47226476";
         String API_KEY = "KknIWaTVl4fIQGk2wuPHalbV";
         String SECRET_KEY = "656h2K7FZthDaKGTu21HEgnfkC41eLxY";
        // 初始化一个AipImageClassify
        AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("baike_num", "5");
        // 调用接口
        String path = "D:\\UserData\\Pictures\\应天旅印.png";
        JSONObject res = client.advancedGeneral(path, new HashMap<String, String>());
        System.out.println(res.toString(2));

    }
}
