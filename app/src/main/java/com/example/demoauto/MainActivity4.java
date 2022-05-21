package com.example.demoauto;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity implements View.OnClickListener {
    Button button11;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        button11= (Button)findViewById(R.id.button11);
        button11.setOnClickListener(this);
        button11 = (Button)  findViewById(R.id.button11);
        button11.setOnClickListener(this);


    }
    public void onClick (View view) {
        this.view = view;
        if (view.getId() == R.id.button11) {
            Intent intent = new Intent(MainActivity4.this, MainActivity5.class);
            MainActivity4.this.startActivity(intent);
        }

    }}