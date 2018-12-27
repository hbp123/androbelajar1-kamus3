package com.example.root.kamus3.helper;import android.content.Context;import android.database.sqlite.SQLiteDatabase;import android.database.sqlite.SQLiteOpenHelper;import static android.provider.BaseColumns._ID;import static com.example.root.kamus3.helper.MyDBContract.DictColumns.MEANING;import static com.example.root.kamus3.helper.MyDBContract.DictColumns.WORD;import static com.example.root.kamus3.helper.MyDBContract.KolomKamus.ARTI;import static com.example.root.kamus3.helper.MyDBContract.KolomKamus.KATA;import static com.example.root.kamus3.helper.MyDBContract.TABLE_ENG;import static com.example.root.kamus3.helper.MyDBContract.TABLE_IND;public class MyDBHelper extends SQLiteOpenHelper{    private static String DB_NAME   = "kamus";    private static int DB_VERSION   = 1;    public static String CREATE_TABLE_INDONESIA = "create table "+TABLE_IND+            " ("+_ID+" integer primary key autoincrement, "+            KATA+" text not null, "+            ARTI+" text not null);";    public static String CREATE_TABLE_ENGLISH = "create table "+TABLE_ENG+            " ("+_ID+" integer primary key autoincrement, "+            WORD+" text not null, "+            MEANING+" text not null);";    public MyDBHelper(Context context) {        super(context, DB_NAME, null, DB_VERSION);    }    @Override    public void onCreate(SQLiteDatabase sqLiteDatabase) {        sqLiteDatabase.execSQL(CREATE_TABLE_ENGLISH);        sqLiteDatabase.execSQL(CREATE_TABLE_INDONESIA);    }    @Override    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_ENG);        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_IND);        onCreate(sqLiteDatabase);    }}