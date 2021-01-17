package com.hr190013.hr190013_eren_karaman_final_proje.adaptor;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hr190013.hr190013_eren_karaman_final_proje.R;

public class OyuncuViewHolder extends RecyclerView.ViewHolder {

        ImageView imgOyuncu;
        TextView txtIsim;
        TextView txtMevki;
        TextView txtYas;


public OyuncuViewHolder(@NonNull View itemView, OyuncuAdaptor.OnItemClickListener listener) {
        super(itemView);

        imgOyuncu =itemView.findViewById(R.id.imgHoca);
        txtIsim =itemView.findViewById(R.id.txtIsim);
        txtMevki =itemView.findViewById(R.id.txtMevki);
        txtYas =itemView.findViewById(R.id.txtYas);

        itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        listener.onClik((getAdapterPosition()));
                }
        });
        }

}
