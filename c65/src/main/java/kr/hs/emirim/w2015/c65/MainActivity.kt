package kr.hs.emirim.w2015.c65

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editView = findViewById<EditText>(R.id.editView)
        val button = findViewById<Button>(R.id.button)

        val permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ){ isGranted->
            if(isGranted){
                val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel${editView.text}"))
                startActivity(intent)
            }else{
                Toast.makeText(this, "denied", Toast.LENGTH_SHORT).show()
            }
        }

        button.setOnClickListener {
            val status = ContextCompat.checkSelfPermission(this, "android.permission.CALL_PHONE")
            if(status == PackageManager.PERMISSION_GRANTED){
                val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel${editView.text}"))
                startActivity(intent)
            }else{
                permissionLauncher.launch("android.permission.CALL_PHONE")
            }
        }
    }
}