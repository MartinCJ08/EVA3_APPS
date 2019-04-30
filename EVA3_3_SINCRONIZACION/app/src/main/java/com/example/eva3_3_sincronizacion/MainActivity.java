package com.example.eva3_3_sincronizacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtVwMensa;

    Thread tHilo = new Thread(){
        @Override
        public void run() {
            super.run();
            while (true){
                txtVwMensa.setText("MODIFICADO POR EL hilO");
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){}
            }

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwMensa = findViewById(R.id.txtVwMensa);
        txtVwMensa.setText("AQUI NO HAY PROBLEMA");
        tHilo.start();
    }
}
