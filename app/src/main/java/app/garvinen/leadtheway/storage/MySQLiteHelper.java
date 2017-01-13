package app.garvinen.leadtheway.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import app.garvinen.leadtheway.R;

/**
 * Created by Axel on 2016-12-02.
 */

public class MySQLiteHelper extends SQLiteOpenHelper {


    public static final String TABLE_DESTINATIONS = "destination";
    public static final String COLUMN_ID     = "_id";
    public static final String COLUMN_ICONNAME  = "iconName";
    public static final String COLUMN_ADRESS  = "adress";
    public static final String COLUMN_CITY  = "city";
    public static final String COLUMN_POSTALCODE  = "postalCode";
    public static final String COLUMN_ICONSICONID = "icon_id";

    public static final String TABLE_ICONS = "icons";
    public static final String COLUMN_ICONID = "icon_id";
    public static final String COLUMN_ICONPATH  = "iconPath";


    private static final String DATABASE_NAME = "destinations.db";
    private static final int DATABASE_VERSION = 1;

    private static final String LOG_TAG = MySQLiteHelper.class.getName();

    // Database creation sql statement for Destination Table
    private static final String TABLE_DEST_CREATE = "create table "
            + TABLE_DESTINATIONS
            + "( "
            + COLUMN_ID     + " integer primary key autoincrement, "
            + COLUMN_ICONNAME   +  " text not null,"
            + COLUMN_ADRESS   +  " text not null,"
            + COLUMN_CITY   +  " text not null,"
            + COLUMN_POSTALCODE  +  " text not null,"
            + COLUMN_ICONSICONID  +  " integer not null);";

    // Database creation sql statement for Icons Table
    private static final String TABLE_ICONS_CREATE = "create table "
            + TABLE_ICONS
            + "( "
            + COLUMN_ICONID     + " integer primary key autoincrement, "
            + COLUMN_ICONPATH   +  " text not null);";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        Log.d(LOG_TAG, "Skapar den goe dbn");
        database.execSQL(TABLE_DEST_CREATE);
        database.execSQL(TABLE_ICONS_CREATE);

        database.execSQL("INSERT INTO " + TABLE_ICONS + " VALUES (1, " + R.drawable.icon_home + ")");
        database.execSQL("INSERT INTO " + TABLE_ICONS + " VALUES (2, " + R.drawable.icon_work + ")");
        database.execSQL("INSERT INTO " + TABLE_ICONS + " VALUES (3, " + R.drawable.icon_store + ")");
        database.execSQL("INSERT INTO " + TABLE_ICONS + " VALUES (4, " + R.drawable.icon_boy + ")");
        database.execSQL("INSERT INTO " + TABLE_ICONS + " VALUES (5, " + R.drawable.icon_girl + ")");
        database.execSQL("INSERT INTO " + TABLE_ICONS + " VALUES (6, " + R.drawable.icon_dad + ")");
        database.execSQL("INSERT INTO " + TABLE_ICONS + " VALUES (7, " + R.drawable.icon_mom + ")");
        database.execSQL("INSERT INTO " + TABLE_ICONS + " VALUES (8, " + R.drawable.icon_activity + ")");
        database.execSQL("INSERT INTO " + TABLE_ICONS + " VALUES (9, " + R.drawable.icon_school + ")");
        database.execSQL("INSERT INTO " + TABLE_ICONS + " VALUES (10, " + R.drawable.icon_hospital + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.d(LOG_TAG, " can't upgrade");
    }

}
