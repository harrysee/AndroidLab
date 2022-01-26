package kr.hs.emirim.w2015.c66

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.imageView)
        val dataButton = findViewById<Button>(R.id.dataButton)
        val fileButton = findViewById<Button>(R.id.fileButton)


        // 데이터 획득 방법
        val lancher : ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){
            val bitmap = it.data?.getExtras()?.get("data") as Bitmap
            bitmap?.let{
                imageView.setImageBitmap(bitmap)
            }
        }
        dataButton.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            lancher.launch(intent)
        }

        // 파일 공유 방법 -------------------------
        var filePath =""
        val fileLauncher : ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){
            val option = BitmapFactory.Options()
            option.inSampleSize = 3
            val bitmap = BitmapFactory.decodeFile(filePath, option) // 사진 크기를 줄여서 가져오기
            bitmap?.let{
                imageView.setImageBitmap(bitmap)
            }
        }

        fileButton.setOnClickListener {
            // 파일 이름 - 지금시간
            val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
            val storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
            val file = File.createTempFile(
                "JPEG_${timeStamp}_", // 파일명
                ".jpg", //확장자
                storageDir  // 파일 경로 저장
            )
            // 이 파일의 경로 저장 - 나중에 뽑아야하니까
            filePath = file.absolutePath
            val uri = FileProvider.getUriForFile(
                this,
                "kr.hs.emirim.w2015.c66.fileprovider",
                file
            )
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri)
            fileLauncher.launch(intent)
        }

    }
}