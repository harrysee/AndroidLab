package kr.hs.emirim.w2015.c72

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder

class MyService : Service() {

    inner class MyBinder : Binder(){
        var player = MediaPlayer()
        fun startMusic(){
            try{
                if(player != null && player.isPlaying){
                    player.stop()
                    player.release()
                }
                player = MediaPlayer.create(applicationContext, R.raw.music)
                player.start()
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
        fun stopMusic(){
            if(player != null && player.isPlaying){
                player.stop()
            }
        }
    }
    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
        return MyBinder()
    }
}