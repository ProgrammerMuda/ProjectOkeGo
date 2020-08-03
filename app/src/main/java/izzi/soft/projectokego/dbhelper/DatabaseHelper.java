package izzi.soft.projectokego.dbhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.print.PageRange;
import android.print.PrinterId;

import java.util.ArrayList;
import java.util.List;

import izzi.soft.projectokego.Model.User;

public class DatabaseHelper extends SQLiteOpenHelper {

    public  DatabaseHelper (Context context){
        super(context, "Login.db",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("Create table user (phone text primary key, nama text, password text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("drop table if exists user");

    }

    public boolean insert (String phone, String nama , String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("phone", phone);
        contentValues.put("nama", nama);
        contentValues.put("password", password);
        long ins = db.insert("user", null, contentValues);
        if (ins==-1) return false;
        else return true;


    }

    public boolean checkPhone (String phone){
        SQLiteDatabase db = this. getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where phone=?", new String[]{phone});
        if (cursor.getCount()>0) return false;
        else return true;
    }

    public boolean phonepass (String phone, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where phone=? and password=?", new String[]{phone, password});
        if (cursor.getCount()>0) return true;
        else return false;
    }

//    private static final int DATABASE_VERSION = 1;
//    private static final String DATABASE_NAME = "OkeGoUser.db";
//    private static final String TABLE_USER = "user";
//    private static final String COLUMN_USERID = "user_id";
//    private static final String COLUMN_USER_NAME = "user_name";
//    private static final String COLUMN_USER_PHONE = "user_PHONE";
//    private static final String COLUMN_USER_PASSWORD = "user_password";
//
//    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
//            + COLUMN_USERID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
//            + COLUMN_USER_PHONE + " TEXT,"
//            + COLUMN_USER_PASSWORD + " TEXT" + ")";
//
//    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;
//
//    public DatabaseHelper (Context context){
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//
//    }
//
//
//
//
//
//
//    @Override
//    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        sqLiteDatabase.execSQL(CREATE_USER_TABLE);
//
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//        sqLiteDatabase.execSQL(DROP_USER_TABLE);
//        onCreate(sqLiteDatabase);
//
//    }
//
//    public void adduser (User user){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_USER_NAME, user.getName());
//        values.put(COLUMN_USER_PHONE, user.getPhone());
//        values.put(COLUMN_USER_PASSWORD, user.getPassword());
//        db.insert(TABLE_USER, null, values);
//        db.close();
//
//
//    }
//
//    public List<User> getAllUser(){
//        String[] columns = {
//                COLUMN_USERID,
//                COLUMN_USER_PHONE,
//                COLUMN_USER_NAME,
//                COLUMN_USER_PASSWORD
//        };
//
//        String sortOrder = COLUMN_USER_NAME + " ASC";
//        List<User> userList = new ArrayList<User>();
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.query(TABLE_USER, null, null
//                , null, null, null, sortOrder
//        );
//
//        if (cursor.moveToFirst()){
//            do{
//                User user = new User();
//                user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USERID))));
//                user.setName(cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME)));
//                user.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD)));
//                user.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD)));
//                userList.add(user);
//            }
//
//            while (cursor.moveToNext());
//
//
//        }
//
//        cursor.close();
//        db.close();
//
//        return userList;
//
//
//
//    }
//
//    public boolean checkUser(String phone){
//        String[] columns = {
//                COLUMN_USERID
//        };
//
//        SQLiteDatabase db = this.getReadableDatabase();
//        String selection = COLUMN_USER_PHONE + " = ?";
//        String[] selectionArgs = {phone};
//        Cursor cursor = db.query(TABLE_USER, columns, selection, selectionArgs, null, null, null);
//        int cursorCount = cursor.getCount();
//        cursor.close();
//        db.close();
//        if (cursorCount > 0) {
//            return  true;
//        }
//        return false;
//    }
//
//    public void addUser(User user){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_USER_NAME, user.getName());
//        values.put(COLUMN_USER_PHONE, user.getPhone());
//        values.put(COLUMN_USER_PASSWORD, user.getPassword());
//        db.insert(TABLE_USER, null, values);
//        db.close();
//
//    }

//    public boolean checkphone (String phone){
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery("Select * from")
//    }


//    public boolean checkUser(String phone, String password) {
//
//        // array of columns to fetch
//        String[] columns = {
//                COLUMN_USERID
//        };
//        SQLiteDatabase db = this.getReadableDatabase();
//        // selection criteria
//        String selection = COLUMN_USER_PHONE + " = ?" + " AND " + COLUMN_USER_PASSWORD + " = ?";
//
//        // selection arguments
//        String[] selectionArgs = {phone, password};
//
//        // query user table with conditions
//        /**
//         * Here query function is used to fetch records from user table this function works like we use sql query.
//         * SQL query equivalent to this query function is
//         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
//         */
//        Cursor cursor = db.query(TABLE_USER, //Table to query
//                columns,                    //columns to return
//                selection,                  //columns for the WHERE clause
//                selectionArgs,              //The values for the WHERE clause
//                null,                       //group the rows
//                null,                       //filter by row groups
//                null);                      //The sort order
//
//        int cursorCount = cursor.getCount();
//
//        cursor.close();
//        db.close();
//        if (cursorCount > 0) {
//            return true;
//        }
//
//        return false;
//    }
}
