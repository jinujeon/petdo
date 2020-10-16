package com.example.mqttandroid;

import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {

    private MqttAndroidClient client;
    private String TAG = "MainActivity";
    public PahoMqttClient pahoMqttClient;

    private EditText textMessage, subscribeTopic, unSubscribeTopic;
    private Button publishMessage, publishMessagebm, publishMessagecm, publishMessagedm, subscribe, unSubscribe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pahoMqttClient = new PahoMqttClient();

        //textMessage = (EditText) findViewById(R.id.textMessage);
        publishMessage = (Button) findViewById(R.id.publishMessage);
        publishMessagebm = (Button) findViewById(R.id.publishMessagebm);
        publishMessagecm = (Button) findViewById(R.id.publishMessagecm);
        publishMessagedm = (Button) findViewById(R.id.publishMessagedm);

/*        subscribe = (Button) findViewById(R.id.subscribe);
        unSubscribe = (Button) findViewById(R.id.unSubscribe);

        subscribeTopic = (EditText) findViewById(R.id.subscribeTopic);
        unSubscribeTopic = (EditText) findViewById(R.id.unSubscribeTopic);*/
        client = pahoMqttClient.getMqttClient(getApplicationContext(), "tcp://tailor.cloudmqtt.com:11470", "ExampleAndroidClient");

        publishMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    pahoMqttClient.publishMessage(client, "am", 1, "esp/kick");
                } catch (MqttException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });

        publishMessagebm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    pahoMqttClient.publishMessage(client, "bm", 1, "esp/kick");
                } catch (MqttException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });

        publishMessagecm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    pahoMqttClient.publishMessage(client, "cm", 1, "esp/kick");
                } catch (MqttException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });

        publishMessagedm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    pahoMqttClient.publishMessage(client, "dm", 1, "esp/kick");
                } catch (MqttException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });

/*        subscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String topic = subscribeTopic.getText().toString().trim();
                if (!topic.isEmpty()) {
                    try {
                        pahoMqttClient.subscribe(client, topic, 1);
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }
                }
            }
        });*/

/*        unSubscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String topic = unSubscribeTopic.getText().toString().trim();
                if (!topic.isEmpty()) {
                    try {
                        pahoMqttClient.unSubscribe(client, topic);
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }
                }
            }
        });*/

        Intent intent = new Intent(MainActivity.this, MqttMessageService.class);
        startService(intent);
    }
}