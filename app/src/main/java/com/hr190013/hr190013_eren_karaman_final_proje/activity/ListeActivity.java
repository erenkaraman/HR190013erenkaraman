package com.hr190013.hr190013_eren_karaman_final_proje.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.cagataymuhammet.objectprinter.ObjectPrinter;
import com.hr190013.hr190013_eren_karaman_final_proje.model.Oyuncu;
import com.hr190013.hr190013_eren_karaman_final_proje.adaptor.OyuncuAdaptor;
import com.hr190013.hr190013_eren_karaman_final_proje.R;
import com.hr190013.hr190013_eren_karaman_final_proje.network.Service;
import com.hr190013.hr190013_eren_karaman_final_proje.util.Constants;
import com.hr190013.hr190013_eren_karaman_final_proje.util.ObjectUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ListeActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);
        ProgressDialog();
        init();
    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ListeActivity.this);
        builder.setTitle(getResources().getString(R.string.ListeActivity_Cikis));
        builder.setNegativeButton(getResources().getString(R.string.ListeActivity_Cikisbtn), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.setPositiveButton(getResources().getString(R.string.ListeActivity_Cikisiptalbtn), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();
    }

    private  void  init()
    {
        oyuncuGetir();
    }


    private  void  initRecycleView(List<Oyuncu>oyuncuList)
    {
        recyclerView =findViewById(R.id.rcvOyuncular);



        OyuncuAdaptor oyuncuAdaptor =new OyuncuAdaptor(oyuncuList, getApplicationContext(), new OyuncuAdaptor.OnItemClickListener() {
            @Override
            public void onClik(int position) {
                Oyuncu tiklananOyuncu=oyuncuList.get(position);
                Toast.makeText(getApplicationContext(), "Tıklanan Adı : "+ tiklananOyuncu.getAdiSoyadi(), Toast.LENGTH_SHORT).show();
                openNextActivity(tiklananOyuncu);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        recyclerView.setAdapter(oyuncuAdaptor);
    }

    private void openNextActivity(Oyuncu tiklananOyuncu){

        Intent secondActivityIntent=new Intent(getApplicationContext(), OyuncuDetayActivity.class);
        String tiklananOyuncuString= ObjectUtil.oyuncuToJsonString(tiklananOyuncu);
        secondActivityIntent.putExtra(Constants.OYUNCU_BASLIGI,tiklananOyuncuString);
        startActivity(secondActivityIntent);
    }

    void  oyuncuGetir()
    {

        new Service().getServiceApi().oyuncuGetir().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Oyuncu>>() {

                    List<Oyuncu> oyuncular=new ArrayList<>();

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("RETROFIT", "onSubscribe: ");

                    }

                    @Override
                    public void onNext(List<Oyuncu> oyuncuList) {
                        Log.e("RETROFIT", "onNext: ");
                        oyuncular=oyuncuList;
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("RETROFIT", "onError: " + e.getLocalizedMessage());

                    }

                    @Override
                    public void onComplete()
                    {
                        Log.e("RETROFIT", "onComplete: ");
                        if(oyuncular.size()>0) {

                            ObjectPrinter.printJson(oyuncular);

                            initRecycleView(oyuncular);
                        }
                    }
                });
    }
    private void ProgressDialog(){
        ProgressDialog progressDialog = new ProgressDialog(ListeActivity.this);
        progressDialog.setMessage(getResources().getString(R.string.ListeActivity_Dialog));
        progressDialog.show();
    }
}