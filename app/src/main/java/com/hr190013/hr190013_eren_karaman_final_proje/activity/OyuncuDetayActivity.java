package com.hr190013.hr190013_eren_karaman_final_proje.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.hr190013.hr190013_eren_karaman_final_proje.R;
import com.hr190013.hr190013_eren_karaman_final_proje.model.Oyuncu;
import com.hr190013.hr190013_eren_karaman_final_proje.util.Constants;
import com.hr190013.hr190013_eren_karaman_final_proje.util.GlideUtil;
import com.hr190013.hr190013_eren_karaman_final_proje.util.ObjectUtil;

public class OyuncuDetayActivity extends AppCompatActivity {

    ImageView imgKapak;
    TextView txtBaslik;
    TextView txtDetay;
    WebView webViewGunluk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyuncu_detay);
        init();

    }

    private void init()
    {
        String tasinanOyuncuString=getIntent().getStringExtra(Constants.OYUNCU_BASLIGI);
        Oyuncu oyuncu = ObjectUtil.jsonStringToOyuncu(tasinanOyuncuString);

        imgKapak=findViewById(R.id.imgkapak);
        txtBaslik=findViewById(R.id.txtbaslik);
        txtDetay=findViewById(R.id.txtdetay);

        txtBaslik.setText(oyuncu.getAdiSoyadi());
        txtDetay.setText(oyuncu.getBilgi());

        GlideUtil.resmiIndiripGoster(getApplicationContext(),oyuncu.getBuyukResimUrl(),imgKapak);
    }
}