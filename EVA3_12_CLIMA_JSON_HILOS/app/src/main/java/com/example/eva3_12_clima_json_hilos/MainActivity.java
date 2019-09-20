package com.example.eva3_12_clima_json_hilos;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {
    List<Clima> myList = new ArrayList<Clima>();
    ListView lstVwCiudades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstVwCiudades = findViewById(R.id.lstVwCiudades);

        ConectionClima myConection = new ConectionClima();
        myConection.execute();
    }

    class ConectionClima extends AsyncTask<Void,Void,String>{
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(!s.equals("")){
                try {
                    JSONObject jsData = new JSONObject(s);
                    JSONArray myArrayCity = jsData.getJSONArray("list");
                    for(int i = 0;i<myArrayCity.length();i++){
                        JSONObject currentJSON = myArrayCity.getJSONObject(i);
                        Clima climona = new Clima();
                        climona.setCiudad(currentJSON.getString("name"));
                        JSONObject jsMarin = currentJSON.getJSONObject("main");
                        climona.setTemperatura(jsMarin.getDouble("temp"));

                        JSONArray ajsClimas = currentJSON.getJSONArray("weather");
                        JSONObject jsClima = currentJSON.getJSONObject("main");

                        climona.setClima(jsClima.getString("main"));
                        climona.setDesc_clima(jsClima.getString("description"));
                        int iId = jsClima.getInt("is");
                        if(iId < 300){
                            climona.setImagen_clima(R.drawable.thunderstorm);
                        }else if(iId<400){
                            climona.setImagen_clima(R.drawable.light_rain);
                        }else if(iId <600){
                            climona.setImagen_clima(R.drawable.rainy);
                        }else if(iId < 700){
                            climona.setImagen_clima(R.drawable.snow);
                        }else if(iId <800){
                            climona.setImagen_clima(R.drawable.atmospher);

                        }else if(iId < 801){
                            climona.setImagen_clima(R.drawable.sunny);
                        }else if(iId < 900){
                            climona.setImagen_clima(R.drawable.cloudy);
                        }else{
                            climona.setImagen_clima(R.drawable.tornado);
                        }

                        myList.add(climona);
                    }

                    lstVwCiudades.setAdapter(new ClimaAdapter(MainActivity.this,
                            R.layout.layout_clima,myList));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        protected String doInBackground(Void... voids) {
            //TODO: BUSCAR EL LINK openweathermap.org
            String url = "https://samples.openweathermap.org/data/2.5/find?lat=55.5&lon=37.5&cnt=10&appid=b6907d289e10d714a6e88b30761fae22";
            String sResu = "";

            //Conexion
            try {
                URL myUrl = new URL(url);
                HttpURLConnection httpCon = (HttpURLConnection) myUrl.openConnection();
                if(httpCon.getResponseCode() == HttpURLConnection.HTTP_OK){
                    BufferedReader dataJSON = new BufferedReader(
                            new InputStreamReader(
                                    httpCon.getInputStream()
                            )
                    );
                    sResu = dataJSON.readLine();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sResu;
        }
    }
}
