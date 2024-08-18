package com.example.hackathon_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;

public class ma2 extends AppCompatActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        FirebaseApp.initializeApp(this);
    }

    public void VideoChat(View view) {
        startActivity(new Intent(this, VideoCall.class));
    }

    public void ComForm(View view) {
        startActivity(new Intent(this, CF.class));
    }

    public void ChatBot(View view) {
        startActivity(new Intent(this, ChatBot.class));
    }

    public void Techniques(View view) {
        startActivity(new Intent(this, Techniques.class));
    }
}
