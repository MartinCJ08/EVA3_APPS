package com.example.eva3_5_handler_post;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //MECANISMOS PARA LA SINCRONIZACIÓN
    TextView txtVwMyMsg;
    //HANDLER
    Handler hMyHandler = new Handler();
    //UN RUNNABLE QUE VA A INTERACTUAR ON LA INTERFAZ GRAFICA
    Runnable rRunInterface = new Runnable() {
        @Override
        public void run() {
            //AQUI SI PODEMOS INTERACTUAR CON LA UI
            txtVwMyMsg.append("Hello darkness\n");

        }
    };
    //UN HILO QUE HACE EL TRABAJO EN 2DO PLANO
    Thread tHiloMain = new Thread(){
        @Override
        public void run() {
            super.run();
            while (true){
                try{
                    Thread.sleep(1000);
                    hMyHandler.post(rRunInterface);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwMyMsg = findViewById(R.id.txtVwMyMsg);
        tHiloMain.start();
    }
}
