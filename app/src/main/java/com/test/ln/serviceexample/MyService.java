package com.test.ln.serviceexample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import static java.lang.Thread.sleep;

/**
 * Created by ln-300 on 11/1/17.
 */

public class MyService extends Service {

    class SeparateClass implements Runnable{

        int startID;

        SeparateClass(int start){
            startID = start;
        }

        @Override
        public void run() {
            synchronized (this){
                try {
                    //Toast.makeText(getApplicationContext(),"Service started",Toast.LENGTH_SHORT).show();
                    wait(15000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //Toast.makeText(getApplicationContext(),"Service started",Toast.LENGTH_SHORT).show();
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();



    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        Toast.makeText(getApplicationContext(),"Service started",Toast.LENGTH_SHORT).show();
        Thread thread = new Thread(new SeparateClass(startId));
        thread.start();

        /*synchronized (this){
            try {
                //Toast.makeText(getApplicationContext(),"Service started",Toast.LENGTH_SHORT).show();
                wait(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"Service destroyed",Toast.LENGTH_SHORT).show();
    }
}
