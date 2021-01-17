package com.hr190013.hr190013_eren_karaman_final_proje.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hr190013.hr190013_eren_karaman_final_proje.R;

public class GlideUtil {

    public  static  void resmiIndiripGoster(Context context, String url, ImageView img)
    {
        Glide.with(context)
                .load(url)
                .error(R.drawable.bg)
                .centerCrop()
                .into(img);
    }
}
