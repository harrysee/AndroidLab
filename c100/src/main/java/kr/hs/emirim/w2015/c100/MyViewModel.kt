package kr.hs.emirim.w2015.c100

import android.os.SystemClock
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.concurrent.thread

class MyViewModel : ViewModel() {
    // 뷰모델 상속, 나머지 API는 개발자 마음
    var sum=0
    fun calSum() : MutableLiveData<String>{
        val liveData = MutableLiveData<String>()
        thread {
            for(i in 1..10){
                sum+=i
                liveData.postValue(sum.toString()) // liveData값 리턴콜
                SystemClock.sleep(100)
            }
        }

        return liveData
    }
}