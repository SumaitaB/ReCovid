package com.example.recovid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class homepage extends AppCompatActivity {

    private CardView phone,textChat,foodSubscription,findDonor,consultDoc,coronaLife;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        phone=findViewById(R.id.phone);
        textChat=findViewById(R.id.message);
        foodSubscription=findViewById(R.id.foodsubscription);
        findDonor=findViewById(R.id.donor);
        consultDoc=findViewById(R.id.consult);
        coronaLife=findViewById(R.id.coronalife);

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(homepage.this,CallSomeone.class);
                startActivity(intent);

            }
        });

        textChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(homepage.this,TextSomeone.class);
                startActivity(intent);

            }
        });


        coronaLife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(homepage.this,Coronalife.class);
                startActivity(intent);

            }
        });











    }
}
