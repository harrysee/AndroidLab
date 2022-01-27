package kr.hs.emirim.w2015.c72

import android.content.ComponentName
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var binder : MyService.MyBinder

    // 서비스를 사용하기 위한 객체를 받는 connection
    val connection : ServiceConnection = object :ServiceConnection{
        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            binder = p1 as MyService.MyBinder
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            TODO("Not yet implemented")
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton = findViewById<ImageView>(R.id.startButton)
        val stopButton = findViewById<ImageView>(R.id.stopButton)

        startButton.setOnClickListener {
            binder.startMusic()
            startButton.isEnabled = false
            stopButton.isEnabled = true
        }
        stopButton.setOnClickListener {
            binder.stopMusic()
            startButton.isEnabled = true
            startButton.isEnabled = false
        }
    }
}