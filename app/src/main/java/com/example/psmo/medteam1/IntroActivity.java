package com.example.psmo.medteam1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class IntroActivity extends AppIntro {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Note here that we DO NOT use setContentView();
        int backGround = Color.parseColor("#ffa75e");

        // Add your slide fragments here.
        // AppIntro will automatically generate the dots indicator and buttons.
        addSlide(AppIntroFragment.newInstance("Start", "Naciśnij dziedzinę która cię interesuje.",
                R.drawable.wybdzial, backGround));
        addSlide(AppIntroFragment.newInstance("Start", "Wybierz algorytm który chciałbyć przejść.",
                R.drawable.wybalgorytm, backGround));
        addSlide(AppIntroFragment.newInstance("Start", "Rozpocznij pracę z algorymtmem wybierając przycisk",
                R.drawable.startalgorytmu, backGround));
        addSlide(AppIntroFragment.newInstance("Nawigacja", "Przesuwaj w lewo lub prawo we wskazanych miejscach, aby zmienić wybór.",
                R.drawable.przesuwanie, backGround));
        addSlide(AppIntroFragment.newInstance("Praca", "Niektóre kroki pozwalają na uzyskanie dodatkowych informacji.",
                R.drawable.dodatkowe, backGround));
        addSlide(AppIntroFragment.newInstance("Praca", "Zatwiedź wybór klikając w zakreślony obszar lub wykorzystaj przycisk aby wykonać krok wstecz.",
                R.drawable.praca, backGround));

        // Instead of fragments, you can also use our default slide
        // Just set a title, description, background and image. AppIntro will do the rest.
        //addSlide(AppIntroFragment.newInstance("MedicApp", "cos", R.drawable.ic_navigate_before_white, Color.WHITE));

        // OPTIONAL METHODS
        // Override bar/separator color.
        setBarColor(Color.parseColor("#FFC46B20"));
        setSeparatorColor(Color.parseColor("#ffa75e"));
        setFadeAnimation();
        // Hide Skip/Done button.
        showSkipButton(true);
        setProgressButtonEnabled(true);
        //Set Skip/Done button text
        setSkipText("Pomiń");
        setDoneText("OK");
        //set Title text on Titlebar
        this.setTitle("Pomoc");
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