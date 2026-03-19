package com.penguinlabs.tempatureconverter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.startup.AppInitializer;

import app.rive.runtime.kotlin.RiveInitializer;

public class MainActivity extends AppCompatActivity {
    EditText ettemp;
    AppCompatButton checkbtn;
    TextView tvdisply;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ettemp = findViewById(R.id.ettemp);
        checkbtn = findViewById(R.id.checkbtn);
        tvdisply = findViewById(R.id.tvdisply);



        checkbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float temp = Float.parseFloat(ettemp.getText().toString());
                if (temp>0){

                    if (temp>=100.4){
                        tvdisply.setText("Fever");
                    } else if (temp>=99 && temp<100.4) {
                        tvdisply.setText("Low Grade Fever");
                        
                    } else if (temp>=97 && temp<99) {
                        tvdisply.setText("Normal");
                    } else if (temp>=95 && temp<97) {
                        tvdisply.setText("Low Body Temperature");
                    }
                    else {
                        tvdisply.setText("Hypothermia");
                    }


                }

            }
        });





    }
}