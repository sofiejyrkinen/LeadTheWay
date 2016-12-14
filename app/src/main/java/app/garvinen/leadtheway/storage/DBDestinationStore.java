package app.garvinen.leadtheway.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import app.garvinen.leadtheway.describe.Destination;

/**
 * Created by Axel on 2016-12-02.
 */

public class DBDestinationStore implements DestinationStore {

    private static DBDestinationStore storage ;

    // Database fields
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = { MySQLiteHelper.COLUMN_ID,
            MySQLiteHelper.COLUMN_ICONNAME,
            MySQLiteHelper.COLUMN_ADRESS,
            MySQLiteHelper.COLUMN_CITY,
            MySQLiteHelper.COLUMN_POSTALCODE,
            MySQLiteHelper.COLUMN_ICONID };

    public DBDestinationStore(Context context)  {
        dbHelper = new MySQLiteHelper(context);
        try {
            open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Destination createDestination(Destination d) {
        ContentValues values = new ContentValues();

        values.put(MySQLiteHelper.COLUMN_ICONNAME, d.iconName());
        values.put(MySQLiteHelper.COLUMN_ADRESS, d.adress());
        values.put(MySQLiteHelper.COLUMN_CITY, d.city());
        values.put(MySQLiteHelper.COLUMN_POSTALCODE, d.postalCode());
        values.put(MySQLiteHelper.COLUMN_ICONID, d.iconId());

        long insertId = database.insert(MySQLiteHelper.TABLE_DESTINATIONS, null,
                values);
        Cursor cursor = database.query(MySQLiteHelper.TABLE_DESTINATIONS,
                allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        Destination newDestination = cursorToDestination(cursor);
        cursor.close();
        Log.d("db" ," storing destination");
        return newDestination;
    }

    private Destination cursorToDestination(Cursor cursor) {
        long id = cursor.getLong(0);
        String iconName = cursor.getString(1);
        String adress = cursor.getString(2);
        String city = cursor.getString(3);
        String postalCode = cursor.getString(4);
        long iconId = cursor.getLong(5);
        return new Destination(iconName, adress, city, postalCode, iconId);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

     public void close() {
        dbHelper.close();
    }

    @Override
    public List<Destination> getDestination() {
        List<Destination> destination = new ArrayList<>();

        Cursor cursor = database.query(MySQLiteHelper.TABLE_DESTINATIONS,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Destination d = cursorToDestination(cursor);
            destination.add(d);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return destination;
    }

    public void addDestination(Destination d) {
        createDestination(d);
    }

}
