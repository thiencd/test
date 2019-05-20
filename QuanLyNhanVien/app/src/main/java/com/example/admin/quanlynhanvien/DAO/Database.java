package com.example.admin.quanlynhanvien.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

    private static String DATABASE_NAME="QLNhanVien";
    private static int DATABASE_VERSION=1;
    public static String TABLE_NHANVIEN="NhanVien";
    public static String MANV_NHANVIEN="MaNV";
    public static String TEN_NHANVIEN="TenNV";
    public static String SDT_NHANVIEN="SDT";
    public static String GIOITINH_NHANVIEN="GioiTinh";
    public static String DIACHI_NHANVIEN="DiaChi";
    public static String EMAIL_NHANVIEN="Email";
    public static String LUONG_NHANVIEN="Luong";

    public static String TABLE_PHONGBAN="PhongBan";
    public static String MaPB_PHONGBAN="MaPB";
    public static String TenPB_PHONGBAN="TenPB";


    public Database(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String taoBanhNhanVien="create table " + TABLE_NHANVIEN +"(" +MANV_NHANVIEN +"Integer primary key autoincrement,"
                + TEN_NHANVIEN +"text,"
                + SDT_NHANVIEN +"text,"
                + GIOITINH_NHANVIEN +"text,"
                + DIACHI_NHANVIEN +"text,"
                + EMAIL_NHANVIEN +"text,"
                + LUONG_NHANVIEN +"Integer," + MaPB_PHONGBAN+"integer Constraint PK_MaPB_NhanVien references PhongBan(MaPB)"+")";

        String taoBangPhongBan ="create table " + TABLE_PHONGBAN +"(" +MaPB_PHONGBAN +"text primary key autoincrement,"
                + TenPB_PHONGBAN +"text)";

        db.execSQL(taoBanhNhanVien);
        db.execSQL(taoBangPhongBan);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String xoaBangNV = String.format("crop table if exists%s", TABLE_NHANVIEN);
        String xoaBangPB= String.format("crop table if exists%s", TABLE_PHONGBAN);
            db.execSQL(xoaBangNV);
            db.execSQL(xoaBangPB);

    }
}
