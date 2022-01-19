package kr.hs.emirim.w2015.c34

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mutableList = mutableListOf<DriveVO>()
        mutableList.add(DriveVO("이미지", "2월 6일", "img"))
        mutableList.add(DriveVO("db.sip", "2월 6일", "file"))
        mutableList.add(DriveVO("안드로이드", "2월 6일", "doc"))

        val listView = findViewById<ListView>(R.id.custom_listView)
        val adapter = DriveAdapter(this, R.layout.custom_item, mutableList)
        listView.adapter = adapter
    }
}