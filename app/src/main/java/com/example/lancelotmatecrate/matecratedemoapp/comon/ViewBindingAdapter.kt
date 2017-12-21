package com.example.lancelotmatecrate.matecratedemoapp.comon

import android.databinding.BindingAdapter
import android.support.annotation.ColorRes
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

/**
 * Created by lancelotmatecrate on 20.12.17.
 */
@BindingAdapter("visible")
fun setVisible(view: View, visible: Boolean) {
    if (visible) {
        view.setVisibility(View.VISIBLE)
    } else {
        view.setVisibility(View.GONE)
    }
}

@BindingAdapter("textColorResource")
fun setTextColorResource(textView: TextView, @ColorRes color: Int) {
    textView.setTextColor(ContextCompat.getColor(textView.context, color))

}

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, imageUrl: String) {
    Picasso.with(view.context)
            .load(imageUrl)
            .into(view)
}