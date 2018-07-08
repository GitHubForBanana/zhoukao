package com.example.keng.zidingyi_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import view.BitmapAndTextview;

public class MainActivity extends AppCompatActivity {
    BitmapAndTextview myview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取资源id
        myview=findViewById(R.id.myview);
        //接口回调
        myview.setMyListener(new BitmapAndTextview.MyClickListener() {
            @Override
            public void innerToast(View view) {
                Toast.makeText(getBaseContext(),"你点击了园内",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void outerToast(View view) {
                Toast.makeText(getBaseContext(),"你点击了园外 ",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
