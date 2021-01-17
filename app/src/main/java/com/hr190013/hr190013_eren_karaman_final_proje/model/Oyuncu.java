package com.hr190013.hr190013_eren_karaman_final_proje.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Oyuncu {

    @SerializedName("AdiSoyadi")
    @Expose
    private String adiSoyadi;
    @SerializedName("KucukResimUrl")
    @Expose
    private String resimUrl;
    @SerializedName("BuyukResimUrl")
    @Expose
    private String buyukResimUrl;
    @SerializedName("Bilgi")
    @Expose
    private String bilgi;
    @SerializedName("Mevki")
    @Expose
    private String mevki;
    @SerializedName("Yas")
    @Expose
    private String yas;

    public String getAdiSoyadi() {
        return adiSoyadi;
    }

    public void setAdiSoyadi(String adiSoyadi) {
        this.adiSoyadi = adiSoyadi;
    }

    public String getKucukResimUrl() {
        return resimUrl;
    }

    public void setKucukResimUrl(String kucukResimUrl) {
        this.resimUrl = kucukResimUrl;
    }

    public String getBuyukResimUrl() {
        return buyukResimUrl;
    }

    public void setBuyukResimUrl(String buyukResimUrl) {
        this.buyukResimUrl = buyukResimUrl;
    }

    public String getBilgi() {
        return bilgi;
    }

    public void setBilgi(String bilgi) {
        this.bilgi = bilgi;
    }

    public String getMevki() {
        return mevki;
    }

    public void setMevki(String mevki) {
        this.mevki = mevki;
    }

    public String getYas() {
        return yas;
    }

    public void setYas(String yas) {
        this.yas = yas;
    }

}
