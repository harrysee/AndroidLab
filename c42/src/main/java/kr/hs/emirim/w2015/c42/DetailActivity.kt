package kr.hs.emirim.w2015.c42

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val id = intent.getStringExtra("id")
        val button = findViewById<Button>(R.id.finish)
        button.setOnClickListener {
            intent.putExtra("result", "hello : $id")
            setResult(Activity.RESULT_OK)
            finish()
        }
    }
}