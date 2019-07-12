package com.example.andriod.codechallenge;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

        private Button mButton1;
        private Button mButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton1 = findViewById(R.id.Button1);
        mButton2 = findViewById(R.id.Button2);
        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.Button1){
            Intent intent = new Intent(MainActivity.this, ActivityB.class);
            startActivity(intent);

        }else if (view.getId() == R.id.Button2){
            Intent intent = new Intent(MainActivity.this, ActivityC.class);
            startActivity(intent);

        }

    }
}
