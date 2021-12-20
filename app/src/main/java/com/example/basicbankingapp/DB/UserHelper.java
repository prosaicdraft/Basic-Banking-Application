package com.example.basicbankingapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.basicbankingapp.DB.UserContract.UserEntry;
import com.example.basicbankingapp.Data.User;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(1000,'Anurag Tripathi', 'tripathi@gmail.com','6333','7219086435', 10000)");
        db.execSQL("insert into " + TABLE_NAME + " values(2000,'Jahnavi janu', 'janu@gmail.com','1876','8877653238', 10500)");
        db.execSQL("insert into " + TABLE_NAME + " values(3000,'Sneha shree', 'sneha@gmail.com','6756','7865445896', 8000)");
        db.execSQL("insert into " + TABLE_NAME + " values(4000,'Shilpa sri', 'shilpa@gmail.com','7752','9995640038', 11000)");
        db.execSQL("insert into " + TABLE_NAME + " values(5000,'Shantha Kumari', 'shantha@gmail.com','7863','8099648962', 12000)");
        db.execSQL("insert into " + TABLE_NAME + " values(6000,'Caroline forbes', 'care@gmail.com','7653','9877654329', 8700)");
        db.execSQL("insert into " + TABLE_NAME + " values(7000,'Klaus Mikelson', 'klaus@gmail.com','8906','9988765432', 9080)");
        db.execSQL("insert into " + TABLE_NAME + " values(8000,'Vidhya dhare', 'vidhya@gmail.com','4522','9985021539', 8900)");
        db.execSQL("insert into " + TABLE_NAME + " values(9000,'Ram pothineni', 'ram@gmail.com','8664','8776889076', 10450)");
        db.execSQL("insert into " + TABLE_NAME + " values(1100,'Nani suraj', 'nani@gmail.com','8754','8675543245', 13000)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }

}