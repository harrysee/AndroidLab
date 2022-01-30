package kr.hs.emirim.w2015.c83

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng

class MainActivity : AppCompatActivity(), OnMapReadyCallback{
    
    var googleMap :GoogleMap? = null // 지도 객체

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        // 콜백함수가 현재 클래스에 있어서 this로 콜백 등록
        (supportFragmentManager.findFragmentById(R.id.mapView) as SupportMapFragment)!!.getMapAsync(this)
        
    }

    override fun onMapReady(p0: GoogleMap?) {
        // 지도객체가 이용가능할때 콜됨 - 매개변수로 들어옼
        googleMap = p0
        val latLng = LatLng(37.566610, 126.9)
        val position = CameraPosition.Builder() // 지도화면을 설정하기 위한 정보준비
            .target(latLng) //센터위치
            .zoom(16f) // 얼만큼 확대할지 지정
            .build()
        // 위의 정보로 지도의 센터가 보이게끔 설정하기
        googleMap?.moveCamera(CameraUpdateFactory.newCameraPosition(position))
    }
}