package com.example.inflepick_2021_03_03.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.inflepick_2021_03_03.Model.PostsList
import com.example.inflepick_2021_03_03.R


class HotContentAdapter(
    val items: ArrayList<PostsList>
) :
    RecyclerView.Adapter<HotContentAdapter.ViewHolder>() {



    //클릭 인터페이스 정의
    interface ItemClickListener {
        fun onClick(view: View, position: Int)
    }

    //클릭리스너 선언
    private lateinit var itemClickListner: ItemClickListener

    //클릭리스너 등록 매소드
    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListner = itemClickListener
    }

    //

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_hotcontent, parent, false)
        // Adapter 내부에 정의된 ViewHolder에 정의된 레이아웃을 inflate해서 반환
        return ViewHolder(inflater)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        var item: PostsList = items[position]
        viewHolder.setItem(item, viewHolder)

        //view에 onClickListner를 달고, 그 안에서 직접 만든 itemClickListener를 연결시킨다
        viewHolder.itemView.setOnClickListener {
            itemClickListner.onClick(it, position)
        }

//        viewHolder.itemView.setOnClickListener {
//            if (position != RecyclerView.NO_POSITION) {
//                //리스너 객체의 메소드 호출
//                if (mListener != null) {
//                    mListener.onItemClickedHotContent(position)
//                }
//            }
//        }

    }

    override fun getItemCount(): Int {
//        return items.size
        return items.size
    }


    // ViewHolder 클래스 정의를 통해 Adapter에서 사용할 뷰들을 연결
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var hotContentItmImg: ImageView
        var hotContentItmTxt: TextView

        init {

            hotContentItmImg = itemView.findViewById(R.id.hotContentItmImg)
            hotContentItmTxt = itemView.findViewById(R.id.hotContentItmTxt)

        }


        fun setItem(item: PostsList, viewHolder: ViewHolder?) {

            //컨텐츠 제목
            hotContentItmTxt.text = item.title


            Glide.with(viewHolder!!.hotContentItmImg.context)
                .load(item.thumbnailImagePath)
                .into(hotContentItmImg)

        }

    }
}