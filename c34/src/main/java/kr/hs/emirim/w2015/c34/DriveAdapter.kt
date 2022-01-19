package kr.hs.emirim.w2015.c34

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat

class DriveAdapter(cxt: Context, val resId:Int, val datas: MutableList<DriveVO>)
    : ArrayAdapter<DriveVO>(cxt, resId){
    override fun getCount(): Int {
        return datas.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        if(convertView == null){
            // 뷰 객체를 정의되어있는대로 초기화시켜서 생성
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(resId, null)
            // resId : R.layout.파일 -> 넘겨진것이 없으면 직접 생성하여 사용할것
            val holder = DriveHolder(convertView)
            convertView!!.tag = holder
        }
        val holder = convertView.getTag() as DriveHolder
        val typeImageView = holder.typeImageView
        val titleview = holder.titleView
        val dateView = holder.dateView
        val menuImageview = holder.menuImageView

        val (title,type,date) = datas[position]
        titleview.text = title
        dateView.text = date
        if(type =="doc"){
            typeImageView.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        context.resources,
                        R.drawable.ic_type_doc,null
                    )
            )
        }else if(type=="file"){
            typeImageView.setImageDrawable(
                ResourcesCompat.getDrawable(
                    context.resources,
                    R.drawable.ic_type_file,null
                )
            )
        }else if(type=="img"){
            typeImageView.setImageDrawable(
                ResourcesCompat.getDrawable(
                    context.resources,
                    R.drawable.ic_type_image,null
                )
            )
        }
        menuImageview.setOnClickListener{
            Toast.makeText(context, "$title menu click", Toast.LENGTH_SHORT ).show()
        }
        return  convertView
    }
    
}