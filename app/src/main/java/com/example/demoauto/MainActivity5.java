package com.example.demoauto;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity5 extends AppCompatActivity implements View.OnClickListener {
    Button button3;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        button3= (Button)findViewById(R.id.button3);
        button3.setOnClickListener(this);
        button3 = (Button)  findViewById(R.id.button3);
        button3.setOnClickListener(this);
    }
    public void onClick (View view) {
        this.view = view;
        if (view.getId() == R.id.button3) {
            Intent intent = new Intent(MainActivity5.this, MainActivity4.class);
            MainActivity5.this.startActivity(intent);
        }

    }}