package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.Profile.Profile;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileActivity extends AppCompatActivity {
    EditText username,userphonenumber,SscMarks,HscMarks,EngiAggr;
    FirebaseDatabase database;
    private FirebaseAuth myfirebaseauth;
    String uid;
    DatabaseReference databaseReference ;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myfirebaseauth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_profile);
        username=findViewById(R.id.user_name_id);
        userphonenumber=findViewById(R.id.user_number_id);
        SscMarks=findViewById(R.id.Ssc_marks_id);
        HscMarks=findViewById(R.id.Hsc_marks_id);
        EngiAggr=findViewById(R.id.Engi_aggre_id);
        database = FirebaseDatabase.getInstance();
        b1=(Button)findViewById(R.id.button_profile);
        databaseReference =database.getReference("Users");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setProfile();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
      //  FirebaseUser currentUser =myfirebaseauth.getCurrentUser();
       // uid = currentUser.getUid();
    }
    void setProfile()
    {
        String name = username.getText().toString();
        String phoneno=userphonenumber.getText().toString();

        String ssc=String.valueOf(SscMarks.getText().toString());
        String hsc = String.valueOf(HscMarks.getText().toString());
        String engiag = String.valueOf(EngiAggr.getText().toString());
        Profile profile =new Profile(name,ssc,hsc,engiag,phoneno);
        databaseReference.child(phoneno).setValue(profile);

    }

}
