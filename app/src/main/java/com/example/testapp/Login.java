package com.example.testapp;

import static android.text.TextUtils.isEmpty;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    Button btn_login;
    TextView signup;
    EditText email, pass;
    FirebaseAuth firebaseAuth;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize views
        btn_login = findViewById(R.id.btn_login);
        signup = findViewById(R.id.backsignup);
        email = findViewById(R.id.logemail);
        pass = findViewById(R.id.logpass);
        firebaseAuth = FirebaseAuth.getInstance();

        // Set up click listener for signup
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Registration.class);
                startActivity(intent);
                finish();
            }
        });

        // Set up click listener for login
       btn_login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String Email = email.getText().toString();
               String password = pass.getText().toString();

               if (isEmpty(Email)) {
                   email.setError("Email can't empty");
                   pass.requestFocus();
               } else if (isEmpty(password)) {
                   pass.setError("password can't empty");
                   pass.requestFocus();
               } else {

                       firebaseAuth.signInWithEmailAndPassword(Email, password)
                               .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                   @Override
                                   public void onSuccess(AuthResult authResult) {

                                       Intent intent = new Intent(Login.this, Home.class);
                                       startActivity(intent);
                                       finish();


                                       Toast.makeText(Login.this, " LogIn Successful", Toast.LENGTH_SHORT).show();


                                   }
                               })
                               .addOnFailureListener(new OnFailureListener() {
                                   @Override
                                   public void onFailure(@NonNull Exception e) {
                                       Toast.makeText(Login.this, " LogIn Failed", Toast.LENGTH_LONG).show();





                                   }
                               });


                   }


               }
       });
    }
}
