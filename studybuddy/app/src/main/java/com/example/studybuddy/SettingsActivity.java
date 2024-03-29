package com.example.studybuddy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    private Button btnBack;
    private Button btnChangeEmail;
    private Button btnChangePassword;
    private EditText OldUsername;
    private EditText NewUsername;
    private EditText OldPassword;
    private EditText NewPassword;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        btnBack =  (Button) findViewById(R.id.btnNewBack);
        btnChangeEmail = (Button) findViewById(R.id.btnChangeEmail);
        btnChangePassword = (Button) findViewById(R.id.btnConfirm);
        OldUsername = (EditText) findViewById(R.id.edtOldUsername);
        NewUsername = (EditText) findViewById(R.id.edtNewUsername);
        OldPassword = (EditText) findViewById(R.id.edtOldPassword);
        NewPassword = (EditText) findViewById(R.id.edtNewPassword);

        btnChangeEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        btnChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBack();
            }
        });
    }


    public void goBack() {
        this.finish();
    }





}
