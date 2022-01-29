package kr.hs.emirim.w2015.c74

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener{
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val builder : NotificationCompat.Builder
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                val channelId = "one-channel"
                val channelName = "My One Channel"
                val channel = NotificationChannel(
                    channelId,
                    channelName,
                    NotificationManager.IMPORTANCE_HIGH
                )
                
                channel.description = "My Channel One Description" // 채널에 주는 정보
                channel.setShowBadge(true)  //배치아이콘의 노티피캐이션정보 출력
                val uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)  // 음을 플레이하기 위해서 준비
                // 음원과 관련된 정보 설정
                val audio = AudioAttributes.Builder().setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                                                                .setUsage(AudioAttributes.USAGE_ALARM)
                                                                .build()
                channel.setSound(uri, audio)    //알림음설정
                channel.enableLights(true) // 채널이 뜰때 빛이 깜밖거리게
                channel.lightColor = Color.RED  //
                channel.enableVibration(true) // 진동사용
                channel.vibrationPattern = longArrayOf(100, 200,100,200) // 진동패턴
                
                // 채널 매니져에 등록하기 - 여러개를 등록가능 (아이디값을 등록)
                manager.createNotificationChannel(channel)
                
                // 채널을 가지고 빌더 만들기 -
                builder = NotificationCompat.Builder(this,channelId)
            }else{
                builder = NotificationCompat.Builder(this)
            }
            builder.setSmallIcon(android.R.drawable.ic_notification_overlay)
            builder.setWhen(System.currentTimeMillis())
            builder.setContentTitle("Title")
            builder.setContentText("message")
            
            // 띄우기 - 빌더가 노티피 객체만들어서 띄움
            manager.notify(1, builder.build())
        }
    }
}