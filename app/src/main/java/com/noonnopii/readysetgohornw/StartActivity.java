package com.noonnopii.readysetgohornw;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.Button;


public class StartActivity extends WearableActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_start);

        final Button button = findViewById(R.id.start_buttonStart);
        final MediaPlayer mp = MediaPlayer.create(this, Settings.System.DEFAULT_NOTIFICATION_URI);
        final Handler handler = new Handler();
        final int readyDelay = 1500; //R.integer.readyDelay;
        final int setDelay = 3000; //R.integer.setDelay;
        final int goDelay = 4500; //R.integer.goDelay;

        button.setText(getString(R.string.start_buttonStart));

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                    button.setText(getString(R.string.start_textReady));

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            button.setText(getString(R.string.start_textSet));
                        }
                    }, readyDelay);

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            button.setText(getString(R.string.start_textGo));
                            // horn!
                            if (mp.isPlaying()) {
                                mp.stop();
                                mp.release();
                            }
                            mp.start();
                        }
                    }, setDelay);

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            finish();
                        }
                    }, goDelay);

            }
        });
    }



}
