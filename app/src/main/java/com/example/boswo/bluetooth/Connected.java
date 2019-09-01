package com.example.boswo.bluetooth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Connected extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connected);

        String adress = getIntent().getStringExtra("Mac");
        TextView textView = (TextView)findViewById(R.id.connectedResult);
        textView.setText(adress);
    }
}
