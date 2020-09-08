package com.inihood.leardershipboard.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.inihood.leardershipboard.R;

public class SplashActivity extends AppCompatActivity {

    Thread splashTread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash);

        startAnimations();
    }
    private void startAnimations() {
        splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < 3500) {
                        sleep(100);
                        waited += 100;
                    }

                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    StartNext();
                }

            }
        };
        splashTread.start();
    }

    private void StartNext() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

}