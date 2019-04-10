package com.hobby.kidult.myhobbyforkidult.helper;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Ps4Game_DbHelper extends SQLiteOpenHelper {

    private SQLiteDatabase db;
    private Context mContext;

    // DBHelper 생성자로 관리할 DB 이름과 버전 정보를 받음
    public Ps4Game_DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        //db = getWritableDatabase();
        this.mContext = context;
        db = getWritableDatabase();
    }

    // DB를 새로 생성할 때 호출되는 함수
    @Override
    public void onCreate(SQLiteDatabase db) {
        // 새로운 테이블 생성
        db.execSQL("CREATE TABLE PS4_GAME (_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " game_name TEXT, game_condition TEXT, game_open_yn TEXT" +
                ", game_ending_yn TEXT, game_rent_yn TEXT" +
                ", game_price INTEGER, game_buy_date NUMERIC);");
    }

    //public void testDB() { db = getReadableDatabase(); }

    // DB 업그레이드를 위해 버전이 변경될 때 호출되는 함수
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS PS4_GAME");
        onCreate(db);
    }

    public long getCount(String tableName)
    {
        SQLiteDatabase db = getReadableDatabase();
        long count = DatabaseUtils.queryNumEntries(db, tableName);
        db.close();
        return count;
    }

    public void insert(String game_name, String game_condition, String game_open_yn,
                       String game_ending_yn, String game_rent_yn,
                       int game_price, String game_buy_date) {
        // 읽고 쓰기가 가능하게 DB 열기
        SQLiteDatabase db = getWritableDatabase();
        // DB에 입력한 값으로 행 추가
        db.execSQL("INSERT INTO PS4_GAME VALUES(null, " +
                "'" + game_name + "','" + game_condition + "', '" + game_open_yn + "'," +
                "'" + game_ending_yn + "','" + game_rent_yn + "'," +
                "'" + game_price + "','" + game_buy_date + "');");
        db.close();
    }

    public void update(String item, int price) {
        SQLiteDatabase db = getWritableDatabase();
        // 입력한 항목과 일치하는 행의 가격 정보 수정
        db.execSQL("UPDATE PS4_GAME SET price=" + price + " WHERE item='" + item + "';");
        db.close();
    }

    public void delete(String item) {
        SQLiteDatabase db = getWritableDatabase();
        // 입력한 항목과 일치하는 행 삭제
        db.execSQL("DELETE FROM PS4_GAME WHERE item='" + item + "';");
        db.close();
    }

    public String getResult() {
        // 읽기가 가능하게 DB 열기
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
        Cursor cursor = db.rawQuery("SELECT * FROM PS4_GAME", null);
        while (cursor.moveToNext()) {
            result += cursor.getString(0)
                    + " : "
                    + cursor.getString(1)
                    + " | "
                    + cursor.getInt(2)
                    + "원 "
                    + cursor.getString(3)
                    + "\n";
        }

        return result;
    }



}
