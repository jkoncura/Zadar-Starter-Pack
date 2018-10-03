package com.neta.android.zadar_starterpack.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.neta.android.zadar_starterpack.CuisineItemActivity;
import com.neta.android.zadar_starterpack.R;
import com.neta.android.zadar_starterpack.models.Item;
import com.neta.android.zadar_starterpack.viewholder.ItemViewHolder;

import java.util.List;

public class CuisineAdapter extends RecyclerView.Adapter<ItemViewHolder>{

    private static final String TAG = "CuisineAdapter";

    static final String EXTRA_TITLE = "com.neta.android.zadar_starterpack.adapters.EXTRA_TITLE";
    static final String EXTRA_DESCRIPTION = "com.neta.android.zadar_starterpack.adapters.EXTRA_DESCRIPTION";
    static final String EXTRA_IMAGE = "com.neta.android.zadar_starterpack.adapters.EXTRA_IMAGE";
    static final String EXTRA_COLOR = "com.neta.android.zadar_starterpack.adapters.EXTRA_COLOR";
    static final String EXTRA_FAB = "com.neta.android.zadar_starterpack.adapters.EXTRA_FAB";
    static final String EXTRA_WEB_PAGE_URL = "com.neta.android.zadar_starterpack.adapters.EXTRA_WEB_PAGE_URL";


    private Context mContext;
    private List<Item> mItems;


    public CuisineAdapter(Context mContext, List<Item> mItems){
        this.mContext = mContext;
        this.mItems = mItems;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        View view = mInflater.inflate(R.layout.item_cardview,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemViewHolder holder, final int position) {
        final Item item = mItems.get(position);
        holder.itemTitle.setText(item.getTitle());
        Glide.with(mContext)
                .asBitmap()
                .load(mItems.get(position).getImageResourceId())
                .into(holder.itemImage);
        holder.enableClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, CuisineItemActivity.class);
                intent.putExtra(EXTRA_TITLE, item.getTitle());
                intent.putExtra(EXTRA_DESCRIPTION, item.getDescription());
                intent.putExtra(EXTRA_IMAGE, item.getImageResourceId());
                intent.putExtra(EXTRA_COLOR, item.getCategoryColor());
                intent.putExtra(EXTRA_FAB, item.getImageLocationResourceId());
                intent.putExtra(EXTRA_WEB_PAGE_URL,item.getWebPageUrl());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

}
