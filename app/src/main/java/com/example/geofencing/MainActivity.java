package com.example.geofencing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Button button;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = editText.getText().toString();
                float num = Float.parseFloat(str);
                if(num<10){
                    Toast.makeText(MainActivity.this, "Radius should be greater than 10..", Toast.LENGTH_SHORT).show();
                }else if(num>2000){
                    Toast.makeText(MainActivity.this, "Radius should be smaller than 2000", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                    intent.putExtra("radius",num);
                    startActivity(intent);
                }

            }
        });

        editText = findViewById(R.id.editTextNumber);
        editText.setText("Geofence Radius");


    }
}