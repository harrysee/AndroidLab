package kr.hs.emirim.w2015.c60

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context:Context) : SQLiteOpenHelper(context, "memodb",null,1) {
    override fun onCreate(p0: SQLiteDatabase?) {
        val memoSQL = "create table tb_memo(" +
                "_id integer primary key autoincrement," +
                "title," +
                "content)"
        p0?.execSQL(memoSQL)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

}