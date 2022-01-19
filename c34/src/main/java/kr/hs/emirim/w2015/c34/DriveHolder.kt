package kr.hs.emirim.w2015.c34

import android.view.View
import android.widget.ImageView
import android.widget.TextView

class DriveHolder(root:View) {
    var typeImageView: ImageView
    var titleView : TextView
    var dateView : TextView
    var menuImageView : ImageView

    init {
        typeImageView = root.findViewById(R.id.custom_item_type_image)
        titleView = root.findViewById(R.id.custom_item_title)
        dateView = root.findViewById(R.id.custom_item_date)
        menuImageView = root.findViewById(R.id.custom_item_menu)
    }
}