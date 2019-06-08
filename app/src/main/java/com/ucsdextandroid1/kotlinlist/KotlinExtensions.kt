package com.ucsdextandroid1.kotlinlist

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.service.media.MediaBrowserService
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowId
import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by rjaylward on 2019-06-08
 */

//TODO viewgroup inflate extension
fun ViewGroup.inflate(id: Int, attchtoRoot: Boolean ): View {
    return LayoutInflater.from(context).inflate(id, this, false)
}

//TODO picasso extension
fun ImageView.loadImageUrl(url: String?, placeholder: Drawable = ColorDrawable(Utils.randomColor())): Unit {
    Picasso.get().load(url)
            .placeholder(placeholder)
            .into(this)

}