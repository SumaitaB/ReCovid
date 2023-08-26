package com.example.recovid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class StartScreen extends AppCompatActivity {


    ImageView logo;
    TextView appname,appmoto;
    Animation upAnimation, bottomAnimation;
    private static int SPLAH_SCREEN =5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screene);

        logo=(ImageView)findViewById(R.id.logoimg);
        appname=(TextView)findViewById(R.id.appname);
        appmoto=(TextView)findViewById(R.id.appmoto);

        upAnimation= AnimationUtils.loadAnimation(this,R.anim.animation_up);
        bottomAnimation= AnimationUtils.loadAnimation(this,R.anim.animation_bottom);


        logo.setAnimation(upAnimation);
        appname.setAnimation(bottomAnimation);
        appmoto.setAnimation(bottomAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(StartScreen.this,LoginPage.class);
                startActivity(intent);
               finish();//finish() will stop startscreen so that when we press back button we don't go back to the splash screen
            }
        },SPLAH_SCREEN);


    }
}
