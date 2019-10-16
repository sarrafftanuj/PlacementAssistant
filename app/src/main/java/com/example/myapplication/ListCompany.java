package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Profile.CompanyData;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class ListCompany extends AppCompatActivity {
    FirebaseDatabase database;
    FirebaseUser user;
    FirebaseAuth mauth;
    DatabaseReference myref;
    ListView l1;
    ArrayList<String> name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_company);
        database = FirebaseDatabase.getInstance();
        myref = database.getReference("Company");
        l1 = (ListView) findViewById(R.id.company_id);
        Query query = myref;
        name =new ArrayList<String>();
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_view_layout, R.id.companyname_id, name);
        l1 = (ListView) findViewById(R.id.company_id);
        //l1.setAdapter(arrayAdapter);


        myref.child("60").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String cname = dataSnapshot.getKey();
                name.add(String.valueOf(cname));
                l1.setAdapter(arrayAdapter);

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                String stringText;
                stringText= (String)parent.getItemAtPosition(position);
                Toast.makeText(ListCompany.this,stringText,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ListCompany.this, CompanyProfile.class);
                // String message = entry.getMessage();
                intent.putExtra(EXTRA_MESSAGE, stringText.toString());
                startActivity(intent);
            }
        });


    }

}
