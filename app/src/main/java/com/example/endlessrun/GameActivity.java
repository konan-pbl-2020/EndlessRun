package com.example.endlessrun;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class GameActivity extends AppCompatActivity implements Runnable {
    private final Paint paint = new Paint();

    private Bitmap bitmap;

    private Rect rect;

    public GameActivity() {
    }

    public GameActivity(Bitmap bitmap, int left, int top) {
        int right = left + bitmap.getWidth();
        int bottom = top + bitmap.getHeight();
        this.rect = new Rect(left, top, right, bottom);
        this.bitmap = bitmap;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ImageButton rightButton = (ImageButton) findViewById(R.id.RightButton);
        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView chara = (ImageView) findViewById(R.id.chara);
                float x = chara.getTranslationX();
                chara.setTranslationX(x + 15);
            }
        });
        ScheduledThreadPoolExecutor t = new ScheduledThreadPoolExecutor(1);
        t.scheduleWithFixedDelay(this, 0L, 50L, TimeUnit.MILLISECONDS);
    }

    @Override
    public void run() {
        ImageView chara = (ImageView) findViewById(R.id.chara);
        float x = chara.getTranslationX();
        chara.setTranslationX(x - 5);
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap, rect.left, rect.top, paint);
    }

    public void move(){ //キャラクターを右に1ずつ動かす
        rect.offset(1,0);
    }
}
