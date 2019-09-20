package com.example.eva3_14_broadcast_receiver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    Thread myThread;
    Intent myIntent;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public void onCreate() {
        super.onCreate();
        Log.wtf("MyService","onCreate");
        myIntent = new Intent("MY_SERVICE");
        myIntent.putExtra("msg","onCreate");
        sendBroadcast(myIntent);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        myIntent.putExtra("msg","onCreate");
        sendBroadcast(myIntent);
        Log.wtf("MyService","onStart");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        myIntent.putExtra("msg","onCreate");
        sendBroadcast(myIntent);
        Log.wtf("MyService","onDestroy");
    }
}
