package com.example.aidemo.util;

import java.util.*;
import org.json.JSONObject;
import com.baidu.aip.ocr.AipOcr;
public class Sample {
    //设置APPID/AK/SK
    public static final String APP_ID = "47225987";
    public static final String API_KEY = "o1rFcMabZpD8wmHh4CuszOlq";
    public static final String SECRET_KEY = "Up5TOVjI6ulzjqB1HzzTWDjN06UQwm1K";

    public static void main(String[] args) {

        String APP_ID = "47225987";
        String API_KEY = "o1rFcMabZpD8wmHh4CuszOlq";
         String SECRET_KEY = "Up5TOVjI6ulzjqB1HzzTWDjN06UQwm1K";
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);


        String path = "D:\\UserData\\Pictures\\正面.jpg";
        JSONObject res = client.basicGeneral(path, new HashMap<String, String>());
        System.out.println(res.toString(2));

    }
}
