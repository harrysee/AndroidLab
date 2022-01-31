package kr.hs.emirim.w2015.c85

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resultView = findViewById<TextView>(R.id.resultView)
        resultView.text = isNetworkAvailable()
    }

    @SuppressLint("MissingPermission")
    private fun isNetworkAvailable() : String{
        // 콘넥티비티 매니저를 뽑는 방법에 api에 따라 많이 다르기에 분기프로그램 작성
        val manager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            val nw = manager.activeNetwork ?: return "offline" // 네트웤 객체를 얻을때 null이면 오프라인상태리턴
            val actNw = manager.getNetworkCapabilities(nw) ?: return "offline"
            return when{
                //hasTransport함수에다가 판단하고싶은 타입정보를 줘서 이 상황인지 판단
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)->{
                    return "wifi online"
                }
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ->{
                    return "cellular online"
                }
                else -> "offline"
            }
        }else{
            if(manager.activeNetworkInfo!!.isConnected ?: false){
                return "online"
            }else{
                return "offline"
            }
        }
        
    }
}