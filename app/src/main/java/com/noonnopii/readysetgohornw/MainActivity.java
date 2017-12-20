package com.noonnopii.readysetgohornw;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends WearableActivity {

    Button buttonStart;
    Button buttonSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // open Start
        buttonStart = findViewById(R.id.main_buttonStart);
        buttonStart.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, StartActivity.class);
                startActivity(intent);
            }
        });

        // open Setting
        buttonSetting = findViewById(R.id.main_buttonSetting);
        buttonSetting.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });
    }

}
