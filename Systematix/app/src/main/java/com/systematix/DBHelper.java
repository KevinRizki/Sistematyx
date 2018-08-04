package com.systematix;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    private final static String db = "systematix.db";
    private final static String user = "user";

    public static final List<String> create = new ArrayList<String>(){{
        add("create table user (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, username TEXT , password TEXT)");
    }};

    static final List<String> table = new ArrayList<String>(){{
        add(user);
    }};

    public DBHelper(Context context) {
        super(context, db, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        for (int i = 0; i < create.size(); i++){
            sqLiteDatabase.execSQL(create.get(i));
        }
        sqLiteDatabase.execSQL("INSERT INTO '"+user+"' (username, password) VALUES ('admin', 'admin')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        for (int j = 0; j < table.size(); j++){
            sqLiteDatabase.execSQL(table.get(j));
        }
    }
}
