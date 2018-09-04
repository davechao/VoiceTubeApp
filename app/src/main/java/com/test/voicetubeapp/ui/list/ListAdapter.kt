package com.test.voicetubeapp.ui.list

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.request.RequestOptions
import com.test.voicetubeapp.R
import com.test.voicetubeapp.repository.model.VideoItem

class ListAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var context: Context
    private var videoList: MutableList<VideoItem> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        context = parent.context
        val mView = LayoutInflater.from(parent.context).inflate(R.layout.item_video, parent, false)
        return VideoViewHolder(mView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = videoList[position]

        holder as VideoViewHolder

        val options = RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round)
                .priority(Priority.HIGH)

        Glide.with(context)
                .load(item.img)
                .apply(options)
                .into(holder.videoImageView)

        holder.titleTextView.text = item.title
    }

    override fun getItemCount() = videoList.size

    fun setData(list: MutableList<VideoItem>) {
        videoList = list
        notifyDataSetChanged()
    }

    class VideoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val videoImageView = itemView.findViewById<ImageView>(R.id.videoImageView)
        val titleTextView = itemView.findViewById<TextView>(R.id.titleTextView)
    }

}