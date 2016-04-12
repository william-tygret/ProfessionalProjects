package com.williamtygret.w;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by williamtygret on 3/29/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = DatabaseHelper.class.getCanonicalName();

    public static final int DATABASE_VERSION = 4;
    public static final String DATABASE_NAME = "w_db.db";

    public static final String INSTAGRAM_TABLE = "news";
    public static final String INSTAGRAM_COL_ID = "_id";
    public static final String INSTAGRAM_COL_HEADLINE = "headline";
    public static final String INSTAGRAM_COL_THUMBNAIL_URL = "thumbnail_url";
    public static final String INSTAGRAM_COL_LINK_URL = "link_url";
    public static final String[] INSTAGRAM_COLUMNS = new String[]{INSTAGRAM_COL_ID, INSTAGRAM_COL_HEADLINE, INSTAGRAM_COL_THUMBNAIL_URL, INSTAGRAM_COL_LINK_URL};
    public static final String INSTAGRAM_CREATE = "CREATE TABLE " + INSTAGRAM_TABLE + " ("
            + INSTAGRAM_COL_ID + " INTEGER PRIMARY KEY, "
            + INSTAGRAM_COL_HEADLINE + " TEXT, "
            + INSTAGRAM_COL_THUMBNAIL_URL + " TEXT, "
            + INSTAGRAM_COL_LINK_URL + " TEXT)";

    private static DatabaseHelper mInstance;

    public static synchronized DatabaseHelper getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new DatabaseHelper(context, null);
        }
        return mInstance;
    }

    private DatabaseHelper(Context context, SQLiteDatabase.CursorFactory factory) {
        super(context.getApplicationContext(), DATABASE_NAME, factory, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(INSTAGRAM_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + INSTAGRAM_TABLE);
        onCreate(db);
    }

    public int deleteAllInstagram() {
        Log.d(TAG, "deleteAllNews: starting");

        SQLiteDatabase db = getWritableDatabase();
        int rowsAffected = db.delete(INSTAGRAM_TABLE, "1", null);
        //db.close();
        return rowsAffected;
    }

    public long addInstagram(ContentValues values) {
        Log.d(TAG, "addNews: starting");

        SQLiteDatabase db = getWritableDatabase();

        // need headline & link url, but can live without thumbnail url
        if (values.containsKey(INSTAGRAM_COL_HEADLINE) && values.containsKey(INSTAGRAM_COL_LINK_URL)) {
            long rowId = db.insert(INSTAGRAM_TABLE, null, values);
            //db.close();
            return rowId;
        } else {
            return -1L;
        }
    }

    public Cursor getInstagram(Integer limit) {
        Log.d(TAG, "getNews: starting");

        SQLiteDatabase db = getReadableDatabase();

        String limitString = null;
        if (limit != null && limit > 0) {
            limitString = String.valueOf(limit);
        }

        Cursor cursor = db.query(
                INSTAGRAM_TABLE,             // table
                INSTAGRAM_COLUMNS,           // columns
                null, null, null, null, // selection, selectionArgs, groupBy, having
                INSTAGRAM_COL_ID + " ASC",  // orderBy
                limitString             // limit
        );
        //db.close();
        cursor.moveToFirst();
        while(cursor.isAfterLast()==false){
            Log.d("GETINSTAGRAM",cursor.getString(cursor.getColumnIndex(DatabaseHelper.INSTAGRAM_COL_HEADLINE)));
            cursor.moveToNext();
        }
        return cursor;
    }


}
