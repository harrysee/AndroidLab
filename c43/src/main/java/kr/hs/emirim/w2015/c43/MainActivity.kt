package kr.hs.emirim.w2015.c43

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent()
            intent.action = "ACTION_DETATL"
            intent.data = Uri.parse("http://www.google.com")
            startActivity(intent)
        }
    }
}