package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.Profile.CompanyData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class CompanyProfile extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5;
    FirebaseDatabase database;
    DatabaseReference myref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_profile);
        Intent intent = getIntent();
        final String str = intent.getStringExtra (EXTRA_MESSAGE);
        t1 =(TextView)findViewById(R.id.company_profile_name_id);
        t2=(TextView)findViewById(R.id.company_add_profile_id);
        t3=(TextView)findViewById(R.id.company_profile_contact_id);
        t4=(TextView)findViewById(R.id.eligibility_profile_id);
        t5=(TextView)findViewById(R.id.ctc_profile_id);
        database=FirebaseDatabase.getInstance();
        myref=database.getReference("Company");
        myref.child("60").child(str).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                CompanyData data =dataSnapshot.getValue(CompanyData.class);

                t1.setText(String.valueOf(data.getName()));
                t2.setText(data.getAdd());
                t3.setText(data.getContactno());
                t4.setText(data.getCriteria());
                t5.setText(String.valueOf(data.getCtc()));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }
}
