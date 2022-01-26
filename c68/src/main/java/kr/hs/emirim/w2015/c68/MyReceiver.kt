package kr.hs.emirim.w2015.c68

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        TODO("MyReceiver.onReceive() is not implemented")
        Log.d("kkang", "receiver....")
        // 로그가 잘 실행되면 리시버 잘실행된거 체크임
    }
}