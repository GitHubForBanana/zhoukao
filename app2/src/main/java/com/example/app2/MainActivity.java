package com.example.app2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import view.CountDownView;

public class MainActivity extends AppCompatActivity {

    private CountDownView downText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        downText = (CountDownView) findViewById(R.id.downText);
        downText.start(this,SecondActivity.class);

        downText.setListener(new CountDownView.MyListener() {
            @Override
            public void onClick(View view) {
                //TODO 跳转
                downText.stop();//停止倒计时
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
