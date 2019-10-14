package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.Profile.CompanyData;
import com.example.myapplication.Profile.Profile;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Company extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myref;
    ArrayAdapter adapter;
    String [] user={"abcd","b","c","d"};
    TextView textView;
    ListView listView;
    Map<CompanyData, Profile> data = new HashMap<CompanyData,Profile>();
    ArrayList value ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);
         listView=(ListView)findViewById(R.id.listView);
        textView =(TextView)findViewById(R.id.textView);

        database =FirebaseDatabase.getInstance();
        myref= database.getReference("Users");
        //adapter=new ArrayAdapter(getApplicationContext(),R.layout.listlayout,R.id.textView,data);
        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                data = (Map)dataSnapshot.getValue();

                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });

    }
}
