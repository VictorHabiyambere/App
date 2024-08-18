package com.example.hackathon_app;

import static android.content.ContentValues.TAG;
import static android.os.Build.ID;

import static com.example.hackathon_app.MainActivity.username_ID;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.webkit.internal.ApiFeature;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class chat extends AppCompatActivity {

    public static List<Integer> colors = new ArrayList<>();
    public static List<String> dummy = new ArrayList<>();
    public static boolean on_guard = false;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.communityspace);
        FirebaseApp.initializeApp(this);
        listen_for_messages();
    }

    public boolean is_unique(List<String> list1, String val) {
        for (String val_ : list1) {
            if (val_ == val) {
                return false;
            }
        }
        return true;
    }

    public void send_message(View view){

        EditText message = findViewById(R.id.editTextText4);
        String message_sent = message.getText().toString();
        if (message_sent.equals("")) {
            return;
        }
        DatabaseReference db = FirebaseDatabase.getInstance().getReference();
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        mAuth.signInAnonymously()
                .addOnCompleteListener(chat.this, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "signInAnonymously:success");

                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInAnonymously:failure", task.getException());
                        Toast.makeText(chat.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                    }
                });

        //Send the sent message to the real-time database
        LinearLayout linearLayout = findViewById(R.id.linearLayout5);
        TextView display = new TextView(getApplicationContext());
        display.setText(message_sent);
        DatabaseReference color = FirebaseDatabase.getInstance().getReference().child("Communities").child(join.ID_).child("Members").child(username_ID).child("Color");
        color.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                display.setBackgroundColor(Integer.valueOf(snapshot.getValue().toString()));
                display.setPadding(30, 30, 30, 30);
                display.setTextColor((ContextCompat.getColor(chat.this, R.color.black)));
                //Images take first priority when set
                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("Communities").child(join.ID_).child("Messages");
                linearLayout.addView(display);
                View view1 = new View(getApplicationContext());
                view1.setMinimumHeight(15);
                view1.setMinimumWidth(display.getWidth());
                linearLayout.addView(view1);
                db.child("Communities").child(join.ID_).child("Messages").child(username_ID).setValue(message_sent);
                message.setText("");

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void listen_for_messages(){

        DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("Communities").child(join.ID_).child("Messages");
        DatabaseReference db2 = FirebaseDatabase.getInstance().getReference().child("Communities").child(join.ID_).child("Messages").child(username_ID);

        if(db == null){
            return;
        }
        final Handler handler = new Handler();

        handler.post(new Runnable() {
            @Override
            public void run() {


                db.addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        DataSnapshot ds = snapshot;
                        int i = 0;
                        for(DataSnapshot child : ds.getChildren()){
                            //If it's not your own message:
                            if(child.getKey() != username_ID) {
                                LinearLayout linearLayout = findViewById(R.id.linearLayout5);
                                String Message = child.getValue().toString();
                                TextView display = new TextView(getApplicationContext());
                                display.setText(Message);
                                DatabaseReference color = FirebaseDatabase.getInstance().getReference().child("Communities").child(join.ID_).child("Members").child(child.getKey()).child("Color");
                                color.addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                                        if(snapshot == null){
                                            return;
                                        }

                                        display.setBackgroundColor(Integer.valueOf(snapshot.getValue().toString()));
                                        display.setPadding(30, 30, 30, 30);
                                        display.setTextColor((ContextCompat.getColor(chat.this, R.color.black)));
                                        //Images take first priority when set

                                        linearLayout.addView(display);
                                        View view1 = new View(getApplicationContext());
                                        view1.setMinimumHeight(15);
                                        view1.setMinimumWidth(display.getWidth());
                                        linearLayout.addView(view1);

                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {

                                    }
                                });
                            }
                        }
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

    public void getMembers(View view){

        Intent intent = new Intent(chat.this, Members.class);
        startActivity(intent);

    }
}
    //Now I can send messages, time to listen for messages
