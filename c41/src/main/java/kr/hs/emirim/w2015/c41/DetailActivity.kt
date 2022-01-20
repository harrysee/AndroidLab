package kr.hs.emirim.w2015.c41

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val id = intent.getIntExtra("id",0)
        val title = intent.getStringExtra("title")

        val resultView = findViewById<TextView>(R.id.text)
        resultView.text = "id : $id, title: $title"
    }
}