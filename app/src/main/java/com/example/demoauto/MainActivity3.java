package com.example.demoauto;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;



public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {
    Button button;
    Button button2;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private EditText EtmailAddr, Etpassword;

    private View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        mAuth = FirebaseAuth.getInstance();
        EtmailAddr = (EditText) findViewById(R.id.editTextTextEmailAddress);
        Etpassword = (EditText) findViewById(R.id.editTextTextPassword2);
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null){

                } else {

                }
            }
        };

        button= (Button)findViewById(R.id.button);
        button.setOnClickListener(this);
        button2= (Button)findViewById(R.id.button2);
        button2.setOnClickListener(this);
    }
    public void onClick (View view) {
        this.view = view;
        if (view.getId() == R.id.button) {
            registring(EtmailAddr.getText().toString(), Etpassword.getText().toString());
        }

        if (view.getId() == R.id.button2) {
            Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
            MainActivity3.this.startActivity(intent);
        }
    }
    public void registring (String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(MainActivity3.this, "Регистрация успешна", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                    MainActivity3.this.startActivity(intent);

                }
                else {
                    Toast.makeText(MainActivity3.this, "Ошибка регистрации", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
