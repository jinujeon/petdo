package com.example.mqttandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.provider.SyncStateContract;

import android.widget.EditText;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.io.UnsupportedEncodingException;

public class MenuActivity extends AppCompatActivity {

    public static MqttAndroidClient client;
    private String TAG = "MenuActivity";
    public static PahoMqttClient pahoMqttClient;

    private EditText textMessage, subscribeTopic, unSubscribeTopic;
    private Button publishMessage, publishMessagebm, publishMessagecm, publishMessagedm, subscribe, unSubscribe;

    String tem, hum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        pahoMqttClient = new PahoMqttClient();

        //textMessage = (EditText) findViewById(R.id.textMessage);
        publishMessage = (Button) findViewById(R.id.publishMessage);
        client = pahoMqttClient.getMqttClient(getApplicationContext(), "tcp://tailor.cloudmqtt.com:11470", "ExampleAndroidClient");

        final TextView temperature2 = (TextView) findViewById(R.id.temperature2);
        final TextView humidity = (TextView) findViewById(R.id.humidity2);

        Toast.makeText(getApplicationContext(), "환영합니다", Toast.LENGTH_SHORT).show();

        ImageButton micButton = (ImageButton) findViewById(R.id.micButton);
        ImageButton reservButton = (ImageButton) findViewById(R.id.reservButton);
        ImageButton setButton = (ImageButton) findViewById(R.id.setButton);
        ImageButton tempButton = (ImageButton) findViewById(R.id.tempButton);

        //온습도조절 페이지
        tempButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent tempButton = new Intent(getApplicationContext(), TempActivity.class);
                startActivity(tempButton);
            }
        });
        //음성녹음 페이지
        micButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent micButton = new Intent(getApplicationContext(), MicActivity.class);
                startActivity(micButton);
            }
        });
        //예약페이지
        reservButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent reservButton = new Intent(getApplicationContext(), reservActivity.class);
                startActivity(reservButton);
            }
        });
        //환경설정페이지
        setButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent reservButton = new Intent(getApplicationContext(), Setting.class);
                startActivity(reservButton);
            }
        });

/*        try {
            pahoMqttClient.subscribe(client, "esp/t", 1);

*//*            client.subscribe("esp/t", 1, new IMqttMessageListener() {
                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    if (topic.equals("esp/t")){
                        tem = new String(message.getPayload());
                        temperature2.setText(tem);
                    }
                }
            });*//*
        } catch (MqttException e) {
            e.printStackTrace();
        }*/

    }
/*
    @Override
    public void connectionLost(Throwable cause) {

    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        if(topic.equals("esp/t")){
            tem = new String(message.getPayload());
            //temperature2.setText(tem);
        }
        //System.out.println("Message arrived : " + new String(message.getPayload(), "UTF-8"));
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {

    }*/
}
