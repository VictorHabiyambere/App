package com.example.hackathon_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class CF extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.community);
        FirebaseApp.initializeApp(this);
    }

    public void CreateCommunity(View view) {
        String uniqueID = UUID.randomUUID().toString();
        DatabaseReference db = FirebaseDatabase.getInstance().getReference();
        db.child("Communities").child(uniqueID).child("Name").setValue(((EditText) findViewById(R.id.editTextText2)).getText().toString());
        ((EditText) findViewById(R.id.editTextText2)).setText("");

    }

    public void JoinCommunity(View view) {
        startActivity(new Intent(this, join.class));
    }

}
