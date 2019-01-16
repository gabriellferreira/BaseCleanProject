package br.com.gabrielferreira.baseclean.presentation.util.extension

import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.support.annotation.ColorRes
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions

fun ImageView.load(url: String) {
    Glide.with(this.context)
            .load(url)
            .into(this)
}

fun ImageView.loadUri(uri: Uri) {
    Glide.with(this.context)
            .load(uri)
            .into(this)
}

fun ImageView.loadCenterCrop(url: String) {
    Glide.with(this.context)
            .load(url)
            .apply(RequestOptions().centerCrop())
            .into(this)
}

fun ImageView.loadCenterCropWithPlaceHolder(url: String, @DrawableRes placeHolderId: Int) {
    Glide.with(this.context)
            .load(url)
            .apply(RequestOptions().centerCrop().placeholder(ContextCompat.getDrawable(context, placeHolderId)))
            .into(this)
}

fun ImageView.loadWithPlaceholderColor(url: String, @ColorRes colorId: Int) {
    Glide.with(this.context)
            .load(url)
            .apply(RequestOptions().placeholder(ColorDrawable(ContextCompat.getColor(this.context, colorId))))
            .into(this)
}

fun ImageView.loadWithPlaceholderImage(url: String, @DrawableRes imageId: Int) {
    val d = ContextCompat.getDrawable(context, imageId)
    Glide.with(this.context)
            .load(url)
            .apply(RequestOptions().placeholder(d))
            .into(this)
}

fun ImageView.loadWithListener(url: String, listener: RequestListener<Drawable>) {
    Glide.with(this.context)
            .load(url)
            .listener(listener)
            .into(this)
}