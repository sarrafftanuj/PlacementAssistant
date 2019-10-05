package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.String.StringCheck;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {
    EditText email,password;
    Button login,signup;
    FirebaseDatabase database;
    DatabaseReference myref;
    private FirebaseAuth mauth;
    TextView t1 ;
    StringCheck stringCheck ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = (EditText)findViewById(R.id.email_login_id);
        password = (EditText)findViewById(R.id.password_login_id);
        login=(Button)findViewById(R.id.login_button_id);
        signup = (Button)findViewById(R.id.signup_login_id);
        database  = FirebaseDatabase.getInstance();
        myref = database.getReference("message");
        mauth = FirebaseAuth.getInstance();
        stringCheck =new StringCheck();
        //        myref.setValue("Hello Tanuj");
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i  = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }
    void login(){
        String s1= email.getText().toString();
        String s2 = password.getText().toString();
            if(stringCheck.is_empty(s2,s1))
            {
            mauth.signInWithEmailAndPassword(s1, s2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Intent i = new Intent(getApplicationContext(), Home.class);
                        startActivity(i);
                        finish();
                    }else {
                        Toast.makeText(getApplicationContext(),"Email or Password Wrong",Toast.LENGTH_LONG).show();
                    }
                }
            });

        }else {
                Toast.makeText(getApplicationContext(),"Enter Email or Password First",Toast.LENGTH_SHORT).show();
            }
    }}


