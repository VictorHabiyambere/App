package com.example.hackathon_app;

import static com.example.hackathon_app.MainActivity.username1;
import static com.example.hackathon_app.MainActivity.username_ID;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class join extends AppCompatActivity {

    public static List<String> communities = new ArrayList<>();
    public static List<String> IDS = new ArrayList<>();
    public static String ID_ = "";
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joincom);
        FirebaseApp.initializeApp(this);
        ListView listview = findViewById(R.id.Communities);
        listview.setOnItemClickListener(
                (adapter, view, position, id) -> {
                    Random rnd = new Random();
                    Integer color = Color.argb(255, rnd.nextInt(256) % 256 + 50, rnd.nextInt(256) % 256 + 50, rnd.nextInt(256) % 256 + 50);
                    //Use the list position
                    //Get the username of the friend located at that position
                    String ID = IDS.get(position);
                    ID_ = ID;
                    DatabaseReference db = FirebaseDatabase.getInstance().getReference();
                    db.child("Communities").child(ID).child("Members").child(username_ID).child("Name").setValue(username1);
                    db.child("Communities").child(ID).child("Members").child(username_ID).child("Color").setValue(String.valueOf(color));
                    Intent intent = new Intent(join.this, chat.class);
                    //based on item add info to intent
                    startActivity(intent);
                });
        listen_for_communities();
    }

    public boolean is_unique(List<String> list1, String val) {
        for (String val_ : list1) {
            if (val_ == val) {
                return false;
            }
        }
        return true;
    }

    public void listen_for_communities() {
        Handler handler = new Handler();
        DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("Communities");
        if (db != null) {
            final ListView listView = (ListView) findViewById(R.id.Communities);
            handler.post(new Runnable() {
                public void run() {
                    db.addValueEventListener(new ValueEventListener() {
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot != null) {
                                for (DataSnapshot child : snapshot.getChildren()) {
                                    if (child != null && is_unique(IDS, child.getKey())) {
                                        communities.add("Join: " + child.child("Name").getValue().toString());
                                        IDS.add(child.getKey().toString());
                                    }
                                }
                                ArrayAdapter<String> adapter = new ArrayAdapter<>(
                                        getApplicationContext(), android.R.layout.simple_spinner_item, communities);
                                adapter.notifyDataSetChanged();
                                listView.setAdapter(adapter);
                            }
                        }

                        public void onCancelled(DatabaseError error) {
                        }
                    });
                    handler.postDelayed(this, 2000);
                    handler.removeCallbacks(this);
                }
            });
        }
    }
}
