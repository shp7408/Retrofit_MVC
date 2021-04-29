package com.example.inflepick_2021_03_03.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.inflepick_2021_03_03.Model.adDTO
import com.example.inflepick_2021_03_03.R

class ViewPagerADAdapter(private var adDTOs: List<adDTO>) : RecyclerView.Adapter<ViewPagerADAdapter.Pager2ViewHolder>() {

    inner class Pager2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val img_slide_image: ImageView = itemView.findViewById(R.id.img_slide_image)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerADAdapter.Pager2ViewHolder {
        return Pager2ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_ad, parent, false))
    }

    override fun getItemCount(): Int {
        return adDTOs.size
    }

    override fun onBindViewHolder(holder: ViewPagerADAdapter.Pager2ViewHolder, position: Int) {
        holder.img_slide_image.setImageResource(adDTOs[position].image)



    }
}