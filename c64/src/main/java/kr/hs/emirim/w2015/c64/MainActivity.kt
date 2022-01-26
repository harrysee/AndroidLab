package kr.hs.emirim.w2015.c64

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.imageView)
        val button = findViewById<Button>(R.id.button)

        val launcher : ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){
                try{
                    val option  = BitmapFactory.Options()
                    option.inSampleSize = 5

                    val inputStream = contentResolver.openInputStream(it.data!!.data!!)
                    val bitmap = BitmapFactory.decodeStream(inputStream, null, option)
                    inputStream!!.close()
                    bitmap?.let {
                        imageView.setImageBitmap(bitmap)
                    } ?: let{

                    }
                }catch (e:Exception){
                    e.printStackTrace()
                }
            }
        button.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            intent.type ="image/*"
            launcher.launch(intent)

        }
    }
}