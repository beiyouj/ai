package com.example.aidemo.util;

import com.baidu.aip.nlp.AipNlp;
import org.json.JSONObject;

public class Samplenlp {



    //设置 APPID/AK/SK
    public static final String APP_ID = "47226967";
    public static final String API_KEY = "fcAzfOiRQS8GeS1HH9lXiErk";
    public static final String SECRET_KEY = "9hsxcArkAC1Z5xyuygs6on19zaL5lYvY";

    public static void main(String[] args) {


         String APP_ID = "47226967";
         String API_KEY = "fcAzfOiRQS8GeS1HH9lXiErk";
         String SECRET_KEY = "9hsxcArkAC1Z5xyuygs6on19zaL5lYvY";
        // 初始化一个 AipNlp
        AipNlp client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);


        // 调用接口
        String text = "百度是一家人工只能公司";
        JSONObject res = client.ecnet(text, null);
        System.out.println(res.toString(2));

    }
}