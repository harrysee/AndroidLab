package kr.hs.emirim.w2015.c68

import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.resultView)
        val button = findViewById<Button>(R.id.button)

        registerReceiver(null, IntentFilter(Intent.ACTION_BATTERY_CHANGED))!!.apply {
            // 시스템 배터리 상태 바꼇을때
            var isCharging = "Not Plugged"
            when(getIntExtra(BatteryManager.EXTRA_STATUS, -1)){ // 현재배터리상태
                BatteryManager.BATTERY_STATUS_CHARGING ->{ // 충전되고있는상황
                    when(getIntExtra(BatteryManager.EXTRA_PLUGGED, -1)){
                        BatteryManager.BATTERY_PLUGGED_USB->{ // 저속충전
                            isCharging = "USB Plugged"
                        }
                        BatteryManager.BATTERY_PLUGGED_AC ->{ // 고속충전
                            isCharging = "AC Plugged"
                        }
                    }
                }
            }

            // 현재 몇퍼센트인지 알아내기
            val level = getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
            val scale = getIntExtra(BatteryManager.EXTRA_SCALE, -1)
            val batteryPct = level / scale.toFloat() *100 // 현재 퍼센트계산
            
            textView.text = "$isCharging, $batteryPct %"

        }
        button.setOnClickListener {
            val intent = Intent(this, MyReceiver::class.java)
            sendBroadcast(intent)
        }

    }
}