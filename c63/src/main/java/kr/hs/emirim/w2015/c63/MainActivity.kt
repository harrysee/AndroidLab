package kr.hs.emirim.w2015.c63

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val resultView = findViewById<TextView>(R.id.resultView)

        val requestActivity : ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){
            val cursor = contentResolver.query(
                it.data!!.data!!,
                arrayOf(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER),
                null,
                null,
                null
            )
            var name = "none"
            var phone = "none"
            if(cursor!!.moveToNext()){
                name = cursor?.getString(0)
                phone = cursor?.getString(1)
            }
            resultView.text="name :$name, phone -$phone"

        }
        val permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ){ isGranted -> // 퍼미션 다이얼로그 뜬다음 수락했다면 실행되는 부분
            if(isGranted){
                val intent = Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI)
                requestActivity.launch(intent)
            }
        }

        // 버튼 눌렀을때
        button.setOnClickListener {
            val status = ContextCompat.checkSelfPermission(this, "android.permission.READ_CONTACTS")
            if(status == PackageManager.PERMISSION_GRANTED){
                val intent = Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI)
                requestActivity.launch(intent)
            }else{
                permissionLauncher.launch("android.permission.READ_CONTACTS")
            }
        }
    }

}