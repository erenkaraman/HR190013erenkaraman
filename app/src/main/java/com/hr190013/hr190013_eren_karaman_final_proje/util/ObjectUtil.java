package com.hr190013.hr190013_eren_karaman_final_proje.util;

import com.google.gson.Gson;
import com.hr190013.hr190013_eren_karaman_final_proje.model.Oyuncu;

public class ObjectUtil {

    public  static String oyuncuToJsonString(Oyuncu oyuncu)
    {
        Gson gson = new Gson();
        return   gson.toJson(oyuncu);
    }

    public  static Oyuncu jsonStringToOyuncu(String jsonString)
    {
        Gson gson = new Gson();
        return  gson.fromJson(jsonString,Oyuncu.class);
    }
}
