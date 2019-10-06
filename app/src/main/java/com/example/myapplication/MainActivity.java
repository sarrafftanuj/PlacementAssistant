package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.myapplication.R;
import com.example.myapplication.String.StringCheck;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText email,password,repassword;
    Button signup;
    FirebaseDatabase database;
    DatabaseReference myref;
    private FirebaseAuth mauth;
    TextView t1 ;
    StringCheck string_check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = (EditText)findViewById(R.id.email_id);
        password = (EditText)findViewById(R.id.password_id);
        repassword = (EditText)findViewById(R.id.password_check_id);
        signup = (Button)findViewById(R.id.signup_button_id);
        database  = FirebaseDatabase.getInstance();
        myref = database.getReference("message");
        mauth = FirebaseAuth.getInstance();
        myref.setValue("Hello Tanuj");
        t1 = (TextView)findViewById(R.id.text_result);
        signup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                signup(view);
            }
        });
    }
    void  signup(View view) {
        string_check = new StringCheck();
        String e1 = email.getText().toString();
        String e2 = password.getText().toString();
        String e3 = repassword.getText().toString();
        if (string_check.is_empty(e1, e2)) {
            if(string_check.length_of_string(e2)) {
                if (string_check.string_check(e2, e3)) {

                    mauth.createUserWithEmailAndPassword(e1, e3).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                t1.setText("complete");
                                Intent i = new Intent(getApplicationContext(),ProfileActivity.class);
                                startActivity(i);
                                finish();

                            }
                        }
                    });
                } else {
                    Toast.makeText(this, "Password Dosen't Match", Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(this, R.string.lengthError, Toast.LENGTH_LONG).show();
            }
        }
    else {
        email.setError(getString(R.string.emptyText));
            password.setError(getString(R.string.emptyText));
            repassword.setError(getString(R.string.emptyText));
    }}}

