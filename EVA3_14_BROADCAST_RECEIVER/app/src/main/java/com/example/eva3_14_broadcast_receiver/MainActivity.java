package com.example.eva3_14_broadcast_receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Intent myIntentService;
    TextView txtVwData;
    BroadcastReceiver myReceptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwData = findViewById(R.id.txtVwData);
        myIntentService = new Intent(this,MyService.class);
        myReceptor = new MyBroadcast();
        //Que servicio tiene qu eescuhar
        IntentFilter myFilter = new IntentFilter("My_SERVICE");
        registerReceiver(myReceptor,myFilter);

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

    class MyBroadcast extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            //AQUI INTERPTRETAMOS LOS DATOS
            //PONER LO DATOS EN EL TEXTEVIW
            String cad = intent.getStringExtra("msg");
            txtVwData.append(cad+"");
        }
    }

}


