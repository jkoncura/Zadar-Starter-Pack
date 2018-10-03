package com.neta.android.zadar_starterpack.viewholder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.neta.android.zadar_starterpack.R;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    public TextView itemTitle;
    public ImageView itemImage;
    public CardView cardView;

    public ItemViewHolder(View itemView) {
        super(itemView);

        itemTitle = itemView.findViewById(R.id.text_title);
        itemImage = itemView.findViewById(R.id.image_card);
        cardView = itemView.findViewById(R.id.card_view);
    }
    public void enableClick(View.OnClickListener itemClickListener){
        itemView.setOnClickListener(itemClickListener);
    }
}
