package com.example.inflepick_2021_03_03.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.inflepick_2021_03_03.Model.*
import com.example.inflepick_2021_03_03.R


private const val TAG = "HotInfluencerAdapter"


class TagAdapter(
    val items: ArrayList<String>
) :
    RecyclerView.Adapter<TagAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tag, parent, false)
        // Adapter 내부에 정의된 ViewHolder에 정의된 레이아웃을 inflate해서 반환
        return ViewHolder(inflater)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        Log.d(TAG, "hot_keyword? ${items[position]}")

        viewHolder.tagTxt.text = "# ".plus(items[position])


    }

    override fun getItemCount(): Int {
//        return items.size
        Log.d(TAG, "=== getItemCount ===${items.size}")
        return items.size
    }


    // ViewHolder 클래스 정의를 통해 Adapter에서 사용할 뷰들을 연결
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tagTxt: TextView

        init {

            tagTxt = itemView.findViewById(R.id.tagTxt)


        }


//        fun setItem(item: TagModel, viewHolder: ViewHolder?) {
//
//            //컨텐츠 제목
//            tagTxt.text = item.hotKeyword.toString()
//            Log.d(TAG, "=== item.hotKeyword ===${item.hotKeyword}")
//
//
//        }

    }
}