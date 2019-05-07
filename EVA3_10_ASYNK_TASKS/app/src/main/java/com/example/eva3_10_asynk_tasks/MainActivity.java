package com.example.eva3_10_asynk_tasks;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtVwData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwData = findViewById(R.id.txtVwData);
        MyClassAsynk myAsynk = new MyClassAsynk();
        myAsynk.execute(0);


    }

    class MyClassAsynk extends AsyncTask<Integer,String,Void>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txtVwData.setText("Iniciando tarea asíncrona \n");
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            txtVwData.append("TERMINÓ LA TAREA");
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            //Recibe los datos de doInBg
            if(values.length>0){
                txtVwData.append(values[0]);
            }

        }

        //NO SE PUEDE INTERACTUAR CON  LA UI
        //Equivalente al metodo run
        @Override
        protected Void doInBackground(Integer... integers) {
            int i = 0;
            while (i<15){
                try{
                    Thread.sleep(1000);
                    publishProgress("Hola"+i+" \n","OTRA CADENA");
                    i++;
                }catch (InterruptedException e){}
            }
            return null;
        }
    }
}
