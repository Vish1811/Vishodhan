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
        addSlide(AppIntroFragment.newInstance("Welcome to COVID19Tracker","Our Aim is to provide a reliable data of Spread of CORONA VIRUS in Various Countries. #STAYHOME  #STAYSAFE #BEAWAREOFCOVID #GOCORONAGO" ,R.drawable.first, ContextCompat.getColor(getApplicationContext(),R.color.firstColor)));
        addSlide(AppIntroFragment.newInstance("(NICE DASHBOARD)","1.We provide nicely looking dashboard for easy understanding of the spread.",R.drawable.second, ContextCompat.getColor(getApplicationContext(),R.color.secondColor)));
        addSlide(AppIntroFragment.newInstance("(CHATBOT FOR AWARENESS)","We provide a AI Powered Chatbot for spreading awareness. #ASKMEANYTHINGRELATEDTOCORONA",R.drawable.third, ContextCompat.getColor(getApplicationContext(),R.color.thirdColor)));
        addSlide(AppIntroFragment.newInstance("(NEWS RELATED TO CORONA VIRUS)","News provide you the actual condition of CORONA ",R.drawable.fifth, ContextCompat.getColor(getApplicationContext(),R.color.fourthColor)));


        sharedPreferences=getApplicationContext().getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        if(sharedPreferences!=null){
            boolean checkShared=sharedPreferences.getBoolean("checkStaed",false);
            if(checkShared==true){
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