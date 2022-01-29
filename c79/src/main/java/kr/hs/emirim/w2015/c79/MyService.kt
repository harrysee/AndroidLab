package kr.hs.emirim.w2015.c79

import android.app.job.JobParameters
import android.app.job.JobService
import android.util.Log

class MyService : JobService() {

    override fun onCreate() {
        super.onCreate()
        Log.d("TAG", "onCreate: MyService...onCreate...")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TAG", "onCreate: MyService...onDestroy...")

    }

    override fun onStartJob(p0: JobParameters?): Boolean {
        TODO("Not yet implemented")
        Log.d("TAG", "onCreate: MyService...onStart...")
        return false
    }

    override fun onStopJob(p0: JobParameters?): Boolean {
        TODO("Not yet implemented")
        Log.d("TAG", "onCreate: MyService...onStopJob...")
        return false

    }
}