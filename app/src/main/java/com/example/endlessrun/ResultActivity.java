package com.example.endlessrun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Button restartButton =findViewById(R.id.RestartButton);
        restartButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent =new Intent(ResultActivity.this,StartActivity.class);
                    startActivity(intent);
            }
        });


    }
}