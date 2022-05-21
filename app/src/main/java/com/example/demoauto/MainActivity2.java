package com.example.demoauto;


import android.content.DialogInterface;
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



    public class MainActivity2 extends AppCompatActivity implements View.OnClickListener  {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private EditText EmailAddr, Epassword;

    Button button;
    Button button2;
    private View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        EmailAddr = (EditText) findViewById(R.id.editTextTextEmailAddress);
        Epassword = (EditText) findViewById(R.id.editTextTextPassword2);

        mAuth = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null){

                } else {

                }
            }
        };

    }


    public void onClick (View view){
        this.view = view;
        if (view.getId() == R.id.button) {
            singning(EmailAddr.getText().toString(), Epassword.getText().toString());
        }

        if (view.getId() == R.id.button2) {
            Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
            MainActivity2.this.startActivity(intent);
        }
    }
    public void singning (String email, String password){
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(MainActivity2.this, "Авторизация успешна", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
                    MainActivity2.this.startActivity(intent);

                }
                else {
                    Toast.makeText(MainActivity2.this, "Ошибка авторизации", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
