package com.example.hostello;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView logo;
    private TextView tagline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        logo = findViewById(R.id.hostello_logo);
        tagline = findViewById(R.id.tagline);

        // Start the animation
        startLogoAnimation();

        // Navigate to home after animation
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
            }
        }, 3000);
    }

    private void startLogoAnimation() {
        // Option 1: Scale + Fade + Bounce (Recommended)
        animateScaleAndBounce();

        // Option 2: Slide from top
        // animateSlideFromTop();

        // Option 3: Rotate + Scale
       // animateRotateAndScale();
    }

    // Animation Option 1: Scale up with bounce effect
    private void animateScaleAndBounce() {
        // Start invisible and small
        logo.setScaleX(0f);
        logo.setScaleY(0f);
        logo.setAlpha(0f);

        // Scale and fade in
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(logo, "scaleX", 0f, 1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(logo, "scaleY", 0f, 1f);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(logo, "alpha", 0f, 1f);

        scaleX.setDuration(1000);
        scaleY.setDuration(1000);
        alpha.setDuration(1000);

        AnimatorSet logoSet = new AnimatorSet();
        logoSet.playTogether(scaleX, scaleY, alpha);
        logoSet.setInterpolator(new OvershootInterpolator(1.5f));
        logoSet.start();

        // Animate tagline after logo
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                ObjectAnimator taglineAlpha = ObjectAnimator.ofFloat(tagline, "alpha", 0f, 1f);
                ObjectAnimator taglineY = ObjectAnimator.ofFloat(tagline, "translationY", 20f, 0f);

                taglineAlpha.setDuration(800);
                taglineY.setDuration(800);

                AnimatorSet taglineSet = new AnimatorSet();
                taglineSet.playTogether(taglineAlpha, taglineY);
                taglineSet.setInterpolator(new AccelerateDecelerateInterpolator());
                taglineSet.start();
            }
        }, 800);
    }

    // Animation Option 2: Slide from top with bounce
    private void animateSlideFromTop() {
        logo.setTranslationY(-500f);
        logo.setAlpha(0f);

        ObjectAnimator slideY = ObjectAnimator.ofFloat(logo, "translationY", -500f, 0f);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(logo, "alpha", 0f, 1f);

        slideY.setDuration(1200);
        alpha.setDuration(1200);

        AnimatorSet set = new AnimatorSet();
        set.playTogether(slideY, alpha);
        set.setInterpolator(new BounceInterpolator());
        set.start();

        // Animate tagline
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                ObjectAnimator taglineAlpha = ObjectAnimator.ofFloat(tagline, "alpha", 0f, 1f);
                taglineAlpha.setDuration(600);
                taglineAlpha.start();
            }
        }, 1000);
    }

    // Animation Option 3: Rotate and scale
    private void animateRotateAndScale() {
        logo.setScaleX(0f);
        logo.setScaleY(0f);
        logo.setRotation(-180f);
        logo.setAlpha(0f);

        ObjectAnimator scaleX = ObjectAnimator.ofFloat(logo, "scaleX", 0f, 1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(logo, "scaleY", 0f, 1f);
        ObjectAnimator rotate = ObjectAnimator.ofFloat(logo, "rotation", -180f, 0f);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(logo, "alpha", 0f, 1f);

        scaleX.setDuration(1200);
        scaleY.setDuration(1200);
        rotate.setDuration(1200);
        alpha.setDuration(1200);

        AnimatorSet set = new AnimatorSet();
        set.playTogether(scaleX, scaleY, rotate, alpha);
        set.setInterpolator(new AccelerateDecelerateInterpolator());
        set.start();

        // Animate tagline
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                ObjectAnimator taglineAlpha = ObjectAnimator.ofFloat(tagline, "alpha", 0f, 1f);
                ObjectAnimator taglineScale = ObjectAnimator.ofFloat(tagline, "scaleX", 0.8f, 1f);
                ObjectAnimator taglineScaleY = ObjectAnimator.ofFloat(tagline, "scaleY", 0.8f, 1f);

                taglineAlpha.setDuration(600);
                taglineScale.setDuration(600);
                taglineScaleY.setDuration(600);

                AnimatorSet taglineSet = new AnimatorSet();
                taglineSet.playTogether(taglineAlpha, taglineScale, taglineScaleY);
                taglineSet.start();
            }
        }, 1000);
    }
}