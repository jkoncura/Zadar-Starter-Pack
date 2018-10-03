package com.neta.android.zadar_starterpack.models;


public class Item {

    private String mDescription;
    private int mImageResourceId;
    private String mTitle;
    private int mLocationIconResourceId;
    private int mCategoryColor;
    private String mWebPageUrl;
    private float mLatitude;
    private float mLongitude;

    public Item(String mTitle, String mDescription, int mImageResourceId, int mLocationIconResourceId, int mCategoryColor, float mLatitude, float mLongitude){
        this.mDescription = mDescription;
        this.mImageResourceId = mImageResourceId;
        this.mTitle = mTitle;
        this.mLocationIconResourceId = mLocationIconResourceId;
        this.mCategoryColor = mCategoryColor;
        this.mLatitude = mLatitude;
        this.mLongitude = mLongitude;
    }

    public Item(String title,String description,  int imageResourceId,int locationIconResourceId, int categoryColor, String webPageUrl) {
        mDescription = description;
        mImageResourceId = imageResourceId;
        mTitle = title;
        mLocationIconResourceId = locationIconResourceId;
        mCategoryColor = categoryColor;
        mWebPageUrl = webPageUrl;
    }

    public Item(String mDescription){
        this.mDescription = mDescription;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getTitle() {
        return mTitle;
    }

    public int getImageLocationResourceId() {
        return mLocationIconResourceId;
    }

    public int getCategoryColor() {
        return mCategoryColor;
    }

    public float getLatitude() {
        return mLatitude;
    }

    public float getLongitude() {
        return mLongitude;
    }

    public String getWebPageUrl() {
        return mWebPageUrl;
    }
}
