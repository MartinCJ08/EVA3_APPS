package com.example.eva3_8_ejemplo_hilos;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    String url = "https://d1dxvryen9goi5.cloudfront.net/wp-content/uploads/2019/03/svi1cnw6bjhzlao7jogb-696x392.jpg";
    ImageView imgVwPic;
    Bitmap bImg = cargarImg(url);
    Handler myHandler = new Handler();
    final int MY_CODE = 420;
    Runnable myRunn = new Runnable() {
        @Override
        public void run() {
            imgVwPic.setImageBitmap(bImg);
        }
    };

    Thread myThread = new Thread(){
        @Override
        public void run() {
            super.run();
            bImg = cargarImg(url);
            myHandler.post(myRunn);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgVwPic = findViewById(R.id.imgVwPic);
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},MY_CODE);
        }else{
        }
        myThread.start();
    }

    private Bitmap cargarImg(String url){
        InputStream isImg = null;
        try {
            isImg = (InputStream) new URL(url).getContent();
            Bitmap myBitMap = BitmapFactory.decodeStream(isImg);
            return myBitMap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case MY_CODE:
                if(grantResults.length>0 && (grantResults[0] == PackageManager.PERMISSION_GRANTED)){
                    Toast.makeText(this,"Se tiene permisos",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this,"Nel krnl",Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }
}
