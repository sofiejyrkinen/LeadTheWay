package app.garvinen.leadtheway.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Axel on 2016-12-02.
 */

public class MySQLiteHelper extends SQLiteOpenHelper {


    public static final String TABLE_DESTINATIONS = "destination";
    public static final String COLUMN_ID     = "_id";
    public static final String COLUMN_ICON   = "icon";
    public static final String COLUMN_ICONNAME  = "iconName";
    public static final String COLUMN_ADRESS  = "adress";
    public static final String COLUMN_CITY  = "city";
    public static final String COLUMN_POSTALCODE  = "postalCode";

    private static final String DATABASE_NAME = "destinations.db";
    private static final int DATABASE_VERSION = 1;

    private static final String LOG_TAG = MySQLiteHelper.class.getName();

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_DESTINATIONS
            + "( "
            + COLUMN_ID     + " integer primary key autoincrement, "
            + COLUMN_ICON   +  " text not null,"
            + COLUMN_ICONNAME   +  " text not null,"
            + COLUMN_ADRESS   +  " text not null,"
            + COLUMN_CITY   +  " text not null,"
            + COLUMN_POSTALCODE  +  " text not null);";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.d(LOG_TAG, " can't upgrade");
    }

}