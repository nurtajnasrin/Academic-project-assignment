package com.example.testapp;

import static android.text.TextUtils.isEmpty;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class Registration extends AppCompatActivity {

    TextView login;
    EditText username, email, pass, conpass, phone;
    Button register;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration);

        login = findViewById(R.id.backlogin);
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.password);
        conpass = findViewById(R.id.conpassword);
        phone = findViewById(R.id.mobile);
        register = findViewById(R.id.btn_register);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String em = email.getText().toString();
                String pas = pass.getText().toString();
                String uname = username.getText().toString();
                String mobile = phone.getText().toString();

                if (isEmpty(uname)) {
                    username.setError("Name can't be empty");
                    username.requestFocus();
                } else if (isEmpty(em)) {
                    email.setError("Email can't be empty");
                    email.requestFocus();
                } else if (isEmpty(pas)) {
                    pass.setError("Password can't be empty");
                    pass.requestFocus();
                } else {
                    firebaseAuth.createUserWithEmailAndPassword(em, pas).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            UserModel userModel = new UserModel(uname, em, pas, mobile);
                            firebaseFirestore.collection("NewUser").document(FirebaseAuth.getInstance().getUid())
                                    .set(userModel);
                            Toast.makeText(Registration.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Registration.this, Login.class);
                            startActivity(intent);
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Registration.this, "Registration failed", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registration.this, Login.class);
                startActivity(intent);
            }
        });
    }
}
