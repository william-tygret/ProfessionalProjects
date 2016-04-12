package com.williamtygret.w;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;
import android.util.Log;

import com.williamtygret.w.InstagramAPIstuff.Datum;
import com.williamtygret.w.InstagramAPIstuff.InstagramAPI;
import com.williamtygret.w.InstagramAPIstuff.InstagramAPIResults;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by williamtygret on 3/29/16.
 */
public class SyncAdapter extends AbstractThreadedSyncAdapter {
    private static final String TAG = SyncAdapter.class.getCanonicalName();

    private ContentResolver mContentResolver;

    public SyncAdapter(Context context, boolean autoInitialize) {
        super(context, autoInitialize);
        mContentResolver = context.getContentResolver();
    }

    public SyncAdapter(Context context, boolean autoInitialize, boolean allowParallelSyncs) {
        super(context, autoInitialize, allowParallelSyncs);
        mContentResolver = context.getContentResolver();
    }

    @Override
    public void onPerformSync(Account account, Bundle extras, String authority, ContentProviderClient provider, SyncResult syncResult) {
        Log.d("ISSYNCING","we are doing on perform sync");
        getInstagramData();
    }

    public void getInstagramData() {
        InstagramAPI.Factory.getInstance().getInstagram().enqueue(new Callback<InstagramAPIResults>() {

            @Override
            public void onResponse(Call<InstagramAPIResults> call, Response<InstagramAPIResults> response) {
                List<Datum> results = response.body().getData();

                if (results != null && results.size() > 0) {
                    // first, clear out the saved news data
                    mContentResolver.delete(ContentProvider.INSTAGRAM_URI, null, null);

                    // then add new values from results
                    for (Datum result : results) {
                        ContentValues values = new ContentValues();
                        values.put(DatabaseHelper.INSTAGRAM_COL_HEADLINE, result.getCaption().getText());
                        values.put(DatabaseHelper.INSTAGRAM_COL_LINK_URL, result.getLink());
                        if (result.getImages().getStandardResolution()!= null) {
                            values.put(DatabaseHelper.INSTAGRAM_COL_THUMBNAIL_URL, result.getImages().getStandardResolution().getUrl());
                        }

                        Log.d("GETINSTAGRAM",result.getCaption().getText());
                        mContentResolver.insert(ContentProvider.INSTAGRAM_URI, values);
                    }

                    // notify the ContentObserver in MainActivity
                    mContentResolver.notifyChange(ContentProvider.INSTAGRAM_URI, null);
                } else {
                    Log.d(TAG, "onFailure: error using the NYT Top Stories API");
                }
            }

            @Override
            public void onFailure(Call<InstagramAPIResults> call, Throwable t) {
                Log.d(TAG, "onFailure: error using the NYT Top Stories API");
            }
        });
    }

}
