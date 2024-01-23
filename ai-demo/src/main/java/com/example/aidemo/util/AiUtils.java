package com.example.aidemo.util;

import com.baidu.aip.imageclassify.AipImageClassify;
import com.baidu.aip.nlp.AipNlp;
import com.baidu.aip.ocr.AipOcr;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

public class AiUtils {


    public static String img(MultipartFile file) throws IOException {
        {

            String APP_ID = "47226476";
            String API_KEY = "KknIWaTVl4fIQGk2wuPHalbV";
            String SECRET_KEY = "656h2K7FZthDaKGTu21HEgnfkC41eLxY";
            // 初始化一个AipImageClassify
            AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);

            // 可选：设置网络连接参数
            client.setConnectionTimeoutInMillis(2000);
            client.setSocketTimeoutInMillis(60000);


            HashMap<String, String> options = new HashMap<String, String>();
            options.put("baike_num", "5");
            // 调用接口
//            String path = "D:\\UserData\\Pictures\\应天旅印.png";
            JSONObject res = client.advancedGeneral(file.getBytes(), new HashMap<String, String>());
            JSONObject result = res.getJSONArray("result").getJSONObject(0);
String s= "这张图"+ result.getDouble("score")*100+"%的可能是"+result.getString("root")+"-"+result.getString("keyword");
//            System.out.println(res.toString(2));



            return s;
        }
    }

    public static String word(MultipartFile file) throws IOException {
        String APP_ID = "47225987";
        String API_KEY = "o1rFcMabZpD8wmHh4CuszOlq";
        String SECRET_KEY = "Up5TOVjI6ulzjqB1HzzTWDjN06UQwm1K";
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);


//        String path = "D:\\UserData\\Pictures\\正面.jpg";
        JSONObject res = client.basicGeneral(file.getBytes(), new HashMap<String, String>());
//            System.out.println(res.toString(2));
        JSONArray jsonArray = res.getJSONArray("words_result");
        StringBuffer sb =new StringBuffer();
        for(int i=0;i<jsonArray.length();i++){
            sb.append(jsonArray.getJSONObject(i).getString("words")).append("\n");
        }
        return sb.toString();
    }

    public static String nlp(String text) {

        String APP_ID = "47226967";
        String API_KEY = "fcAzfOiRQS8GeS1HH9lXiErk";
        String SECRET_KEY = "9hsxcArkAC1Z5xyuygs6on19zaL5lYvY";
        // 初始化一个 AipNlp
        AipNlp client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);


        // 调用接口

        JSONObject res = client.ecnet(text, null);
//            System.out.println(res.toString(2));
        String res1 = res.getJSONObject("item").getString("correct_query");

        return res1;
    }

    public static void main(String[] args) {
//        String text = "百度是一家人工只能公司";
//        System.out.println(nlp(text));
    }
}
