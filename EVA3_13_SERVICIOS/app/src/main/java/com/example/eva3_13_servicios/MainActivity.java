package com.example.eva3_13_servicios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.eva3_13_servicios.R;

public class MainActivity extends AppCompatActivity {
    Intent myIntentService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myIntentService = new Intent(this,MyService.class);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnStart:
                startService(myIntentService);
                break;
            case R.id.btnClose:
                stopService(myIntentService);
                break;
        }
    }

}
