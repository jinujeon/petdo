package com.example.mqttandroid;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        Button closeButton = (Button) findViewById(R.id.closeButton);
        Button webButton = (Button) findViewById(R.id.webButton);

        webButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent webintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.coupang.com/np/search?component=&q=%EA%B5%AD%EC%82%B0+%EC%8C%80&channel=user"));
                startActivity(webintent);
            }
        });
        closeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
