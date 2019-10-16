package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Profile.CompanyData;
import com.example.myapplication.Profile.Profile;
import com.example.myapplication.String.String_method;
import com.google.android.gms.tasks.OnSuccessListener;
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
    EditText e1,e2,e3,e4,e5;
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
        e5=(EditText)findViewById(R.id.criteria_id);
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
                String cri = e5.getText().toString();
                CompanyData c=new CompanyData(cname,caddress,cphone,cri,Float.valueOf(cctc));

               myref.child(cri).child(cname).setValue(c).addOnSuccessListener(new OnSuccessListener<Void>() {
                   @Override
                   public void onSuccess(Void aVoid) {
                       Toast.makeText(getApplicationContext(),"Company Added Successfully",Toast.LENGTH_SHORT).show();
                   }
               });
            }
        });


}}
