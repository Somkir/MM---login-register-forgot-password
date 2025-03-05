
package com.example.meal_meatnew;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.imageview.ShapeableImageView;

import java.lang.annotation.Annotation;

public class Splacescreen extends AppCompatActivity {

    private ShapeableImageView imageView;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splace_screen);

        imageView = findViewById(R.id.splaceImage);
        textView = findViewById(R.id.splaceText);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation);  // Fixed the R.anim reference
        imageView.startAnimation(animation);
        textView.startAnimation(animation);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);  // Fixed the sleep usage (sleep is a static method of Thread)
                    Intent intent = new Intent(getApplicationContext(), Login.class);  // Corrected Intent usage
                    startActivity(intent);  // Start the Login activity after 3 seconds
                    finish();  // Optionally, you can call finish() to close the current activity
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();  // Start the thread
    }
}
