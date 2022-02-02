package kr.hs.emirim.w2015.c93

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyAdapter(activity:FragmentActivity):FragmentStateAdapter(activity) {
    val fragments: List<Fragment>
    init {
        fragments = listOf(OneFragment(), TwoFragment(),ThreeFragment())
    }

    override fun getItemCount(): Int {
        return fragments.size
    }

    // 항목을 결정하기위해 자동 콜되는 함수
    override fun createFragment(position: Int): Fragment {
        // 매개변수에 해당되는 프레그먼트를 리턴
        return fragments[position]
    }
}