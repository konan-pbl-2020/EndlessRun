package com.example.endlessrun;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
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
    private ScheduledThreadPoolExecutor t = null;

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
                ImageView chara1 = (ImageView) findViewById(R.id.hidari);
                ImageView chara2 = (ImageView) findViewById(R.id.migi);
                findViewById(R.id.migi).setVisibility(View.VISIBLE);
                findViewById(R.id.hidari).setVisibility(View.INVISIBLE);
                float px1 = chara1.getTranslationX();
                float px2 = chara1.getTranslationX();
                if( px1 > 1750 ){
                    chara1.setTranslationX(-100);
                    chara2.setTranslationX(-100);
                } else {
                    chara1.setTranslationX(px1 + 15);
                    chara2.setTranslationX(px2 + 15);
                }
                return false;
            }

        });

        ImageButton leftButton = (ImageButton) findViewById(R.id.LeftButton);
        leftButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ImageView chara1 = (ImageView) findViewById(R.id.hidari);
                ImageView chara2 = (ImageView) findViewById(R.id.migi);
                findViewById(R.id.hidari).setVisibility(View.VISIBLE);
                findViewById(R.id.migi).setVisibility(View.INVISIBLE);
                float px1 = chara1.getTranslationX();
                float px2 = chara1.getTranslationX();
                if( px1 < -100 ){
                    chara1.setTranslationX(1750);
                    chara2.setTranslationX(1750);
                } else {
                    chara1.setTranslationX(px1 - 15);
                    chara2.setTranslationX(px2 - 15);
                }
                return false;
            }

        });
        t = new ScheduledThreadPoolExecutor(1);
        t.scheduleWithFixedDelay(this, 0L, 50L, TimeUnit.MILLISECONDS);
    }

    @Override
    public void run() {
        ImageView chara = (ImageView) findViewById(R.id.hidari);
        ImageView chara2 = (ImageView) findViewById(R.id.migi);
        float px = chara.getTranslationX();
        float py = chara.getTranslationY();

        //初期位置から中心に移動させる
        if( px == 0 && py == 0 ){
            chara.setTranslationX(800);
            chara.setTranslationY(750);
            chara2.setTranslationX(800);
            chara2.setTranslationY(750);
            findViewById(R.id.migi).setVisibility(View.INVISIBLE);
        }

        Random ran = new Random();

        int randomValue = ran.nextInt(1700);

        ImageView mono1 = (ImageView) findViewById(R.id.mono1);

        float mx1 = mono1.getTranslationX();
        float my1 = mono1.getTranslationY();

        if( my1 > 1000 ){
            mono1.setTranslationX(randomValue);
            my1 = -100;
        }
        mono1.setTranslationY(my1 + 50);

        //mono1との当たり判定
        if( my1 + 20 >= py - 25 && my1 - 20 <= py + 25 ) {
            if( mx1 + 20 >= px - 25 && mx1 - 20 <= px + 25 ){
                if( px != 0 && py != 0 ) {
                    t.shutdown();
                    Intent intent = new Intent(GameActivity.this, ResultActivity.class);
                    startActivity(intent);
                }
            }
        }

        ImageView mono2 = (ImageView) findViewById(R.id.mono2);
        float mx2 = mono2.getTranslationX();
        float my2 = mono2.getTranslationY();

        if( my2 > 1000 ){
            mono2.setTranslationX(randomValue);
            my2 = -100;
        }
        mono2.setTranslationY(my2 + 30);

        //mono2との当たり判定
        if( my2 + 20 >= py - 25 && my2 - 20 <= py + 25 ) {
            if( mx2 + 20 >= px - 25 && mx2 - 20 <= px + 25 ){
                if( px != 0 && py != 0 ) {
                    t.shutdown();
                    Intent intent = new Intent(GameActivity.this, ResultActivity.class);
                    startActivity(intent);
                }
            }
        }

        ImageView mono3 = (ImageView) findViewById(R.id.mono3);
        float mx3 = mono3.getTranslationX();
        float my3 = mono3.getTranslationY();

        if( my3 > 1000 ){
            mono3.setTranslationX(randomValue);
            my3 = -100;
        }
        mono3.setTranslationY(my3 + 40);

        //mono3との当たり判定
        if( my3 + 20 >= py - 25 && my3 - 20 <= py + 25 ) {
            if( mx3 + 20 >= px - 25 && mx3 - 20 <= px + 25 ){
                if( px != 0 && py != 0 ) {
                    t.shutdown();
                    Intent intent = new Intent(GameActivity.this, ResultActivity.class);
                    startActivity(intent);
                }
            }
        }

        ImageView mono4 = (ImageView) findViewById(R.id.mono4);
        float mx4 = mono4.getTranslationX();
        float my4 = mono4.getTranslationY();

        if( my4 > 1000 ){
            mono4.setTranslationX(randomValue);
            my4 = -100;
        }
        mono4.setTranslationY(my4 + 45);

        //mono4との当たり判定
        if( my4 + 20 >= py - 25 && my4 - 20 <= py + 25 ) {
            if( mx4 + 20 >= px - 25 && mx4 - 20 <= px + 25 ){
                if( px != 0 && py != 0 ) {
                    t.shutdown();
                    Intent intent = new Intent(GameActivity.this, ResultActivity.class);
                    startActivity(intent);
                }
            }
        }

        ImageView mono5 = (ImageView) findViewById(R.id.mono5);
        float mx5 = mono5.getTranslationX();
        float my5 = mono5.getTranslationY();

        if( my5 > 1000 ){
            mono5.setTranslationX(randomValue);
            my5 = -100;
        }
        mono5.setTranslationY(my5 + 35);

        //mono5との当たり判定
        if( my5 + 20 >= py - 25 && my5 - 20 <= py + 25 ) {
            if( mx5 + 20 >= px - 25 && mx5 - 20 <= px + 25 ){
                if( px != 0 && py != 0 ) {
                    t.shutdown();
                    Intent intent = new Intent(GameActivity.this, ResultActivity.class);
                    startActivity(intent);
                }
            }
        }

    }

}
