package kr.hs.emirim.w2015.c47

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {

    // 스코프 생성(디스패쳐 넣기)
    var backgroundScope = CoroutineScope(Dispatchers.Default+ Job())

    lateinit var button:Button
    lateinit var resultView:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        resultView = findViewById(R.id.resultView)

        button.setOnClickListener {
            backgroundScope.launch {
                // 코루틴 구동 시 실행되는 코드
                var sum = 0L
                var time = measureTimeMillis {
                    for(i in 1..2_000_000_000){
                        sum+=1
                    }
                }
                // 다른 디스패쳐에게 의뢰해야한다 - 뷰를 찍는 일은
                withContext(Dispatchers.Main){
                    resultView.text = "sum : $sum"
                }
            }
        }
    }
}