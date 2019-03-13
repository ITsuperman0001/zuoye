package com.bwie.shuaxin;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author：余振华
 * @E-mail： 15001194794@163.com
 * @Date：2019/3/13 18:54
 * @Description：描述信息
 */
public class HttpUtils {
    public interface CallBackA{
        void getData(String s);
    }
    public static void getAsyncTask(String url, final CallBackA backA){
        new AsyncTask<String, Void, String>() {
            @Override
            protected String doInBackground(String... strings) {
                return httpGET(strings[0]);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                backA.getData(s);
            }
        }.execute(url);
    }
    public static boolean isNetWorkConnection(Context context){
       if(context!=null){
           ConnectivityManager connectivityManager= (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
           NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
           if (networkInfo!=null){
               return networkInfo.isAvailable();
           }
       }
        return false;
    }
    public static String httpGET(String strURL){
        try {
            URL url=new URL(strURL);
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            connection.setRequestMethod("GET");
            InputStream stream=connection.getInputStream();
            BufferedReader reader=new BufferedReader(new InputStreamReader(stream));
            StringBuilder builder=new StringBuilder();
            String str="";
            while ((str=reader.readLine())!=null){
                builder.append(str);
            }
            return builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
