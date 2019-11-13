package com.example.studybuddy;


import android.util.Base64;
import android.util.Log;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class sendsms {

    public void sendsms() {
        final String ACCOUNT_SID = "ACac8c2060ed70f2ea1432f8db2c29a71f";
        final String AUTH_TOKEN = "2b47ade018f33b6365523133432ea360";

//        Thread thread = new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                try  {
//                    //Your code goes here
//
//
//                    HttpClient httpclient = new DefaultHttpClient();
//
//                    HttpPost httppost = new HttpPost(
//                            "https://api.twilio.com/2010-04-01/Accounts/ACac8c2060ed70f2ea1432f8db2c29a71f/Messages");
//                    String base64EncodedCredentials = "Basic "
//                            + Base64.encodeToString(
//                            (ACCOUNT_SID + ":" + AUTH_TOKEN).getBytes(),
//                            Base64.NO_WRAP);
//
//                    httppost.setHeader("Authorization",
//                            base64EncodedCredentials);
//                    try {
//
//                        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
//                        nameValuePairs.add(new BasicNameValuePair("From",
//                                "+16179967920"));
//                        nameValuePairs.add(new BasicNameValuePair("To",
//                                "+16178889515"));
//                        nameValuePairs.add(new BasicNameValuePair("Body",
//                                "Welcome to Twilio"));
//
//                        httppost.setEntity(new UrlEncodedFormEntity(
//                                nameValuePairs));
//
//                        // Execute HTTP Post Request
//                        HttpResponse response = httpclient.execute(httppost);
//                        HttpEntity entity = response.getEntity();
//                        System.out.println("Entity post is: "
//                                + EntityUtils.toString(entity));
//
//
//                    } catch (ClientProtocolException e) {
//
//                    } catch (IOException e) {
//
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        thread.start();


//        HttpClient httpclient = new DefaultHttpClient();
//
//        HttpPost httppost = new HttpPost(
//                "https://api.twilio.com/2010-04-01/Accounts/ACac8c2060ed70f2ea1432f8db2c29a71f/Messages");
//        String base64EncodedCredentials = "Basic "
//                + Base64.encodeToString(
//                (ACCOUNT_SID + ":" + AUTH_TOKEN).getBytes(),
//                Base64.NO_WRAP);
//
//        httppost.setHeader("Authorization",
//                base64EncodedCredentials);
//        try {
//
//            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
//            nameValuePairs.add(new BasicNameValuePair("From",
//                    "+16179967920"));
//            nameValuePairs.add(new BasicNameValuePair("To",
//                    "+16178889515"));
//            nameValuePairs.add(new BasicNameValuePair("Body",
//                    "Welcome to Twilio"));
//
//            httppost.setEntity(new UrlEncodedFormEntity(
//                    nameValuePairs));
//
//            // Execute HTTP Post Request
//            HttpResponse response = httpclient.execute(httppost);
//            HttpEntity entity = response.getEntity();
//            System.out.println("Entity post is: "
//                    + EntityUtils.toString(entity));
//
//
//        } catch (ClientProtocolException e) {
//
//        } catch (IOException e) {
//
//        }


        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    //Your code goes here

                    OkHttpClient client = new OkHttpClient();
                    String url = "https://api.twilio.com/2010-04-01/Accounts/"+ACCOUNT_SID+"/SMS/Messages";
                    String base64EncodedCredentials = "Basic " + Base64.encodeToString((ACCOUNT_SID + ":" + AUTH_TOKEN).getBytes(), Base64.NO_WRAP);

                    RequestBody body = new FormBody.Builder()
                            .add("From", "+16179967920")
                            .add("To", "+16178889515")
                            .add("Body","is this working actually")
                            .build();

                    Request request = new Request.Builder()
                            .url(url)
                            .post(body)
                            .header("Authorization", base64EncodedCredentials)
                            .build();
                    try {
                        Response response = client.newCall(request).execute();
                        Log.d("smstag", "sendSms: "+ response.body().string());
                    } catch (IOException e) { e.printStackTrace(); }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();


//        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//        Message message = Message.creator(
//                new PhoneNumber("+16179967920"),
//                new PhoneNumber("+16178889515"),
//                "Hi there!")
//                .create();
//
//        System.out.println(message.getSid());


//        HttpResponse<JsonNode> response = Unirest.post("https://api.twilio.com/2010-04-01/Accounts/ACac8c2060ed70f2ea1432f8db2c29a71f/Messages?Body=Is%20this%20working&To=+16178889515&From=+16179967920")
//                .header("content-type", "multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW")
//                .header("Authorization", "Basic QUNhYzhjMjA2MGVkNzBmMmVhMTQzMmY4ZGIyYzI5YTcxZjoyYjQ3YWRlMDE4ZjMzYjYzNjU1MjMxMzM0MzJlYTM2MA==")
//                .header("cache-control", "no-cache")
//                .header("Postman-Token", "465e9414-6e27-49ff-8517-797bc437aad0")
//                .body("------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"Body\"\r\n\r\nIs this working\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"To\"\r\n\r\n+16178889515\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"From\"\r\n\r\n+16179967920\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW--")
//                .asJson();


//        OkHttpClient client = new OkHttpClient();
//
//        MediaType mediaType = MediaType.parse("multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW");
//        RequestBody body = RequestBody.create(mediaType, "------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"Body\"\r\n\r\nIs this working\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"To\"\r\n\r\n+16178889515\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"From\"\r\n\r\n+16179967920\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW--");
//        Request request = new Request.Builder()
//                .url("https://api.twilio.com/2010-04-01/Accounts/ACac8c2060ed70f2ea1432f8db2c29a71f/Messages?Body=Is%20this%20working&To=+16178889515&From=+16179967920")
//                .post(body)
//                .addHeader("content-type", "multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW")
//                .addHeader("Authorization", "Basic QUNhYzhjMjA2MGVkNzBmMmVhMTQzMmY4ZGIyYzI5YTcxZjoyYjQ3YWRlMDE4ZjMzYjYzNjU1MjMxMzM0MzJlYTM2MA==")
//                .addHeader("cache-control", "no-cache")
//                .addHeader("Postman-Token", "5c5a26c7-dbf1-46f5-aae1-abb262556ba3")
//                .build();
//
//        Response response = client.newCall(request).execute();
    }
}

