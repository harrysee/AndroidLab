package kr.hs.emirim.w2015.c55

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editView = findViewById<EditText>(R.id.editView)
        val checkView = findViewById<CheckBox>(R.id.checkView)
        val saveButton = findViewById<Button>(R.id.saveButton)
        val getButton = findViewById<Button>(R.id.getButton)
        val resultView = findViewById<TextView>(R.id.resultView)

        // 파일명- my_prefs / 앱전체에서 사용하기
        val sharedPref = getSharedPreferences("my_prefs", Context.MODE_PRIVATE)

        saveButton.setOnClickListener {
            sharedPref.edit().run {
                putString("data1",editView.text.toString())
                putBoolean("data2",checkView.isChecked)
                commit()
            }
        }

        getButton.setOnClickListener {
            val data1 = sharedPref.getString("data1", "none")
            val data2 = sharedPref.getBoolean("data2",false)
            resultView.text = "data1: $data1, data2:$data2"
        }
    }
}