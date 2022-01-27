package kr.hs.emirim.w2015.c71

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.media.MediaPlayer
import android.os.IBinder

class MyService : Service() {
    lateinit var player : MediaPlayer

    var receiver = object: BroadcastReceiver(){
        override fun onReceive(p0: Context?, p1: Intent?) {
            val mode = p1?.getStringExtra("mode")
            if(mode != null){
                if(mode == "start"){
                    try{
                        if(player != null && player.isPlaying){
                            player.stop()
                            player.release()
                        }
                        player = MediaPlayer.create(p0, R.raw.music) // 음악 새로 세팅
                        player.start()
                    }catch (e: Exception){
                        e.printStackTrace()
                    }
                }else if(mode =="stop"){
                    if(player != null && player.isPlaying){
                        player.stop()
                    }
                }
            }
        }
    }

    override fun onCreate() {
        super.onCreate()
        player = MediaPlayer()
        registerReceiver(receiver, IntentFilter("PLAY_TO_SERVICE"))
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }
    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
}