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

import com.neta.android.zadar_starterpack.adapters.BeachesAdapter;
import com.neta.android.zadar_starterpack.models.Item;
import com.neta.android.zadar_starterpack.R;

import java.util.ArrayList;
import java.util.List;

public class BeachesFragment extends Fragment {

    private static final String TAG = "BeachesFragment";

    private RecyclerView mRecyclerView;
    private List<Item> mItems;

    public BeachesFragment() {}

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

        BeachesAdapter recyclerViewAdapter = new BeachesAdapter(getActivity(),mItems);
        recyclerViewAdapter.setHasStableIds(true);

        if (getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        } else {
            mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        }
        mRecyclerView.setAdapter(recyclerViewAdapter);

    }


    private void addItems() {

        mItems = new ArrayList<>();

        mItems.add(new Item(getString(R.string.kolovare),
                getString(R.string.beaches_kolovare),
                R.drawable.beaches_kolovare,
                R.drawable.fab_location,
                R.color.category_beaches,
                44.105667f, 15.233737f));

        mItems.add(new Item(getString(R.string.borik),
                getString(R.string.beaches_borik),
                R.drawable.beaches_dborik,
                R.drawable.fab_location,
                R.color.category_beaches,
                44.133311f, 15.209265f));

        mItems.add(new Item(getString(R.string.diklo),
                getString(R.string.beaches_diklo),
                R.drawable.beaches_diklo,
                R.drawable.fab_location,
                R.color.category_beaches,
                44.156543f, 15.195860f));

        mItems.add(new Item(getString(R.string.public_pool),
                getString(R.string.beaches_public_pool),
                R.drawable.beaches_bazen,
                R.drawable.fab_location,
                R.color.category_beaches,
                44.107733f, 15.231292f));

        mItems.add(new Item(getString(R.string.nins_lagoon),
                getString(R.string.beaches_nin_lagoon),
                R.drawable.beaches_nins_lagoon,
                R.drawable.fab_location,
                R.color.category_beaches,
                44.248353f, 15.185856f));

        mItems.add(new Item(getString(R.string.saharun),
                getString(R.string.beaches_saharun),
                R.drawable.beaches_saharun,
                R.drawable.fab_location,
                R.color.category_beaches,
                44.134055f, 14.872325f));

    }


}
