package kr.hs.emirim.w2015.c19

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tab1 = findViewById<Button>(R.id.tab1)
        val tab2 = findViewById<Button>(R.id.tab2)
        val content1 = findViewById<TextView>(R.id.content1)
        val content2 = findViewById<TextView>(R.id.content2)

        tab1.setOnClickListener{
            content1.visibility = View.VISIBLE
            content2.visibility = View.INVISIBLE
        }
        tab2.setOnClickListener{
            content2.visibility = View.VISIBLE
            content1.visibility = View.INVISIBLE
        }
    }
}