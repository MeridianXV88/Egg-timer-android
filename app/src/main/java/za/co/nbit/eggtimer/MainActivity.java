package za.co.nbit.eggtimer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;



public class MainActivity extends AppCompatActivity {


    int minutes;
    int seconds;
    int timeIn = 27;
    int setTime = timeIn * 1000;
    MediaPlayer myPlayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myPlayer = MediaPlayer.create(this, R.raw.press_cast);
        minutes = timeIn / 60;
        seconds = timeIn % 60;

        new CountDownTimer(setTime, 1000)
        {
            public void onTick(long timeInMilliseconds)
            {
                if (minutes >= 0 && seconds >= 0) {
                    if (seconds > 0) {
                        seconds -= 1;
                    } else {
                        minutes -= 1;
                        seconds = 60;
                    }
                }
                Log.i("minutes", String.valueOf(minutes));
                Log.i("seconds", String.valueOf(seconds));

            }

            public void onFinish()
            {
                myPlayer.start();
            }
        }.start();
    }
    public void timer(int timeIn){


    }

    public void setTime (View view){

    }
}
