package com.noonnopii.readysetgohornw;

import android.os.Bundle;
import android.os.Handler;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends WearableActivity {

    private TextView mTextView;
    private int step = 0;
    private int readyDur = 3000;
    private int setDur = 3000;
    private int goDur = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.text);

        Runnable mainRun = new Runnable() {
            @Override
            public void run() {
                setContentView(R.layout.activity_start);
            }
        };

        Handler mainHand = new Handler();
        mainHand.postDelayed(mainRun,1000);

        // Enables Always-on
        setAmbientEnabled();

        setContentView(R.layout.activity_start);

        final Button button = findViewById(R.id.button_startButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Runnable subRun = new Runnable() {
                    @Override
                    public void run() {
                        switch (step) {
                            case 0:
                                setContentView(R.layout.activity_start);
                                break;
                            case 1:
                                setContentView(R.layout.activity_ready);
                                break;
                            case 2:
                                setContentView(R.layout.activity_set);
                                break;
                            case 3:
                                setContentView(R.layout.activity_go);
                                break;
                            default:
                                break;
                        }
                    }
                };
                Handler subHand = new Handler();
                step++;
                subHand.post(subRun); // ready
                step++;
                subHand.postDelayed(subRun,readyDur); // ready last for 3sec then set
                step++;
                subHand.postDelayed(subRun,setDur); // set lasts for 3 sec then go
                step = 0;
                subHand.postDelayed(subRun,goDur); // go lasts for 3 sec then main
            }
        });
    }
}
