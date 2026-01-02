package com.example.hostello;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
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

        // Choose your animation style - uncomment ONE:

        animateScaleAndBounce();           // Option 1: Scale + Bounce (ACTIVE)
        // animateSlideFromTop();          // Option 2: Slide from top
        // animateRotateAndScale();        // Option 3: Rotate + Scale
        // animateZoomPulse();             // Option 4: Zoom Pulse
        // animateFlipIn();                // Option 5: 3D Flip
        // animateElasticBounce();         // Option 6: Elastic Bounce
        // animateFadeSlideUp();           // Option 7: Fade + Slide Up
        // animateShakeAndGrow();          // Option 8: Shake + Grow
        // animateWaveEffect();            // Option 9: Wave Effect
        // animateSpiralIn();              // Option 10: Spiral In

        // Navigate to IntroActivity after animation
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, intro.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
            }
        }, 2500);
    }

    // Option 1: Scale up with bounce
    private void animateScaleAndBounce() {
        logo.setScaleX(0f);
        logo.setScaleY(0f);
        logo.setAlpha(0f);

        ObjectAnimator scaleX = ObjectAnimator.ofFloat(logo, "scaleX", 0f, 1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(logo, "scaleY", 0f, 1f);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(logo, "alpha", 0f, 1f);

        scaleX.setDuration(1000);
        scaleY.setDuration(1000);
        alpha.setDuration(1000);

        AnimatorSet set = new AnimatorSet();
        set.playTogether(scaleX, scaleY, alpha);
        set.setInterpolator(new OvershootInterpolator(1.5f));
        set.start();

        animateTagline(800);
    }

    // Option 2: Slide from top with bounce
    private void animateSlideFromTop() {
        logo.setTranslationY(-800f);
        logo.setAlpha(0f);

        ObjectAnimator slideY = ObjectAnimator.ofFloat(logo, "translationY", -800f, 0f);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(logo, "alpha", 0f, 1f);

        slideY.setDuration(1200);
        alpha.setDuration(1200);

        AnimatorSet set = new AnimatorSet();
        set.playTogether(slideY, alpha);
        set.setInterpolator(new BounceInterpolator());
        set.start();

        animateTagline(1000);
    }

    // Option 3: Rotate and scale
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

        animateTagline(1000);
    }

    // Option 4: Zoom pulse effect
    private void animateZoomPulse() {
        logo.setScaleX(0.3f);
        logo.setScaleY(0.3f);
        logo.setAlpha(0f);

        ObjectAnimator scaleX = ObjectAnimator.ofFloat(logo, "scaleX", 0.3f, 1.2f, 1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(logo, "scaleY", 0.3f, 1.2f, 1f);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(logo, "alpha", 0f, 1f, 1f);

        scaleX.setDuration(1000);
        scaleY.setDuration(1000);
        alpha.setDuration(800);

        AnimatorSet set = new AnimatorSet();
        set.playTogether(scaleX, scaleY, alpha);
        set.setInterpolator(new DecelerateInterpolator());
        set.start();

        animateTagline(800);
    }

    // Option 5: 3D Flip in effect
    private void animateFlipIn() {
        logo.setRotationY(90f);
        logo.setAlpha(0f);

        ObjectAnimator rotateY = ObjectAnimator.ofFloat(logo, "rotationY", 90f, 0f);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(logo, "alpha", 0f, 1f);

        rotateY.setDuration(1000);
        alpha.setDuration(1000);

        AnimatorSet set = new AnimatorSet();
        set.playTogether(rotateY, alpha);
        set.setInterpolator(new DecelerateInterpolator());
        set.start();

        animateTagline(800);
    }

    // Option 6: Elastic bounce
    private void animateElasticBounce() {
        logo.setScaleX(0f);
        logo.setScaleY(0f);
        logo.setAlpha(0f);

        ObjectAnimator scaleX = ObjectAnimator.ofFloat(logo, "scaleX", 0f, 1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(logo, "scaleY", 0f, 1f);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(logo, "alpha", 0f, 1f);

        scaleX.setDuration(1500);
        scaleY.setDuration(1500);
        alpha.setDuration(1500);

        AnimatorSet set = new AnimatorSet();
        set.playTogether(scaleX, scaleY, alpha);
        set.setInterpolator(new AnticipateOvershootInterpolator(2.0f));
        set.start();

        animateTagline(1200);
    }

    // Option 7: Fade and slide up
    private void animateFadeSlideUp() {
        logo.setTranslationY(200f);
        logo.setAlpha(0f);

        ObjectAnimator slideY = ObjectAnimator.ofFloat(logo, "translationY", 200f, 0f);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(logo, "alpha", 0f, 1f);

        slideY.setDuration(1000);
        alpha.setDuration(1000);

        AnimatorSet set = new AnimatorSet();
        set.playTogether(slideY, alpha);
        set.setInterpolator(new DecelerateInterpolator());
        set.start();

        animateTagline(700);
    }

    // Option 8: Shake and grow
    private void animateShakeAndGrow() {
        logo.setScaleX(0.5f);
        logo.setScaleY(0.5f);
        logo.setAlpha(0f);

        // First grow
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(logo, "scaleX", 0.5f, 1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(logo, "scaleY", 0.5f, 1f);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(logo, "alpha", 0f, 1f);

        scaleX.setDuration(800);
        scaleY.setDuration(800);
        alpha.setDuration(800);

        AnimatorSet growSet = new AnimatorSet();
        growSet.playTogether(scaleX, scaleY, alpha);
        growSet.setInterpolator(new DecelerateInterpolator());
        growSet.start();

        // Then shake
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                ObjectAnimator shake = ObjectAnimator.ofFloat(logo, "rotation", 0f, -5f, 5f, -5f, 5f, 0f);
                shake.setDuration(500);
                shake.start();
            }
        }, 800);

        animateTagline(1000);
    }

    // Option 9: Wave effect
    private void animateWaveEffect() {
        logo.setScaleX(0f);
        logo.setScaleY(0f);
        logo.setRotation(-45f);
        logo.setAlpha(0f);

        ObjectAnimator scaleX = ObjectAnimator.ofFloat(logo, "scaleX", 0f, 1.1f, 0.9f, 1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(logo, "scaleY", 0f, 1.1f, 0.9f, 1f);
        ObjectAnimator rotate = ObjectAnimator.ofFloat(logo, "rotation", -45f, 15f, -10f, 0f);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(logo, "alpha", 0f, 1f);

        scaleX.setDuration(1200);
        scaleY.setDuration(1200);
        rotate.setDuration(1200);
        alpha.setDuration(900);

        AnimatorSet set = new AnimatorSet();
        set.playTogether(scaleX, scaleY, rotate, alpha);
        set.start();

        animateTagline(1000);
    }

    // Option 10: Spiral in
    private void animateSpiralIn() {
        logo.setScaleX(0f);
        logo.setScaleY(0f);
        logo.setRotation(720f);
        logo.setAlpha(0f);

        ObjectAnimator scaleX = ObjectAnimator.ofFloat(logo, "scaleX", 0f, 1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(logo, "scaleY", 0f, 1f);
        ObjectAnimator rotate = ObjectAnimator.ofFloat(logo, "rotation", 720f, 0f);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(logo, "alpha", 0f, 1f);

        scaleX.setDuration(1500);
        scaleY.setDuration(1500);
        rotate.setDuration(1500);
        alpha.setDuration(1200);

        AnimatorSet set = new AnimatorSet();
        set.playTogether(scaleX, scaleY, rotate, alpha);
        set.setInterpolator(new DecelerateInterpolator());
        set.start();

        animateTagline(1200);
    }

    // Helper method to animate tagline
    private void animateTagline(long delay) {
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
        }, delay);
    }
}