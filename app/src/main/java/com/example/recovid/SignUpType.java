package com.example.recovid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignUpType extends AppCompatActivity {

   private CardView patient,recovered,doctor,volunteer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_type);

        patient= findViewById(R.id.patient);
        recovered= findViewById(R.id.recovered);
        volunteer = findViewById(R.id.volunteer);
        doctor= findViewById(R.id.doctor);

      patient.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent=new Intent(SignUpType.this,SignUp.class);
              startActivity(intent);
              finish();
          }
      });
      recovered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignUpType.this,SignUp.class);
                startActivity(intent);
            finish();}
        });


      volunteer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignUpType.this,SignUp.class);
                startActivity(intent);
            finish();}
        });
      doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignUpType.this,SignUp.class);
                startActivity(intent);
            finish();}
      });




    }
}
