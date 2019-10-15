package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.Profile.CompanyData;
import com.example.myapplication.Profile.Profile;
import com.example.myapplication.String.String_method;
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
    EditText e1,e2,e3,e4;
    Button b1;
    ListView listView;
    Map<CompanyData, Profile> data = new HashMap<CompanyData,Profile>();
    ArrayList value ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);
        // listView=(ListView)findViewById(R.id.listview);
        textView =(TextView)findViewById(R.id.textView);
        e1=(EditText)findViewById(R.id.companyname) ;
        e2=(EditText)findViewById(R.id.companyaddress) ;
        e3=(EditText)findViewById(R.id.companyctc) ;
        e4=(EditText)findViewById(R.id.companyphone) ;
        database =FirebaseDatabase.getInstance();
        myref= database.getReference("Company");

        b1=(Button) findViewById(R.id.Add_Company);
        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String cname= e1.getText().toString();
                String caddress= e2.getText().toString();
                String cctc= e3.getText().toString();
                String cphone= e4.getText().toString();
                CompanyData c=new CompanyData(cname,caddress,cphone,"60%",Float.valueOf(cctc));

               myref.child("60%").setValue(c);
            }
        });
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
