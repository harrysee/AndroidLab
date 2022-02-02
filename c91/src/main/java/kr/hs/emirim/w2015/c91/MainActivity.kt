package kr.hs.emirim.w2015.c91

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kr.hs.emirim.w2015.c91.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val oneFragment = OneFragment()
        val twoFragment = TwoFragment()

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()

        transaction.add(R.id.fragment_content, oneFragment)
        transaction.commit()

        binding.oneBtn.setOnClickListener{
            val tran = manager.beginTransaction()
            tran.replace(R.id.fragment_content, oneFragment)
            tran.commit()
        }

        binding.twoBtn.setOnClickListener{
            val tran = manager.beginTransaction()
            tran.replace(R.id.fragment_content, twoFragment)
            tran.commit()
        }

    }
}