package kr.hs.emirim.w2015.c82

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class MainActivity : AppCompatActivity() {
    lateinit var resultView : TextView
    lateinit var providerClient : FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultView = findViewById(R.id.resultView)
        // 이 객체보고 위치추적하라고 명령내리는 순간(연결될때connect)
        val apiClient = GoogleApiClient.Builder(this)   
            .addApi(LocationServices.API)
            // 알아서 밑의 콜백 두개가 호출됨
            .addConnectionCallbacks(connectionCallback)
            .addOnConnectionFailedListener(connectionFailedCallback)
            .build()
        providerClient = LocationServices.getFusedLocationProviderClient(this)

        val launcher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ){
            if(it){
                apiClient.connect()
            }else{
                Toast.makeText(this, "denied", Toast.LENGTH_SHORT).show()
            }
        }

        val status = ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION")
        if(status == PackageManager.PERMISSION_GRANTED){
            apiClient.connect()
        }else{
            launcher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }

    // 프로바이더 사용 콜백
    val connectionCallback = object : GoogleApiClient.ConnectionCallbacks{
        override fun onConnected(p0 : Bundle?){ // 특정 프로바이더 사용 가능한 상태일때 호출
            // 위치값 획득 요청하기
            providerClient.lastLocation.addOnSuccessListener {
                //획득 결과값은 콜백을 통해 전달 여기로
                val latitude = it?.latitude
                val longtude = it?.longitude
                resultView.text = "$latitude, $longtude"
            }
        }

        override fun onConnectionSuspended(p0: Int) {
            // 이용하던 프로바이더가 갑자기 이용 불가능해졌을때 호출
        }
    }

    // 프로바이더 요청을 했을때 상황에 따라 모든 프로바이더가 사용 불가능한 상황일때 호출
    val connectionFailedCallback = object :GoogleApiClient.OnConnectionFailedListener{
        override fun onConnectionFailed(p0: ConnectionResult) {
            TODO("Not yet implemented")
            //구현은 안하고 토스트 띄우는게 일반적
        }

    }
}