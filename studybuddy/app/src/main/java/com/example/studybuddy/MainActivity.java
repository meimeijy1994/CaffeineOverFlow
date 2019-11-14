package com.example.studybuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;

import org.apache.http.message.BasicNameValuePair;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnNewUser;
    private Button btnLogin;
    private EditText edtEmail;
    private EditText edtPassword;
    private Button btLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNewUser = (Button) findViewById(R.id.btnNewUser);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        edtEmail = (EditText)findViewById(R.id.edtEmail);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        btLocation = (Button) findViewById(R.id.btlocation);


//        HttpClient httpclient = HttpClients.createDefault();
//        HttpPost httppost = new HttpPost("https://api.twilio.com/2010-04-01/Accounts/{ACCOUNT_SID}/Messages.json");
//
//// Request parameters and other properties.
//        List<NameValuePair> params = new ArrayList<NameValuePair>(2);
//        params.add(new BasicNameValuePair("To", "+6178889515"));
//        params.add(new BasicNameValuePair("Body", "Hello!"));
//        try {
//            httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }

        //Login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //Create New User
        btnNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewUser(v);
            }
        });

        //show current user location:
        btLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start the map activity class
                //can only be tested on a physical device for actual location
                Intent myIntent = new Intent(getBaseContext(), map.class);
                startActivity(myIntent);
            }
        });

    }

    public void NewUser(View v){
        Intent newIntent = new Intent(this, CreateUserActivity.class);
        this.startActivity(newIntent);
    }

}
