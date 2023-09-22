package com.fouad.nasa.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fouad.nasa.ui.MainActivity
import com.fouad.nasa.databinding.ItemDataBinding
import com.fouad.nasa.Photo
import com.fouad.nasa.ui.DetailsActivity
import com.squareup.picasso.Picasso

class PhotoAdapter (private val dataList: ArrayList<Photo>): RecyclerView.Adapter<PhotoAdapter.ClinkViewHolder>() {

     var count:Int=0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClinkViewHolder {
        return ClinkViewHolder(
            ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        )
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ClinkViewHolder, position: Int) {
        val data = dataList[position]
        holder.bind(data)
    }

    class ClinkViewHolder(private val binding: ItemDataBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n", "SuspiciousIndentation")
        fun bind(photo: Photo) {
            photo.also { binding.listitem = it
            }
            Picasso.get().load(photo.img_src).into(binding.imgSrc)
            Log.e("image view ", "image  : image")
            itemView.setOnClickListener {
                val intent =Intent(itemView.context, DetailsActivity::class.java)
                intent.putExtra("id",photo.id)
                intent.putExtra("photo","photo")
                intent.putExtra("sol",photo.sol)
                intent.putExtra("camera",photo.camera.getString("id"))
                intent.putExtra("camera",photo.camera.getString("name"))
                intent.putExtra("camera",photo.camera.getString("full_name"))
                intent.putExtra("name",photo.rover.getString("name"))
                intent.putExtra("rover",photo.rover.getString("status"))
                intent.putExtra("rover",photo.rover.getString("max_date"))
                intent.putExtra("img_src",photo.img_src)
                itemView.context.startActivity(intent)
            }
        }

    }
}