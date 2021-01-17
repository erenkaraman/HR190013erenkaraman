package com.hr190013.hr190013_eren_karaman_final_proje.network;

import com.hr190013.hr190013_eren_karaman_final_proje.model.Oyuncu;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceApi {

    //base url
    //https://raw.githubusercontent.com/erenkaraman/HR190013erenkaraman/main/takimliste.json
    @GET("takimliste.json")
    Observable<List<Oyuncu>> oyuncuGetir();
}
