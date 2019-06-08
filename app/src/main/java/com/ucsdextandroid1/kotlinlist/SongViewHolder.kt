package com.ucsdextandroid1.kotlinlist

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.squareup.picasso.Picasso
import com.ucsdextandroid1.kotlinlist.Models.SongItem

/**
 * Created by rjaylward on 2019-06-08
 */
class SongViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val imageView: ImageView = itemView.findViewById(R.id.vsi_image)
    private val titleView = itemView.findViewById<TextView>(R.id.vsi_title)
    private val subtitleView: TextView

    private var currentSongItem: SongItem? = null
     var clickListener: OnItemClickListener<SongItem>? = null

    init {

        subtitleView = itemView.findViewById(R.id.vsi_subtitle)

        itemView.setOnClickListener { v ->
            if ( currentSongItem != null)
                clickListener?.onItemClicked(currentSongItem)
        }
    }

     fun bind(songItem: SongItem) {
        this.currentSongItem = songItem

//        Picasso.get().load(songItem.artwork)
//                .placeholder(ColorDrawable(Utils.randomColor()))
//                .into(imageView)
         imageView.loadImageUrl(songItem.artwork, ColorDrawable(Color.BLUE))
        titleView.text = songItem.trackName
        subtitleView.text = String.format("%s • %s", songItem.albumName, songItem.artistName)
    }

    companion object {
        @JvmStatic
        fun inflate(parent: ViewGroup): SongViewHolder {
            //TODO replace with extension method parent.inflate(...)
            return SongViewHolder(parent.inflate(R.layout.viewholder_song_item, false))
//            return SongViewHolder(LayoutInflater.from(parent.context)
//                    .inflate(R.layout.viewholder_song_item, parent, false))
        }
    }

}
