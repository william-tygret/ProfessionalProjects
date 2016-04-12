package com.williamtygret.w;

import android.database.Cursor;

import java.util.ArrayList;

/**
 * Created by williamtygret on 3/30/16.
 */
public class InstagramData {

    private ArrayList<InstagramItemData> mInstagramItems;

    public InstagramData(Cursor cursor) {

        mInstagramItems = new ArrayList<>(cursor.getCount());
        cursor.moveToFirst();
        while (cursor.moveToNext()) {
            mInstagramItems.add( new InstagramItemData(
                    cursor.getString(cursor.getColumnIndex(DatabaseHelper.INSTAGRAM_COL_HEADLINE)),
                    cursor.getString(cursor.getColumnIndex(DatabaseHelper.INSTAGRAM_COL_LINK_URL)),
                    cursor.getString(cursor.getColumnIndex(DatabaseHelper.INSTAGRAM_COL_THUMBNAIL_URL))
            ));
        }
    }

    public ArrayList<InstagramItemData> getInstagramItems() { return mInstagramItems; }

    public class InstagramItemData {
        private String mHeadline, mLinkUrl, mThumbnailUrl;

        public InstagramItemData(String headline, String linkUrl, String thumbnailUrl) {
            mHeadline = headline;
            mLinkUrl = linkUrl;
            mThumbnailUrl = thumbnailUrl;
        }

        public String getHeadline() { return mHeadline; }

        public String getLinkUrl() { return mLinkUrl; }

        public String getThumbnailUrl() { return mThumbnailUrl; }
    }


}
