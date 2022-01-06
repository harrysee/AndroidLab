package kr.hs.emirim.w2015.c11

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var visibleBtn : Button
    lateinit var logo : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//
//        val name = TextView(this).apply{
//            typeface = Typeface.DEFAULT_BOLD
//            text = "SeSAC"
//        }
//        val image = ImageView(this).also{
//            it.setImageDrawable(ContextCompat.getDrawable(
//                this, R.drawable.logo_1
//            ))
//        }
//        val title = TextView(this).apply{
//            typeface = Typeface.DEFAULT_BOLD
//            text = "JetPack과 Kotlin을 활용한 Android App 개발"
//        }
//        val layout = LinearLayout(this).apply {
//            orientation = LinearLayout.VERTICAL
//            gravity = Gravity.CENTER
//            addView(name, WRAP_CONTENT,  WRAP_CONTENT)
//            addView(image, WRAP_CONTENT,  WRAP_CONTENT)
//            addView(title, WRAP_CONTENT,  WRAP_CONTENT)
//        }
//        setContentView(R.layout.activity_main)
        visibleBtn = findViewById(R.id.visible)
        logo = findViewById(R.id.logo)
        visibleBtn.setOnClickListener{
            logo.visibility = View.VISIBLE
        }
        setContentView(R.layout.activity_main)
    }
}