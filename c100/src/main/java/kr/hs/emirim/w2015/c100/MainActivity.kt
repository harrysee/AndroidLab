package kr.hs.emirim.w2015.c100

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import kr.hs.emirim.w2015.c100.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 뷰모델 프로바이더를 이용한 것과 같음
        val model : MyViewModel by viewModels()

        binding.button.setOnClickListener {
            model.calSum().observe(this){
                // 라이브데이터가 넘어오면 이게 실행됨
                binding.resultView.text = it
            }
        }
    }
}