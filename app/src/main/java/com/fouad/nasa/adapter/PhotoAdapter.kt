package com.fouad.nasa.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fouad.nasa.databinding.ItemDataBinding
import com.fouad.nasa.Photo
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
        @SuppressLint("SetTextI18n")
        fun bind(photo: Photo) {
            photo.also { binding.listitem = it
//                binding.count.text
            }

            val image="https://mars.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01000/opgs/edr/fcam/FLB_486265257EDR_F0481570FHAZ00323M_.JPG"
            Picasso.get().load(image).into(binding.imgSrc)
            Log.e("image view ", "image  : $image")
        }

    }
}