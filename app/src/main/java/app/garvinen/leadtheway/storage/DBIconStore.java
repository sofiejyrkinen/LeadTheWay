package app.garvinen.leadtheway.storage;

/**
 * Created by sofiejyrkinen on 2016-12-14.
 */


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import app.garvinen.leadtheway.describe.Icon;

public class DBIconStore implements IconStore{

    private static DBIconStore storage ;

    // Database fields
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = { MySQLiteHelper.COLUMN_ICONID,
                                    MySQLiteHelper.COLUMN_ICONPATH };

    public DBIconStore(Context context)  {
        dbHelper = new MySQLiteHelper(context);
        try {
            open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Icon createIcon(Icon i) {
        ContentValues values = new ContentValues();

        values.put(MySQLiteHelper.COLUMN_ICONPATH, i.iconPath());


        long insertId = database.insert(MySQLiteHelper.TABLE_ICONS, null,
                values);
        Cursor cursor = database.query(MySQLiteHelper.TABLE_ICONS,
                allColumns, MySQLiteHelper.COLUMN_ICONID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        Icon newIcon = cursorToIcon(cursor);
        cursor.close();
        Log.d("db" ," storing icon");
        return newIcon;
    }

    private Icon cursorToIcon(Cursor cursor) {
        long iconId = cursor.getLong(0);
        int iconPath = cursor.getInt(1);
        return new Icon(iconPath);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    @Override
    public List<Icon> getIcon() {
        List<Icon> icon = new ArrayList<>();

        Cursor cursor = database.query(MySQLiteHelper.TABLE_ICONS,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Icon i = cursorToIcon(cursor);
            icon.add(i);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return icon;
    }

    public void addIcon(Icon i) {
        createIcon(i);
    }

}
