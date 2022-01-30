package kr.hs.emirim.w2015.c81

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    lateinit var resultView : TextView
    lateinit var manager : LocationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultView = findViewById<TextView>(R.id.resultView)
        manager = getSystemService(Context.LOCATION_SERVICE) as LocationManager

        val launcher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ){ isGranted ->
            if(isGranted){
                getLocation()
            }else{
                Toast.makeText(this, "denied..", Toast.LENGTH_SHORT)
            }
        }

        val status = ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION")
        if(status == PackageManager.PERMISSION_GRANTED){
            getLocation()
        }else{
            launcher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }

    }

    fun getLocation(){
        // 실행 시 문제 없지만 selfcheckpermission으로 체크안해서 그럼
        // 우리는 다른쪽에서 처리하여 빨간색으로 나오지만 무시 ㅇㅇ
        val location = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
        location?.let {
            val latitude = location.latitude
            val longitude = location.longitude
            val accuracy = location.accuracy
            val time = location.time

            resultView.text = "$latitude,\n $longitude,\n $accuracy,\n $time"
        }
    }
}