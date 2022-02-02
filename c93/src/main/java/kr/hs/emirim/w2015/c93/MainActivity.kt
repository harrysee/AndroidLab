package kr.hs.emirim.w2015.c93

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kr.hs.emirim.w2015.c93.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewpager2.adapter = MyAdapter(this)
    }
}