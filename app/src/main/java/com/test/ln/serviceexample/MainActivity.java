package com.test.ln.serviceexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btnStart;
    private Button btnStop,newIntent;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = (Button)findViewById(R.id.btn_start);
        btnStop = (Button)findViewById(R.id.btn_stop);
        editText = (EditText) findViewById(R.id.editText);
        newIntent = (Button) findViewById(R.id.button3);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentStart = new Intent(MainActivity.this,MyService.class);
                //startActivity(intentStart);
                startService(intentStart);


            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentStop = new Intent(MainActivity.this,MyService.class);
                stopService(intentStop);


            }
        });

        newIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent2 = new Intent(MainActivity.this,Main2Activity.class);
                //stopService(intentStop);
                startActivity(intent2);

            }
        });

    }
}
