package com.example.mqttandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.eclipse.paho.client.mqttv3.MqttException;
import java.io.UnsupportedEncodingException;

public class TempActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);

        final TextView temperature = (TextView) findViewById(R.id.temperature2);
        final TextView humidity = (TextView) findViewById(R.id.humidity2);

        Button backButton = (Button) findViewById(R.id.backButton);
        Button checkbutton = (Button) findViewById(R.id.checkbutton);
        Button templusButton = (Button) findViewById(R.id.templusButton);
        Button temminusButton = (Button) findViewById(R.id.temminusButton);
        Button humidplusButton = (Button) findViewById(R.id.humidplusButton);
        Button humidminusButton = (Button) findViewById(R.id.humidminusButton);


        //온도  +
        templusButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String number = temperature.getText().toString();
                int num = Integer.parseInt(number);
                num = num + 1;
                String temp = Integer.toString(num);
                temperature.setText(temp);
            }
        });
        //온도 -
        temminusButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String number = temperature.getText().toString();
                int num = Integer.parseInt(number);
                num = num - 1;
                String temp = Integer.toString(num);
                temperature.setText(temp);
            }
        });
        //습도  +
        humidplusButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String number = humidity.getText().toString();
                int num = Integer.parseInt(number);
                num = num + 1;
                String temp = Integer.toString(num);
                humidity.setText(temp);
            }
        });
        //습도  -
        humidminusButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String number = humidity.getText().toString();
                int num = Integer.parseInt(number);
                num = num - 1;
                String temp = Integer.toString(num);
                humidity.setText(temp);
            }
        });

        //온습도조절 페이지 종료
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //온습도 조절
        checkbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num_t = temperature.getText().toString();
                String num_h = humidity.getText().toString();
                try {
                    MenuActivity.pahoMqttClient.publishMessage(MenuActivity.client, num_t, 1, "esp/t");
                    MenuActivity.pahoMqttClient.publishMessage(MenuActivity.client, num_h, 1, "esp/h");
                } catch (MqttException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
