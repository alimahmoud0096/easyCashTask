package com.smart4apps.easyCashTask.utils

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.smart4apps.easyCashTask.data.model.Competition
import com.smart4apps.easyCashTask.ui.adapter.CompetitionsAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("setCompetitionsList")
fun setCompetitionsList(rv: RecyclerView,competitions: List<Competition>) {
    Log.d("TAG", "setCompetitionsList: ${competitions.size}")
    (rv.adapter as CompetitionsAdapter).addData(competitions)
}

@BindingAdapter("loadImage")
fun loadImage(imageView: ImageView,url:String?) {
    url?.let {
        imageView.visibility=View.VISIBLE
        Picasso.get().load(url).into(imageView)
    }?: run {
        imageView.visibility=View.GONE
    }

}

