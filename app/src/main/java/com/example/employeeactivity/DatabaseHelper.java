package com.example.employeeactivity;

import android.app.DownloadManager;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    static String DbName="Employee.db";
    static String TableName="Employee";
    static String Col1="id";
    static String Col2="code";
    static String Col3="name";
    static String Col4="mob";
    static String Col5="Email";
    static String Col6="Des";
    @Override
    public void onCreate(SQLiteDatabase db) {

        String query="create table "+TableName+"("+
                Col1+" integer primary key autoincrement,"+
                Col2+" Text,"+
                Col3+" Text,"+
                Col4+" Text,"+
                Col5+" Text,"+
                Col6+" Text)";

        db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean InsertData(String code,String name,String mob,String Email,String Des)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues c=new ContentValues();
        c.put(Col2,code);
        c.put(Col3,name);
        c.put(Col4,mob);
        c.put(Col5,Email);
        c.put(Col6,Des);

        long Status=db.insert(TableName,null,c);

                if(Status==-1)
                {
                    return false;
                }
                else
                {
                    return true;
                }
    }

    public DatabaseHelper(@Nullable Context context) {
        super(context,DbName,null,1);


    }
}
