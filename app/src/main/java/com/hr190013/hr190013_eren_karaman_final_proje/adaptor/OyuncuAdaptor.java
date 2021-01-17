package com.hr190013.hr190013_eren_karaman_final_proje.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hr190013.hr190013_eren_karaman_final_proje.R;
import com.hr190013.hr190013_eren_karaman_final_proje.model.Oyuncu;
import com.hr190013.hr190013_eren_karaman_final_proje.util.GlideUtil;

import java.util.List;

public class OyuncuAdaptor extends RecyclerView.Adapter<OyuncuViewHolder> {


    List<Oyuncu> oyuncular;
    Context context;
    OnItemClickListener listener;

    public interface  OnItemClickListener
    {
        void onClik(int position);
    }


    public OyuncuAdaptor(List<Oyuncu> oyuncular, Context context,OnItemClickListener listener) {
        this.oyuncular = oyuncular;
        this.context = context;
        this.listener=listener;
    }

    @NonNull
    @Override
    public OyuncuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_oyuncu,parent,false);
        return new OyuncuViewHolder(itemView,listener );
    }

    @Override
    public void onBindViewHolder(@NonNull OyuncuViewHolder viewHolder, int position) {

        viewHolder.txtMevki.setText(oyuncular.get(position).getMevki());
        viewHolder.txtIsim.setText(oyuncular.get(position).getAdiSoyadi());
        viewHolder.txtYas.setText(oyuncular.get(position).getYas());

        GlideUtil.resmiIndiripGoster(context,oyuncular.get(position).getKucukResimUrl(),viewHolder.imgOyuncu);

    }

    @Override
    public int getItemCount() {
        return oyuncular.size();
    }
}
