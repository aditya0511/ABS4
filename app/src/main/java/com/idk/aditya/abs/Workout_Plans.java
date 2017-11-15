package com.idk.aditya.abs;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.apache.http.util.ByteArrayBuffer;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Map;

public class Workout_Plans extends AppCompatActivity {
    ListView mListView;
    DatabaseReference db;
    ArrayList<String> list=new ArrayList<>();
    ArrayAdapter<String> adapter;
    TextView tx;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        db= FirebaseDatabase.getInstance().getReference().child("workouts");
        tx= findViewById(R.id.textview);

        mListView =  findViewById(R.id.listview);
        adapter= new ArrayAdapter<>(this,android.R.layout.simple_dropdown_item_1line,list);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            String s=list.get(i);
                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
                DatabaseReference ref=FirebaseDatabase.getInstance().getReference().child("workouts").child(s);
                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String x=dataSnapshot.getValue().toString();
                        x=x.replaceAll("_b","\n");
                        tx.setText(x);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                //tx.setText((CharSequence) ds.child(s).getValue());

            }
        });

        DatabaseReference ref=FirebaseDatabase.getInstance().getReference().child("workouts");
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String,String> map= (Map<String, String>) dataSnapshot.getValue();
                for(Map.Entry m:map.entrySet()){
                    list.add((String) m.getKey());

                    System.out.println(m.getKey()+" "+m.getValue());

                }
                mListView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }


}
