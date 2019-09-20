package com.example.ortografianuevo;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

/***
 * Armas, genes y de acero
 */
public class MainActivity extends AppCompatActivity {


    private EditText etxtText;
    private TextView txtWords, txtErrors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etxtText = findViewById(R.id.etxtTexto);
        txtWords = findViewById(R.id.txtWords);
        txtErrors = findViewById(R.id.txtErrors);

//        threadWords.start();
//        threadErrors.start();

        MyHilo myHilo = new MyHilo();
        myHilo.execute(null, null, null);
    }



    class MyHilo extends AsyncTask<Void,Integer,Void> {
        int palabras=1;
        int errors = 0;
        String text1 ="";
        String text2 = "";

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            text1 = etxtText.getText().toString();

            text2 = etxtText.getText().toString();

        }

        @Override
        protected Void doInBackground(Void... voids) {
            while (true){
                try {

                    Thread.sleep(500);
                    for (int i = 0; i < text1.length(); i++) {
                        if((i+1) < text1.length()){
                            if (text1.charAt(i) == 32 && text1.charAt(i+1) != 32) {
                                palabras++;
                            }
                        }
                    }

                    for(int i = 0; i < text2.length(); i++){
                        if((text2.charAt(i)== 'c') || (text2.charAt(i)== 'C')){
                            if((i+3) < text2.length()){
                                if((text2.charAt(i+1)=='i'&&text2.charAt(i+2)=='o' && text2.charAt(i+3)=='n')|| (text2.charAt(i+1)=='I'&&text2.charAt(i+2)=='O' && text2.charAt(i+3)=='N')){
                                    errors++;
                                }
                            }
                        }
                    }



                    publishProgress(palabras,errors);


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }


        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            int errors2 = values[1];
            int palabras2 = values[0];

            text1 = etxtText.getText().toString();

            text2 = etxtText.getText().toString();

            txtErrors.setText("Errores: " + errors2);
            if (text1.length() == 0) {
                txtWords.setText("Palabras: 0");
            } else {
                txtWords.setText("Palabras: " + palabras2);
            }

            palabras =1;
            errors = 0;

        }
    }
}

