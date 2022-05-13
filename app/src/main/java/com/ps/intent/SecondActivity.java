package com.ps.intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private Button secondBT;
private TextView nameTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        initializeViews();
    }

    private void initializeViews() {
        secondBT = findViewById(R.id.secondBT);
        nameTV = findViewById(R.id.nameTV);

        String vName=getIntent().getStringExtra("CITY_NAME");
        nameTV.setText(vName);

        secondBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondActivity.this, "You have clicked me.", Toast.LENGTH_SHORT).show();
                finish();
//                Intent intent=new Intent(SecondActivity.this, FirstActivity.class);
//                startActivity(intent);
            }
        });
    }
}