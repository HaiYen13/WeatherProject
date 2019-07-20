package com.example.weatherappproject.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Stack;

public class SQLHelper extends SQLiteOpenHelper {

    private static final String TAG = "SQLHelper";
    static final String DB_NAME = "Weather.db";
    static final String DB_NAME_TABLE = "History";
    static final int DB_VERSION = 2;

    SQLiteDatabase sqLiteDatabase;
    ContentValues contentValues;
    Cursor cursor;


    public SQLHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCreaTable = "CREATE TABLE History ( id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "                city VARCHAR(20) NOT NULL ," +
                "                date VARCHAR(20) NOT NULL ," +
                "                img VARCHAR(25) NOT NULL ," +
                "                description VARCHAR(30) NOT NULL ," +
                "                temperature INTERGER NOT NULL ," +
                "                pressure INTERGER NOT NULL ," +
                "                humidity INTERGER NOT NULL)";


        db.execSQL(queryCreaTable);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion == newVersion) {
            db.execSQL("drop table if exists " + DB_NAME_TABLE);
            onCreate(db);
        }
    }

    public void insertHistory(History history){
        sqLiteDatabase = getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put("city", history.getName_city());
        contentValues.put("date", history.getDate_time());
        contentValues.put("img", history.getImg());
        contentValues.put("description", history.getDescription());
        contentValues.put("temperature", history.getTemp());
        contentValues.put("pressure", history.getPressure());
        contentValues.put("humidity", history.getHumidity());

        sqLiteDatabase.insert(DB_NAME_TABLE, null,  contentValues);
        closeDB();
    }


    public int deleteHistory(int id){
        sqLiteDatabase = getWritableDatabase();
        return Long.valueOf(sqLiteDatabase.delete(DB_NAME_TABLE, "id=?", new String[]{String.valueOf(id)})).intValue();
    }

    public boolean deleteAll(){
        sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete(DB_NAME_TABLE, null, null);
        closeDB();
        return true;
    }

    public void getAllHistory(){
        sqLiteDatabase = getReadableDatabase();
        cursor  = sqLiteDatabase.query(false, DB_NAME_TABLE, null, null, null, null, null, null, null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String name = cursor.getString(cursor.getColumnIndex("city"));
            String img = cursor.getString(cursor.getColumnIndex("img"));
            String des = cursor.getString(cursor.getColumnIndex("description"));
            Double temp = cursor.getDouble(cursor.getColumnIndex("temperature"));
            Double pressure = cursor.getDouble(cursor.getColumnIndex("pressure"));
            Double humi = cursor.getDouble(cursor.getColumnIndex("humidity"));

            Log.d(TAG, "getAllProduct: " + "id - " + id + " - name - " + name + " - pressure- " + pressure);
        }
        closeDB();
    }

    public ArrayList<History> getArrayHistory(){

        Stack<History> stack = new Stack<>();
        ArrayList<History> histories = new ArrayList<>();
        sqLiteDatabase = getReadableDatabase();
        cursor  = sqLiteDatabase.query(true, DB_NAME_TABLE, null, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String name = cursor.getString(cursor.getColumnIndex("city"));
            String date = cursor.getString(cursor.getColumnIndex("date"));
            String img = cursor.getString(cursor.getColumnIndex("img"));
            String des = cursor.getString(cursor.getColumnIndex("description"));
            int temp = cursor.getInt(cursor.getColumnIndex("temperature"));
            int pressure = cursor.getInt(cursor.getColumnIndex("pressure"));
            int humi = cursor.getInt(cursor.getColumnIndex("humidity"));
            History history = new History(name, date, img, des, temp, pressure, humi);
            stack.push(history);
        }
             int i = 1;
        while (!stack.empty()){
            if(i == 6)
                break;
            histories.add(stack.peek());
            stack.pop();
          i++;
        }
        return histories;
    }


    private void closeDB() {
        if (sqLiteDatabase != null) sqLiteDatabase.close();
        if (contentValues != null) contentValues.clear();
        if (cursor != null) cursor.close();
    }
}
