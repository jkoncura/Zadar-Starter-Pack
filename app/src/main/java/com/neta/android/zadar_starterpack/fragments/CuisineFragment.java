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

import com.neta.android.zadar_starterpack.adapters.CuisineAdapter;
import com.neta.android.zadar_starterpack.models.Item;
import com.neta.android.zadar_starterpack.R;

import java.util.ArrayList;
import java.util.List;

public class CuisineFragment extends Fragment {

    private static final String TAG = "CuisineFragment";

    private RecyclerView mRecyclerView;
    private List<Item> mItems;

    public CuisineFragment() { }


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

        CuisineAdapter recyclerViewAdapter = new CuisineAdapter(getActivity(),mItems);
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

        mItems.add(new Item(getString(R.string.shrimp_buzara),
                getString(R.string.cuisine_shrimp),
                R.drawable.cuisine_shrimps,
                R.drawable.fab_launch_webpage,
                R.color.category_cuisine,
                "http://www.bruschetta.hr/en/"));

        mItems.add(new Item(getString(R.string.dalmatian_plate),
                getString(R.string.cuisine_dalmatian_plate),
                R.drawable.cuisine_dalmatian_plate,
                R.drawable.fab_launch_webpage,
                R.color.category_cuisine,
                "https://www.facebook.com/ProtoZadar/"));

        mItems.add(new Item(getString(R.string.octopus),
                getString(R.string.cuisine_octopus),
                R.drawable.cuisine_octopus,
                R.drawable.fab_launch_webpage,
                R.color.category_cuisine,
                "http://www.restoran-kodstipe.com/?lang=eng&rowsPerPage=50"));

        mItems.add(new Item(getString(R.string.fish),
                getString(R.string.cuisine_fish),
                R.drawable.cuisine_fish,
                R.drawable.fab_launch_webpage,
                R.color.category_cuisine,
                "http://malo-misto.com/"));

        mItems.add(new Item(getString(R.string.black_risotto),
                getString(R.string.cuisine_risotto),
                R.drawable.cuisine_risotto,
                R.drawable.fab_launch_webpage,
                R.color.category_cuisine,
                "https://www.restaurant4kantuna.com/en/"));

        mItems.add(new Item(getString(R.string.dalmatian_pasticada),
                getString(R.string.cuisine_pasticada),
                R.drawable.cuisine_dpasticada,
                R.drawable.fab_launch_webpage,
                R.color.category_cuisine,
                "http://www.zadarjadera.com/"));

        mItems.add(new Item(getString(R.string.lamb),
                getString(R.string.cuisine_lamb),
                R.drawable.cuisine_lamb,
                R.drawable.fab_launch_webpage,
                R.color.category_cuisine,
                "http://tamaris-zadar.com.hr/restoran/?lang=en"));

    }


}
