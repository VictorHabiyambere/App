package com.example.hackathon_app;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    public static String username_ID = "";
    public static String username1 = "";

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(this);
    }

    public void Login(View view) {
        String username = ((EditText) findViewById(R.id.editTextText)).getText().toString();
        String password = ((EditText) findViewById(R.id.editTextTextPassword)).getText().toString();
        FirebaseApp.initializeApp(this);
        if (!username.equals("") && !password.equals("")) {
            username1 = username;
            FirebaseAuth mAuth = FirebaseAuth.getInstance();
            mAuth.signInAnonymously().addOnCompleteListener(MainActivity.this, task -> {
                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInAnonymously:success");

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInAnonymously:failure", task.getException());
                    Toast.makeText(MainActivity.this, "Authentication failed.",
                            Toast.LENGTH_SHORT).show();
                }
            });
            FirebaseUser user = mAuth.getCurrentUser();
            if (user != null) {
                username_ID = user.getUid();
                DatabaseReference db = FirebaseDatabase.getInstance().getReference();
                db.child("Users").child(username_ID).child("Username").setValue(username);
                db.child("Users").child(username_ID).child("Password").setValue(password);
                Intent intent = new Intent(this, ma2.class);
                intent.putExtra("Username:", username);
                intent.putExtra("Password:", password);
                startActivity(intent);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$Login$0$com-ignition-hackathon_app-MainActivity  reason: not valid java name */
}
