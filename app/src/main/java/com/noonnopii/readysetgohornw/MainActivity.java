package com.noonnopii.readysetgohornw;

import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.Button;
import android.media.MediaPlayer;
import android.widget.TextView;

public class MainActivity extends WearableActivity {

    private int step = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_start);

        final Button button = findViewById(R.id.button_startButton);
        final MediaPlayer mp = MediaPlayer.create(this, Settings.System.DEFAULT_NOTIFICATION_URI);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                switch (step) {
                    case 0:
                       button.setText(getString(R.string.start_startButton));
                       break;
                    case 1:
                        button.setText(getString(R.string.ready_ready));
                        break;
                    case 2:
                        button.setText(getString(R.string.set_set));
                        break;
                    case 3:
                        button.setText(getString(R.string.go_go));
                        step = 0;
                        try {
                            if (mp.isPlaying()) {
                                mp.stop();
                                mp.release();
                            } mp.start();
                        } catch (Exception e) {e.printStackTrace();}

                        break;
                    default:
                        button.setText(getString(R.string.start_startButton));
                        break;
                }
                step++;
                // this
            }
        });
    }



}
