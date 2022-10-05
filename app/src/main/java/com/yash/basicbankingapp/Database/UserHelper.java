package com.yash.basicbankingapp.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.yash.basicbankingapp.Database.UserContract.UserEntry;

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
        db.execSQL("insert into " + TABLE_NAME + " values(7860,'Yash Chaudhary', 'yash@gmail.com','7524','789564XXXX', 1500000)");
        db.execSQL("insert into " + TABLE_NAME + " values(5862,'Ramesh Sharma', 'ramesh@gmail.com','1058','899564XXXX', 950000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7895,'Supriya Mehta', 'supriya@gmail.com','8786','759564XXXX', 810000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1258,'Vijay Singh', 'vijay@gmail.com','7767','999564XXXX', 808000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7410,'Shivansh Rai', 'shivansh@gmail.com','6769','909564XXXX', 725000)");
        db.execSQL("insert into " + TABLE_NAME + " values(8529,'Priyal Dhuri', 'priyal@gmail.com','4585','885564XXXX', 635000)");
        db.execSQL("insert into " + TABLE_NAME + " values(3698,'Yashodeep Chauhan', 'yashodeep@gmail.com','8307','889564XXXX', 945000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7853,'Kartik Jain', 'kartik@gmail.com','4522','998502XXXX', 225000)");
        db.execSQL("insert into " + TABLE_NAME + " values(4562,'Rohit onroi', 'rohit@gmail.com','6582','930956XXXX', 1205000)");
        db.execSQL("insert into " + TABLE_NAME + " values(2365,'Ranjeet Patidar', 'ranjeet@gmail.com','5450','829259XXXX', 499000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7854,'Ankush Patel', 'ankush@gmail.com','2656','901564XXXX', 930800)");
        db.execSQL("insert into " + TABLE_NAME + " values(3621,'Hitish Patil', 'hitish@gmail.com','1203','999564XXXX', 1102000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1122,'Navneet Trivedi', 'navneet@gmail.com','5566','911954XXXX', 5908000)");
        db.execSQL("insert into " + TABLE_NAME + " values(9512,'Gaurav Parashar', 'gaurav@gmail.com','2236','625464XXXX', 3095000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7530,'Shlok Chawhan', 'shlok@gmail.com','6692','68936XXXX', 1190000)");
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
