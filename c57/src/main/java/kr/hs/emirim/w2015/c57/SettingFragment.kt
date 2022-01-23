package kr.hs.emirim.w2015.c57

import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.preference.EditTextPreference
import androidx.preference.ListPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat

class SettingFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings, rootKey)

        val idPreference = findPreference<EditTextPreference>("serverId")
        val soundPreference = findPreference<ListPreference>("sound_list")

        idPreference?.setOnPreferenceChangeListener { preference, newValue ->
            // 새로 입력된 값을 토스트로 출력
            Toast.makeText(activity, "$newValue", Toast.LENGTH_SHORT).show()
            true
        }
        
        // list에서 유저가 선택한 값을 summary에 그대로 출력
        soundPreference!!.setSummaryProvider ( ListPreference.SimpleSummaryProvider.getInstance() )
        idPreference!!.summaryProvider =
            Preference.SummaryProvider<EditTextPreference>{preference ->
                val text = preference.text   // 유저가 설정한 값 가져오기
                if(TextUtils.isEmpty(text)){
                    "설정이 되지않음"
                }else{
                    "설정된 id값은 $text 입니다."
                }
            }
        
    }

}