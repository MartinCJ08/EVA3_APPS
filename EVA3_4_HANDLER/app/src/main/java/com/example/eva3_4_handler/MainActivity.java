package com.example.eva3_4_handler;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtVwMensa;
    final int HILO_CHAFA = 42;
    final int HILO_CHAFA2 = 421;

    Handler myHandle = new Handler(){
        //PERTECENE AL HILO PRINCIPAL
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //SE Puede inteRACTUAR CON LA INTERFAZ GRÁFICA, TRABAJO LIGERO

            int iVal =(int) msg.obj;
            txtVwMensa.setText("HILO CHAFA "+msg.what+" Contador: "+iVal);


        }
    };
    Runnable rHilo = new Runnable() {
        @Override
        public void run() {
            int iCont = 0;
            while(true){
                Message msgMensa = myHandle.obtainMessage(HILO_CHAFA,iCont);
                myHandle.sendMessage(msgMensa);
                iCont ++;
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){

                }
            }
        }
    };

    Runnable rHilo2 = new Runnable() {
        @Override
        public void run() {
            int iCont = 0;
            while(true){
                Message msgMensa = myHandle.obtainMessage(HILO_CHAFA,iCont);
                myHandle.sendMessage(msgMensa);
                iCont ++;
                try{
                    Thread.sleep(1500);
                }catch(InterruptedException e){

                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwMensa = findViewById(R.id.txtVwMensa);
        Thread tHilo = new Thread(rHilo);
        tHilo.start();

        Thread tHilo2 = new Thread(rHilo2);
        tHilo2.start();
    }
}
