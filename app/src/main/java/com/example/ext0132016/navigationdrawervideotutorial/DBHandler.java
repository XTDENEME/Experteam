package com.example.ext0132016.navigationdrawervideotutorial;

import android.content.ContentValues;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;


public class DBHandler extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 2;

    // Database Name
    private static final String DATABASE_NAME = "Bulentden6";

    // Contacts table name
    private static final String TABLE_SHOPS = "dene7";
    // Shops Table Columns names
    // private static final String KEY_ID = "id";
    private static final String OGRENCI_AD = "Ad";
    private static final String OGRENCI_SOYAD = "Soyad";
    private static final String OGRENCI_OKUL = "Okul";
    private static final String OGRENCI_BOLUM = "Bolum";
    private static final String OGRENCI_SINIF = "Sinif";
    private static final String OGRENCI_CINSIYET = "Cinsiyet";
    private static final String OGRENCI_ACIKLAMA = "Aciklama";

    private static final String TABLE_ANKET = "anket4";
    // Shops Table Columns names
    private static final String KEY_ID = "id";
    private static final String CINSIYET = "Cinsiyet";
    private static final String YAS = "Yas";
    private static final String DEPARTMAN = "Departman";
    private static final String YIL = "Yil";
    private static final String FAALIYET = "Faaliyet";
    private static final String SOSYAL = "Sosyal";
    private static final String UNVAN = "Unvan";
    private static final String BONUS = "Bonus";
    // private static final String OGRENCI_ACIKLAMA = "Aciklama";


    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_SHOPS + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + OGRENCI_AD + " TEXT,"
                + OGRENCI_SOYAD + " TEXT,"
                + OGRENCI_OKUL + " TEXT,"
                + OGRENCI_BOLUM + " TEXT,"
                + OGRENCI_SINIF + " TEXT,"
                + OGRENCI_CINSIYET + " TEXT,"
                + OGRENCI_ACIKLAMA + " TEXT " + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);

        String CREATE_CONTACTS_ARTABLE = "CREATE TABLE " + TABLE_ANKET + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + CINSIYET + " TEXT,"
                + YAS + " TEXT,"
                + DEPARTMAN + " TEXT,"
                + UNVAN + " TEXT,"
                + YIL + " TEXT,"
                + FAALIYET + " TEXT,"
                + SOSYAL + " TEXT,"
                + BONUS + " TEXT " + ")";
        db.execSQL(CREATE_CONTACTS_ARTABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SHOPS);

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ANKET);
// Creating tables again
        onCreate(db);

    }

    // Adding new shop
    public void addShop(String PAd, String PSoyad, String POkul, String PBolum, String PSinif, String PCinsiyet, String PAciklama) {
        SQLiteDatabase db = this.getWritableDatabase();
        String insertQuery = "insert into "+ TABLE_SHOPS +" (Ad, Soyad, Okul, Bolum, Sinif, Cinsiyet, Aciklama) values ('";
        insertQuery += PAd + "','" + PSoyad + "','" + POkul + "','" + PBolum + "','" + PSinif + "','" + PCinsiyet + "','" + PAciklama + "')";
        db.execSQL(insertQuery);
        //db.close();

    }

    public void addAnket(String PCinsiyet, String PYas, String PDepartman,String PUnvan, String PYil, String PFaaliyet, String PSosyal, String PBonus) {
        SQLiteDatabase db = this.getWritableDatabase();
        String insertQuery = "insert into "+ TABLE_ANKET+" (Cinsiyet, Yas, Departman,Unvan, Yil, Faaliyet, Sosyal,  Bonus) values ('";
        insertQuery += PCinsiyet + "','" + PYas + "','" + PDepartman + "','"+ PUnvan +"','" + PYil + "','" + PFaaliyet + "','" + PSosyal + "','" +PBonus+"')";
        db.execSQL(insertQuery);

    }
}
