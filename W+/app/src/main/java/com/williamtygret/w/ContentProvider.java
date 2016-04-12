package com.williamtygret.w;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

/**
 * Created by williamtygret on 3/29/16.
 */
public class ContentProvider extends android.content.ContentProvider {
    private static final String TAG = ContentProvider.class.getCanonicalName();

    public static final String AUTHORITY = "com.williamtygret.w.ContentProvider";

    public static final String INSTAGRAM_PATH = DatabaseHelper.INSTAGRAM_TABLE;
    public static final String BASE_URI_STRING = "content://" + AUTHORITY;
    public static final Uri INSTAGRAM_URI = Uri.parse(BASE_URI_STRING + "/" + INSTAGRAM_PATH);
    public static final String ERR_MSG_UNKNOWN_URI = "Unknown URI: ";
    public static final int INSTAGRAM = 1;

    public static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        sUriMatcher.addURI(AUTHORITY, INSTAGRAM_PATH, INSTAGRAM);
    }


    private DatabaseHelper mDbHelper;

    @Override
    public boolean onCreate() {
        mDbHelper = DatabaseHelper.getInstance(getContext());
        return (mDbHelper != null);
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        int uriType = sUriMatcher.match(uri);
        Cursor cursor;

        switch (uriType) {
            case INSTAGRAM:
                Log.d(TAG, "query: facebook");
                cursor = mDbHelper.getInstagram(10);
                break;
            default:
                throw new IllegalArgumentException(ERR_MSG_UNKNOWN_URI + uri);
        }

        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }


    @Override
    public Uri insert(Uri uri, ContentValues values) {
        int uriType = sUriMatcher.match(uri);
        long id;

        switch (uriType) {
            case INSTAGRAM:
                Log.d(TAG, "insert: facebook");
                id = mDbHelper.addInstagram(values);
                break;
            default:
                throw new IllegalArgumentException(ERR_MSG_UNKNOWN_URI + uri);
        }
        if (id == -1L) {
            Log.d(TAG, "insert: error inserting to db");
        }

        Log.d(TAG, "insert: notify content resolver");

        return Uri.withAppendedPath(uri, String.valueOf(id));
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int uriType = sUriMatcher.match(uri);
        int rowsAffected = 0;

        switch (uriType) {
            case INSTAGRAM:
                Log.d(TAG, "delete: facebook");
                rowsAffected = mDbHelper.deleteAllInstagram();
                break;


            default:
                throw new IllegalArgumentException(ERR_MSG_UNKNOWN_URI + uri);
        }

        //TODO - check if rowsAffected == -1 which indicates db error

        Log.d(TAG, "delete: notify content resolver");

        getContext().getContentResolver().notifyChange(uri, null);
        return rowsAffected;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        int uriType = sUriMatcher.match(uri);
        int rowsAffected = 0;

        Log.d(TAG, "update: notify content resolver");
        if (rowsAffected > 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return rowsAffected;
    }
}
