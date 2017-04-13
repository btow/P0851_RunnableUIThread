package com.example.samsung.p0851_runnableuithread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private final String LOG_TAG = "myLogs";

    private TextView tvInfo;

    Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(2);
                runOnUiThread(runn1);
                TimeUnit.SECONDS.sleep(1);
                tvInfo.postDelayed(runn3, 2000);
                tvInfo.post(runn2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = (TextView) findViewById(R.id.tvInfo);

        thread.start();
    }

    private Runnable runn1 = new Runnable() {
        @Override
        public void run() {
            tvInfo.setText("The method \"runn1\" is runned");
        }
    };

    private Runnable runn2 = new Runnable() {
        @Override
        public void run() {
            tvInfo.setText("The method \"runn2\" is runned");
        }
    };

    private Runnable runn3 = new Runnable() {
        @Override
        public void run() {
            tvInfo.setText("The method \"runn3\" is runned");
        }
    };

}
