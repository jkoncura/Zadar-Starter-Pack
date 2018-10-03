package com.neta.android.zadar_starterpack;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class CuisineItemActivity extends AppCompatActivity {

    private static final String TAG = "CuisineItemActivity";

    static final String EXTRA_TITLE = "com.neta.android.zadar_starterpack.adapters.EXTRA_TITLE";
    static final String EXTRA_DESCRIPTION = "com.neta.android.zadar_starterpack.adapters.EXTRA_DESCRIPTION";
    static final String EXTRA_IMAGE = "com.neta.android.zadar_starterpack.adapters.EXTRA_IMAGE";
    static final String EXTRA_COLOR = "com.neta.android.zadar_starterpack.adapters.EXTRA_COLOR";
    static final String EXTRA_FAB = "com.neta.android.zadar_starterpack.adapters.EXTRA_FAB";
    static final String EXTRA_WEB_PAGE_URL = "com.neta.android.zadar_starterpack.adapters.EXTRA_WEB_PAGE_URL";

    private TextView mDescription;
    private ImageView mImage;
    private TextView mTitle;
    private FloatingActionButton mWebPageFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_item);


        mDescription = findViewById(R.id.text_description);
        mTitle = findViewById(R.id.text_title);
        mImage = findViewById(R.id.image_cover);
        mWebPageFab = findViewById(R.id.fab_location);

        Intent intent = getIntent();

        String title = intent.getExtras().getString(EXTRA_TITLE);
        String description = intent.getExtras().getString(EXTRA_DESCRIPTION);
        int imageId = intent.getExtras().getInt(EXTRA_IMAGE);
        int color = intent.getExtras().getInt(EXTRA_COLOR);
        int fabId = intent.getExtras().getInt(EXTRA_FAB);
        final String url = intent.getExtras().getString(EXTRA_WEB_PAGE_URL);

        mDescription.setText(description);
        mTitle.setText(title);
        Glide.with(this)
                .asBitmap()
                .load(imageId)
                .into(mImage);
        mWebPageFab.setImageResource(fabId);
        mWebPageFab.setBackgroundTintList(getResources().getColorStateList(color));


        mWebPageFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                mWebPageFab.bringToFront();
            }
        });
    }
}
