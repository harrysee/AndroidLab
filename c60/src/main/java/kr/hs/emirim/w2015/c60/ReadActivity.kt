package kr.hs.emirim.w2015.c60

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ReadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read)

        val titleView = findViewById<TextView>(R.id.read_title)
        val contentView = findViewById<TextView>(R.id.read_content)

        val helper = DBHelper(this)
        val db = helper.readableDatabase

        val cursor = db.rawQuery("select title, content from tb_memo order by _id desc limit 1",null)
        while (cursor.moveToNext()){
            titleView.setText(cursor.getString(0))
            contentView.setText((cursor.getString(1)))
        }
        db.close()

    }
}