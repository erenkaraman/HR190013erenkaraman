package com.hr190013.hr190013_eren_karaman_final_proje.activity;
import com.hr190013.hr190013_eren_karaman_final_proje.R;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.util.Log;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if(internetKontrol()){
            init();
        }else{
           internetAlert();
        }

    }
    private void init(){
        CountDownTimer countDownTimer =new CountDownTimer(3000,1000) {
            @Override
            public void onTick(long l) {

                Log.e("COUNTER","TİCK");
            }

            @Override
            public void onFinish() {
                openNextActivity();
            }
        };

        countDownTimer.start();
    }
    private void openNextActivity(){

        Log.e("COUNTER","FİNİSH");
        Intent secondActivityIntent=new Intent(getApplicationContext(), ListeActivity.class);
        startActivity(secondActivityIntent);
        finish();
    }

    public boolean internetKontrol() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (manager.getActiveNetworkInfo() != null
                && manager.getActiveNetworkInfo().isAvailable()
                && manager.getActiveNetworkInfo().isConnected()) {
            return true;
        } else {
            return false;
        }
    }
    private void internetAlert()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(SplashActivity.this);
        builder.setTitle(getResources().getString(R.string.SplashActivity_InternetUyari));
        builder.setMessage(getResources().getString(R.string.SplashActivity_InternetUyariMetin));
        builder.setNegativeButton(getResources().getString(R.string.SplashActivity_InternetUyariBtnKapat), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setPositiveButton(getResources().getString(R.string.SplashActivity_InternetUyariBtnAc), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);

            }
        });
        builder.show();
    }

}