package com.example.recovid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginPage extends AppCompatActivity {


    Button login,signup;
    EditText emailtxt,password;
    Spinner userType;

    FirebaseAuth firebaseAuth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login= (Button)findViewById(R.id.loginbtn);
        signup= (Button)findViewById(R.id.signupbtn);
        emailtxt=(EditText) findViewById(R.id.email);
        password=(EditText) findViewById(R.id.password);
        userType=(Spinner)findViewById(R.id.userType);
        firebaseAuth =FirebaseAuth.getInstance(); //TODO always intialize firebase auth otherwise will get null pointer exception

        String[] typesOfuser={"Patient","Recovered","Volunteer","Doctor"};
        ArrayList<String> list =new ArrayList<>(Arrays.asList(typesOfuser));
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this,R.layout.stylespinner,list);
        userType.setAdapter(arrayAdapter);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginPage.this,SignUpType.class);
                startActivity(intent);
                finish();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email= emailtxt.getText().toString().trim();
                String passwordnew= password.getText().toString().trim();

                if(TextUtils.isEmpty(email))
                {
                    Toast toast=Toast.makeText(LoginPage.this,"Please enter your email", Toast.LENGTH_LONG);
                    toast.show();

                    return;
                }

                if(TextUtils.isEmpty(passwordnew))
                {
                    Toast toast=Toast.makeText(LoginPage.this,"Please enter your Password", Toast.LENGTH_LONG);
                    toast.show();

                    return;
                }


                if(passwordnew.length()<8)
                {
                    Toast toast=Toast.makeText(LoginPage.this,"Too Short", Toast.LENGTH_LONG); // password minimum length
                    toast.show();

                    return;
                }



                firebaseAuth.signInWithEmailAndPassword(email, passwordnew)
                        .addOnCompleteListener(LoginPage.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    // Log.d(TAG, "signInWithEmail:success");

                                    FirebaseUser user = firebaseAuth.getCurrentUser();
                                    Intent intent=new Intent(LoginPage.this,homepage.class);
                                    startActivity(intent);
                                    //startActivity(new Intent(getApplicationContext(),homepage.class));
                                    //updateUI(user);
                                    finish();

                                } else {
                                    // If sign in fails, display a message to the user.
                                    //Log.w(TAG, "signInWithEmail:failure", task.getException());
                                    Toast.makeText(LoginPage.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                    //updateUI(null);
                                }

                                // ...
                            }
                        });


            }
        });


    }







}

