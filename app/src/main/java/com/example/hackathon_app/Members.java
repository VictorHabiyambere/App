package com.example.hackathon_app;

import static android.os.Build.ID;

import static com.example.hackathon_app.MainActivity.username_ID;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Members extends AppCompatActivity {

    public static List<String> Members = new ArrayList<>();
    public static List<String> IDS2 = new ArrayList<>();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.members);
        FirebaseApp.initializeApp(this);
        listen_for_members();
    }

    public boolean is_unique(List<String> list1, String val) {
        for (String val_ : list1) {
            if (val_ == val) {
                return false;
            }
        }
        return true;
    }

    public void listen_for_members(){

        DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("Communities").child(join.ID_).child("Members");
        final Handler handler = new Handler();
        ListView listview = findViewById(R.id.ListView);
        handler.post(new Runnable() {
            @Override
            public void run() {

                db.addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        DataSnapshot ds = snapshot;
                        for(DataSnapshot child : ds.getChildren()){
                            //If it's not yourself:
                            if(child.getKey() != username_ID && is_unique(IDS2,child.getKey())) {

                                Members.add(child.child("Name").getValue().toString());
                                IDS2.add(child.getKey());

                            }
                        }
                        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                                getApplicationContext(), android.R.layout.simple_spinner_item, Members);
                        adapter.notifyDataSetChanged();
                        listview.setAdapter(adapter);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                handler.post(this);
                handler.removeCallbacks(this);
            }

        });

    }

}
