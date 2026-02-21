package com.example.lab6dev.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.lab6dev.MainActivity;
import com.example.lab6dev.R;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ignored) {
            }
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
        });
        thread.start();
    }
}
