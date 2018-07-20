package com.hongfans.aop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.hongfans.libaop.annotation.Around;
import com.hongfans.libaop.annotation.DebugTrace;
import com.hongfans.libaop.annotation.Ret;

public class MainActivity extends AppCompatActivity {

    @DebugTrace
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.tv_main).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "click", Toast.LENGTH_SHORT).show();
                testAnnotatedMethod("传入参数", v, 100);

                getVal("语点跳到到了点播");
            }
        });
    }

    @Around("test 方法的标记")
    @DebugTrace
    private void testAnnotatedMethod(String str, View view, int pos) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Ret("获取返回值")
    public String getVal(String input){

        return "get " + input;
    }
}
