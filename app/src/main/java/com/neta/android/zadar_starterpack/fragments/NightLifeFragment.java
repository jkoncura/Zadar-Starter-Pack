package com.neta.android.zadar_starterpack.fragments;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.neta.android.zadar_starterpack.adapters.NightLifeAdapter;
import com.neta.android.zadar_starterpack.models.Item;
import com.neta.android.zadar_starterpack.R;

import java.util.ArrayList;
import java.util.List;

public class NightLifeFragment extends Fragment {

    private static final String TAG = "NightLifeFragment";

    private RecyclerView mRecyclerView;
    private List<Item> mItems;

    public NightLifeFragment() { }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recycler_view,container,false);

        mRecyclerView = rootView.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setDrawingCacheEnabled(true);
        mRecyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_LOW);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        addItems();

        NightLifeAdapter recyclerViewAdapter = new NightLifeAdapter(getActivity(),mItems);
        recyclerViewAdapter.setHasStableIds(true);

        if (getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        }else{
            mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        }
        mRecyclerView.setAdapter(recyclerViewAdapter);

    }

    public void addItems() {

        mItems = new ArrayList<>();

        mItems.add(new Item(getString(R.string.ledana),
                getString(R.string.nightlife_ledana),
                R.drawable.nightlife_ledana,
                R.drawable.fab_location,
                R.color.category_nightlife,
                44.112714f, 15.229847f));

        mItems.add(new Item(getString(R.string.yachting),
                getString(R.string.nightlife_yachting),
                R.drawable.nightlife_yachtingclub,
                R.drawable.fab_location,
                R.color.category_nightlife,
                44.131413f, 15.210434f));

        mItems.add(new Item(getString(R.string.kult),
                getString(R.string.nightlife_kult),
                R.drawable.nightlife_kult,
                R.drawable.fab_location,
                R.color.category_nightlife,
                44.113322f, 15.225826f));

        mItems.add(new Item(getString(R.string.svarog),
                getString(R.string.nightlife_svarog),
                R.drawable.nightlife_svarog,
                R.drawable.fab_location,
                R.color.category_nightlife,
                44.112435f, 15.228501f));

        mItems.add(new Item(getString(R.string.podroom),
                getString(R.string.nightlife_podroom),
                R.drawable.nightlife_podroom,
                R.drawable.fab_location,
                R.color.category_nightlife,
                44.110648f, 15.233623f));

        mItems.add(new Item(getString(R.string.la_bodega),
                getString(R.string.nightlife_labodega),
                R.drawable.nightlife_labodega,
                R.drawable.fab_location,
                R.color.category_nightlife,
                44.114720f, 15.226571f));

        mItems.add(new Item(getString(R.string.garden),
                getString(R.string.nightlife_garden),
                R.drawable.nightlife_garden,
                R.drawable.fab_location,
                R.color.category_nightlife,
                44.118337f, 15.223577f));

    }

}
