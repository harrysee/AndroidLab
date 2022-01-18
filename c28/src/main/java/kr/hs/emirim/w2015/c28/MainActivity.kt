package kr.hs.emirim.w2015.c28

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.TextView2)
        textView.text = getString(R.string.txt_data2)
        textView.setTextColor(ResourcesCompat.getColor(resources, R.color.txt_color, null))
        textView.setTextSize(resources.getDimension(R.dimen.txt_size))
    }
}