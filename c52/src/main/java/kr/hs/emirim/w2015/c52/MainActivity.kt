package kr.hs.emirim.w2015.c52

import android.annotation.SuppressLint
import android.content.Context
import android.media.RingtoneManager
import android.net.Uri
import android.os.*
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongConstant", "MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val vibButton = findViewById<Button>(R.id.vibration)
        val beepButton = findViewById<Button>(R.id.beep)

        vibButton.setOnClickListener {
            val vibrator = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.S){
                val vibManager = this.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
                vibManager.defaultVibrator
            }else{
                getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            }

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                vibrator.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE))
            }else{
                vibrator.vibrate(500)
            }
        }

        beepButton.setOnClickListener {
            val uri : Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val ringtone = RingtoneManager.getRingtone(applicationContext, uri)
            ringtone.play()
        }

    }
}