package com.example.psmo.medteam1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntro2;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class IntroActivity extends AppIntro {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Note here that we DO NOT use setContentView();

        // Add your slide fragments here.
        // AppIntro will automatically generate the dots indicator and buttons.
        addSlide(AppIntroFragment.newInstance("Nawigacja", "Aby poruszać się po algorytmach wykorzystaj...",
                R.drawable.ic_done_white, Color.parseColor("#1976D2")));
        addSlide(AppIntroFragment.newInstance("Praca", "W trakcie pracy z algorytmem możesz...",
                R.drawable.ic_done_white, Color.parseColor("#1976D2")));
        addSlide(AppIntroFragment.newInstance("Zakończenie algorytmu", "Po zakończeniu algorytmu...",
                R.drawable.ic_done_white, Color.parseColor("#1976D2")));

        // Instead of fragments, you can also use our default slide
        // Just set a title, description, background and image. AppIntro will do the rest.
        //addSlide(AppIntroFragment.newInstance("MedicApp", "cos", R.drawable.ic_navigate_before_white, Color.WHITE));

        // OPTIONAL METHODS
        // Override bar/separator color.
        setBarColor(Color.parseColor("#3F51B5"));
        setSeparatorColor(Color.parseColor("#2196F3"));
        setFadeAnimation();
        // Hide Skip/Done button.
        showSkipButton(true);
        setProgressButtonEnabled(true);
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        finish();
        // /super.onSkipPressed(currentFragment);
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        finish();
        //super.onDonePressed(currentFragment);
        // Do something when users tap on Done button.
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        //super.onSlideChanged(oldFragment, newFragment);
        // Do something when the slide changes.
    }

}