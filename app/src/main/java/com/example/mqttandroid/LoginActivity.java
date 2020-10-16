package com.example.mqttandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.d("ACTIVITY_LOGIN", "onCreate 호출됨");
        Toast.makeText(getApplicationContext(), "환영합니다", Toast.LENGTH_SHORT).show();

        Button loginbutton = (Button) findViewById(R.id.loginbutton);
        Button joinbutton = (Button) findViewById(R.id.joinbutton);
        Button findidbutton = (Button) findViewById(R.id.findidbutton);
        Button findpwbutton = (Button) findViewById(R.id.findpwbutton);

        loginbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent loginintent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(loginintent);
            }
        });

        joinbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent joinintent = new Intent(getApplicationContext(), JoinActivity.class);
                startActivity(joinintent);
            }
        });

        findidbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent findidintent = new Intent(getApplicationContext(), FindidActivity.class);
                startActivity(findidintent);
            }
        });

        findpwbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent findpwintent = new Intent(getApplicationContext(), FindpwActivity.class);
                startActivity(findpwintent);
            }
        });
    }
}
