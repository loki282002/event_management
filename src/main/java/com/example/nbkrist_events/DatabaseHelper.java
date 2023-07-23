package com.example.nbkrist_events;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String LOG = "DatabaseHelper";

    // Database Version

    // Table Names
    private static final String password="venga";
    public static final String TABLE_hod = "HOD";
    public static final String TABLE_ao = "AO";
    public static final String TABLE_pta = "PTA";
    public static final String TABLE_ci="CI";
    public static final String TABLE_student="studentlog";
    public static final String TABLE_STD_DETAILS="std_details";

    private static final String COL_1="ID";
    public static final String COL_2="username";
    public static final String COL_3="password";
    public static final String std_name="name";
    public static final String std_mail="mail";
    public static final String std_dept="dept";


    private ByteArrayOutputStream objectByteoutputstream;
    private byte[] imageinbyte;

    private static final String DATABASE_NAME = "babu";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_STUDENTS = "student";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_IMAGE = "image";
    public static final String COLUMN_dept = "dept";
    public static final String COLUMN_year = "year";
    public static final String COLUMN_rollno = "rollno";
    public static final String COLUMN_mail = "mail";
    public static final String COLUMN_pswd = "pswd";


    private static final String CREATE_TABLE_STUDENTS = "CREATE TABLE " + TABLE_STUDENTS +
            "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_NAME + " TEXT," +
            COLUMN_IMAGE + " BLOB," +
            COLUMN_dept + " TEXT," +
            COLUMN_year + " TEXT," +
            COLUMN_rollno + " TEXT," +
            COLUMN_mail + " TEXT," +
            COLUMN_pswd + " TEXT)";





    private static final String CREATE_TABLE_hod = "CREATE TABLE "
            + TABLE_hod + "(" + COL_1 + " INTEGER PRIMARY KEY," + COL_2
            + " TEXT," + COL_3 + " TEXT" + ")";
    private static final String CREATE_TABLE_ao = "CREATE TABLE "
            + TABLE_ao + "(" + COL_1 + " INTEGER PRIMARY KEY," + COL_2
            + " TEXT," + COL_3 + " TEXT" + ")";

    private static final String CREATE_TABLE_pta = "CREATE TABLE "
            + TABLE_pta + "(" + COL_1 + " INTEGER PRIMARY KEY," + COL_2
            + " TEXT," + COL_3 + " TEXT" + ")";

    private static final String CREATE_TABLE_ci = "CREATE TABLE "
            + TABLE_ci + "(" + COL_1 + " INTEGER PRIMARY KEY," + COL_2
            + " TEXT," + COL_3 + " TEXT" + ")";

    private static final String CREATE_TABLE_student = "CREATE TABLE "
            + TABLE_student + "(" + COL_1 + " INTEGER PRIMARY KEY," + COL_2
            + " TEXT," + COL_3 + " TEXT" + ")";

    private static final String CREATE_TABLE_STD_DETAILS ="CREATE TABLE "+ TABLE_STD_DETAILS
            + "(" + COL_1 +"INTEGER PRIMARY KRY," +std_name+"TEXT,"+std_mail+"TEXT,"+std_dept+"TEXT"+")";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_hod);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ao);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_pta);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ci);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_student);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENTS);

        // create new tables
        onCreate(db);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        db.execSQL(CREATE_TABLE_ao);
        db.execSQL(CREATE_TABLE_hod);
        db.execSQL(CREATE_TABLE_pta);
        db.execSQL(CREATE_TABLE_ci);
        db.execSQL(CREATE_TABLE_student);
        db.execSQL(CREATE_TABLE_STUDENTS);
    }

    public Cursor getdata(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from HOD",null);
        return cursor;
    }
    public Boolean insertdata(String name, Bitmap image, String dept, String year, String rollno){
        String e_mail=rollno+"@gmail.com";
        SQLiteDatabase db=this.getWritableDatabase();
        objectByteoutputstream=new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG,100,objectByteoutputstream);
        imageinbyte=objectByteoutputstream.toByteArray();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("image",imageinbyte);
        contentValues.put("dept",dept);
        contentValues.put("year",year);
        contentValues.put("rollno",rollno);
        contentValues.put("mail",e_mail);
        contentValues.put("pswd",password);
        long result=db.insert("student",null,contentValues);
        if(result==-1){
            return false;
        }
        else{
            return true;
        }
    }


}










