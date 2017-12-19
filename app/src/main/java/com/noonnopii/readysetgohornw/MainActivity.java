package com.noonnopii.readysetgohornw;

import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.Button;
import android.media.MediaPlayer;
import android.widget.TextView;

import static java.lang.Thread.State.RUNNABLE;

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

               button.setText(getString(R.string.start_startButton));
               try{
                   Thread.sleep(2000);
                   Thread.start();
                   try{
                       Thread.sleep(2000);

                       button.setText(getString(R.string.set_set));
                       try{
                           Thread.sleep(2000);
                           button.setText(getString(R.string.go_go));
                           try {
                               if (mp.isPlaying()) {
                                   mp.stop();
                                   mp.release();
                               } mp.start();
                           } catch (Exception e) {e.printStackTrace();}
                       }catch (InterruptedException e)
                       {
                           e.printStackTrace();
                       }
                   }catch (InterruptedException e)
                   {
                       e.printStackTrace();
                   }
               }catch (InterruptedException e)
               {
                   e.printStackTrace();
               }
            }
        });
    }



}
