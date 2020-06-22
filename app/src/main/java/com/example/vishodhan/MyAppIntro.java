package com.example.vishodhan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.github.appintro.AppIntro;
import com.github.appintro.AppIntroFragment;

public class MyAppIntro extends AppIntro {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_my_app_intro);
        addSlide(AppIntroFragment.newInstance("Welcome to Now-or-Never","Our Aim is not just to win(getting placed in tech giants) bot TO WIN RIGHT,with commitment and TeamWork",R.drawable.first, ContextCompat.getColor(getApplicationContext(),R.color.firstColor)));
        addSlide(AppIntroFragment.newInstance("OUR ONLY ASKS (HONESTY)","1.Be always HONEST-To every team member and primarily to Yourself",R.drawable.second, ContextCompat.getColor(getApplicationContext(),R.color.secondColor)));
        addSlide(AppIntroFragment.newInstance("OUR ONLY ASKS (HUMBLENESS)","Be always HUMBLE-No matter what you achieve",R.drawable.third, ContextCompat.getColor(getApplicationContext(),R.color.thirdColor)));
        addSlide(AppIntroFragment.newInstance("OUR ONLY ASKS (CURIOUSITY)","Be always CURIOUS AND OPEN -To LEARNING and HARDWORKING",R.drawable.fifth, ContextCompat.getColor(getApplicationContext(),R.color.fourthColor)));


        sharedPreferences=getApplicationContext().getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        if(sharedPreferences!=null){
            boolean chechShared=sharedPreferences.getBoolean("checkStaed",false);
            if(chechShared==true){
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        }
    }

    @Override
    protected void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        //do something when user press on skip button
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        editor.putBoolean("checkStated",false).commit();

        finish();
    }

    @Override
    protected void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        editor.putBoolean("checkStated",true).commit();
    }
}