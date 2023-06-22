package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2  extends AppCompatActivity {
    private Animation right, left;
        private TextView txt;
        private ImageView img;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main2);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
            right = AnimationUtils.loadAnimation(this, R.anim.right_animation);
            left = AnimationUtils.loadAnimation(this, R.anim.left_animation);

            txt = findViewById(R.id.txt);
            img = findViewById(R.id.img);

            txt.setAnimation(left);
            img.setAnimation(right);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, 5000);
        }
}
