package com.teste.threads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button botaoInicar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoInicar = findViewById(R.id.Iniciar);
    }

    public void iniciarThread(View view){

        /*MyThread thread = new MyThread();
        thread.start();*/

        MyRunnable runnable = new MyRunnable();
        new Thread(runnable).start();
    }

    class MyRunnable implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i<= 15; i++){

                Log.d("Thread","contadorr:" + i);
                botaoInicar.setText("contador:" + i);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                    }
                });

                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e ){
                    e.printStackTrace();
                }

            }
        }
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i<= 15; i++){

                Log.d("Thread","contador:" + i);

                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e ){
                    e.printStackTrace();
                }

            }

        }
    }
}