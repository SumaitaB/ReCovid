package com.example.recovid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.UserData;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;

public class SignUp extends AppCompatActivity {
    Button signup;
    Spinner userType;
    EditText username,useremail,userPassword,confirmPassword;
    RadioButton male,female;

    private FirebaseAuth firebaseAuth;



    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        userType=(Spinner)findViewById(R.id.userType);
        username=(EditText)findViewById(R.id.username);
        useremail=(EditText)findViewById(R.id.useremail);
        userPassword=(EditText)findViewById(R.id.userpassword);
        confirmPassword=(EditText)findViewById(R.id.confirmpassword);
        male=(RadioButton)findViewById(R.id.male);
        female=(RadioButton)findViewById(R.id.female);
        signup=(Button)findViewById(R.id.register);//always initialize uttons before using otherwise get nul point exception error

        databaseReference= FirebaseDatabase.getInstance().getReference("Users");
        firebaseAuth= FirebaseAuth.getInstance();




        String[] typesOfuser={"Patient","Recovered","Volunteer","Doctor"};
        ArrayList<String> list =new ArrayList<>(Arrays.asList(typesOfuser));
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this,R.layout.stylespinner,list);
        userType.setAdapter(arrayAdapter);





        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               final String name= username.getText().toString().trim();
               final String email= useremail.getText().toString().trim();
                final String passwordnew= userPassword.getText().toString().trim();
                final String passwordConfirm= confirmPassword.getText().toString().trim();
                String gender="";
                String usertype="";



                if(TextUtils.isEmpty(name))
                {
                    Toast toast= Toast.makeText(SignUp.this,"Please enter your name", Toast.LENGTH_LONG);
                    toast.show();



                    return;
                }

                if(TextUtils.isEmpty(email))
                {
                    Toast toast=Toast.makeText(SignUp.this,"Please enter your email", Toast.LENGTH_LONG);
                    toast.show();

                    return;
                }

                if(TextUtils.isEmpty(passwordnew))
                {
                    Toast toast=Toast.makeText(SignUp.this,"Please enter your Password", Toast.LENGTH_LONG);
                    toast.show();

                    return;
                }

                if(TextUtils.isEmpty(passwordConfirm))
                {
                    Toast toast=Toast.makeText(SignUp.this,"Please Confirm your Password", Toast.LENGTH_LONG);
                    toast.show();

                    return;
                }
                if(passwordnew.length()<8)
                {
                    Toast toast=Toast.makeText(SignUp.this,"Too Short", Toast.LENGTH_LONG); // password minimum length
                    toast.show();

                    return;
                }
                if(male.isChecked())
                {
                    gender="male";
                }
                if(female.isChecked())
                {
                    gender="female";
                }

                if(passwordnew.equals(passwordConfirm))
                {
                    final String finalGender = gender;
                    final String finaluserType=usertype;
                    firebaseAuth.createUserWithEmailAndPassword(email,passwordnew)
                            .addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {


                                        DataOfAppUsers dataOfAppUsers=new DataOfAppUsers(name,
                                                passwordnew,
                                                passwordConfirm,
                                                email, finalGender,finaluserType);

                                        FirebaseDatabase.getInstance().getReference("Users")
                                                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                                .setValue(dataOfAppUsers).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                startActivity(new Intent(getApplicationContext(),LoginPage.class));
                                                finish();
                                                Toast toast=Toast.makeText(SignUp.this,"Sign Up Complete", Toast.LENGTH_LONG);
                                                toast.show();

                                            }
                                        });









                                    }
                                    else {

                                        Toast toast=Toast.makeText(SignUp.this,"Autentication error", Toast.LENGTH_LONG);
                                        toast.show();

                                    }



                                    // ...
                                }
                            });
                }


            }
        });
    }
}
