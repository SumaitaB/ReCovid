package com.example.recovid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class CallSomeone extends AppCompatActivity {


    private Button call1,call2;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_someone);

        call1=findViewById(R.id.btn1);
        call2=findViewById(R.id.btn2);
        imageView=findViewById(R.id.image1);


        call1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CallSomeone.this, "No Numbers Available Now",
                        Toast.LENGTH_SHORT).show();
            }
        });
        call2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CallSomeone.this, "No Numbers Available Now",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
