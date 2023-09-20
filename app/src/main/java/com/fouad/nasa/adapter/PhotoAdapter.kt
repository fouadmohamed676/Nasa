package com.fouad.nasa.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fouad.nasa.Network.BaseUrl
import com.fouad.nasa.databinding.ItemDataBinding
import com.fouad.nasa.Photo
import com.squareup.picasso.Picasso

class PhotoAdapter (private val clinkList: ArrayList<Photo>): RecyclerView.Adapter<PhotoAdapter.ClinkViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClinkViewHolder {

        return ClinkViewHolder(
            ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        )
    }

    override fun getItemCount(): Int {
        return clinkList.size
    }

    override fun onBindViewHolder(holder: ClinkViewHolder, position: Int) {
        val data = clinkList[position]
        holder.bind(data)

    }

    class ClinkViewHolder(val binding: ItemDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(photo: Photo) {
            binding.listitem = photo
            Picasso.get().load(BaseUrl.image_rl+photo.img_src).into(binding.imgSrc)

            Log.e("image view ", "image  : "+BaseUrl.image_rl+photo.img_src)

        }

    }
}