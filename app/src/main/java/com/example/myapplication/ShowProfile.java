package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.Profile.Profile;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ShowProfile extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myref;
    TextView nameTextView, hscTextView, sscTextView, aggregateTextView, phoneTextView;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_profile);
        nameTextView = (TextView) findViewById(R.id.user_name_profile_id);
        hscTextView = (TextView) findViewById(R.id.hsc_marks_profile_id);
        sscTextView = (TextView) findViewById(R.id.ssc_marks_profile_id);
        aggregateTextView = (TextView) findViewById(R.id.engi_aggre_profile_id);
        phoneTextView = (TextView) findViewById(R.id.phonenumber_profile_id);
        database = FirebaseDatabase.getInstance();
        myref = database.getReference("Users").child("67890567890");
        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Profile profile = dataSnapshot.getValue(Profile.class);
                nameTextView.setText(profile.getName());
                phoneTextView.setText(profile.getPhoneno());
                sscTextView.setText(profile.getSsc());
                hscTextView.setText(profile.getHsc());
                aggregateTextView.setText(profile.getAggregate());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
