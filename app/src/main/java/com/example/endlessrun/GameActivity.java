package com.example.endlessrun;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class GameActivity extends AppCompatActivity implements Runnable {
    private final Paint paint = new Paint();

    private Bitmap bitmap;

    private Rect rect;

    public GameActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        ImageButton rightButton = (ImageButton) findViewById(R.id.RightButton);
        rightButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ImageView chara = (ImageView) findViewById(R.id.chara);
                float px = chara.getTranslationX();
                if( px > 1000 ){
                    chara.setTranslationX(-950);
                } else {
                    chara.setTranslationX(px + 10);
                }
                return false;
            }

            /*public void onClick(View v) {
                ImageView chara = (ImageView) findViewById(R.id.chara);
                float px = chara.getTranslationX();
                if( px > 1000 ){
                    chara.setTranslationX(-950);
                } else {
                    chara.setTranslationX(px + 100);
                }
            }*/
        });

        ImageButton leftButton = (ImageButton) findViewById(R.id.LeftButton);
        leftButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ImageView chara = (ImageView) findViewById(R.id.chara);
                float px = chara.getTranslationX();
                if( px < -1000 ){
                    chara.setTranslationX(950);
                } else {
                    chara.setTranslationX(px - 10);
                }
                return false;
            }
            /*public void onClick(View v) {
                ImageView chara = (ImageView) findViewById(R.id.chara);
                float px = chara.getTranslationX();
                if( px < -1000 ){
                    chara.setTranslationX(950);
                } else {
                    chara.setTranslationX(px - 100);
                }
            }s*/
        });

        ScheduledThreadPoolExecutor t = new ScheduledThreadPoolExecutor(1);
        t.scheduleWithFixedDelay(this, 0L, 50L, TimeUnit.MILLISECONDS);
    }

    @Override
    public void run() {
        Random mx = new Random();
        int randomValue = mx.nextInt(1000);

        ImageView mono = (ImageView) findViewById(R.id.mono);
        float my = mono.getTranslationY();

        if( my > 1000 ){
            mono.setTranslationX(randomValue);
            my = -100;
        }
        mono.setTranslationY(my + 30);
    }

}
