package com.neta.android.zadar_starterpack;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class BeachesItemActivity extends AppCompatActivity {

    private static final String TAG = "BeachesItemActivity";

    static final String EXTRA_TITLE = "com.neta.android.zadar_starterpack.adapters.EXTRA_TITLE";
    static final String EXTRA_DESCRIPTION = "com.neta.android.zadar_starterpack.adapters.EXTRA_DESCRIPTION";
    static final String EXTRA_IMAGE = "com.neta.android.zadar_starterpack.adapters.EXTRA_IMAGE";
    static final String EXTRA_COLOR = "com.neta.android.zadar_starterpack.adapters.EXTRA_COLOR";
    static final String EXTRA_FAB = "com.neta.android.zadar_starterpack.adapters.EXTRA_FAB";
    static final String EXTRA_LATITUDE = "com.neta.android.zadar_starterpack.adapters.EXTRA_LATITUDE";
    static final String EXTRA_LONGITUDE = "com.neta.android.zadar_starterpack.adapters.EXTRA_LONGITUDE";

    private TextView mDescription;
    private ImageView mImage;
    private TextView mTitle;
    private FloatingActionButton mLocationFab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_item);

        mDescription = findViewById(R.id.text_description);
        mTitle = findViewById(R.id.text_title);
        mImage = findViewById(R.id.image_cover);
        mLocationFab = findViewById(R.id.fab_location);

        Intent intent = getIntent();

        final String title = intent.getExtras().getString(EXTRA_TITLE);
        String description = intent.getExtras().getString(EXTRA_DESCRIPTION);
        int imageId = intent.getExtras().getInt(EXTRA_IMAGE);
        int color = intent.getExtras().getInt(EXTRA_COLOR );
        int fabId = intent.getExtras().getInt(EXTRA_FAB);
        final float latitude = intent.getExtras().getFloat(EXTRA_LATITUDE);
        final float longitude = intent.getExtras().getFloat(EXTRA_LONGITUDE);

        mDescription.setText(description);
        mTitle.setText(title);
        Glide.with(this)
                .asBitmap()
                .load(imageId)
                .into(mImage);
        mLocationFab.setImageResource(fabId);
        mLocationFab.setBackgroundTintList(getResources().getColorStateList(color));


        mLocationFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = String.format("geo:<" + latitude + ">,<" + longitude + ">?q=<" + latitude  + ">,<" + longitude + ">(" + title + ")");
                Intent intentLocation = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intentLocation);
                mLocationFab.bringToFront();
            }
        });
    }
}
