package com.example.inflepick_2021_03_03.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.inflepick_2021_03_03.Model.ProductList
import com.example.inflepick_2021_03_03.Model.Statistics
import com.example.inflepick_2021_03_03.R

class HotItemAdapter(
    private var productList: List<ProductList>
    ) : RecyclerView.Adapter<HotItemAdapter.HotItem2ViewHolder>() {

    interface onItemListener {
        fun onItemClickedHotItem(position: Int)
    }

    private lateinit var mListener: onItemListener

    fun setOnClickListener(listener: onItemListener) {
        this.mListener = listener
    }



    inner class HotItem2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val mainHotImv : ImageView = itemView.findViewById(R.id.mainHotImv)

        val mainHotCatTxt : TextView
        val mainHotBrandTxt : TextView
        val mainHotNameTxt : TextView

        val mainHotYTxt : TextView
        val mainHotITxt : TextView
        val mainHotBTxt : TextView

        init {

            mainHotCatTxt = itemView.findViewById(R.id.mainHotCatTxt)
            mainHotBrandTxt = itemView.findViewById(R.id.mainHotBrandTxt)
            mainHotNameTxt = itemView.findViewById(R.id.mainHotNameTxt)

            mainHotYTxt = itemView.findViewById(R.id.mainHotYTxt)
            mainHotITxt = itemView.findViewById(R.id.mainHotITxt)
            mainHotBTxt = itemView.findViewById(R.id.mainHotBTxt)

        }


        fun setItem(item: ProductList, viewHolder: HotItemAdapter.HotItem2ViewHolder?) {

            //컨텐츠 제목
            mainHotCatTxt.text = item.productCategory
            mainHotBrandTxt.text = item.brand
            mainHotNameTxt.text = item.name


            Glide.with(viewHolder!!.mainHotImv.context)
                .load(item.productImagePath)
                .into(mainHotImv)


            /*  ProductList 에서 statistics 객체
                "statistics": {
                "mention_count": 9,
                "posts_count": 4,
                "hashtag_count": 0,
                "blog_count": 0
              }

              */

            var statistics : Statistics? = item.statistics

            if(statistics!!.postsCount == 0){
                mainHotYTxt.visibility = View.GONE

            }

            if(statistics!!.hashtagCount == 0){
                mainHotITxt.visibility = View.GONE

            }

            if(statistics!!.blogCount == 0){
                mainHotBTxt.visibility = View.GONE

            }

            mainHotYTxt.text = "영상 리뷰 ".plus(statistics!!.postsCount.toString()).plus(" 건")
            mainHotITxt.text = "해쉬 태그 ".plus(statistics!!.hashtagCount.toString()).plus(" 건")
            mainHotBTxt.text = "블로그 리뷰 ".plus(statistics!!.blogCount.toString()).plus(" 건")

        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int ): HotItemAdapter.HotItem2ViewHolder {
        return HotItem2ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_item,parent,false))
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: HotItemAdapter.HotItem2ViewHolder, position: Int) {
//        holder.mainHotCatTxt.text = productList[position].productCategory
//        holder.mainHotBrandTxt.text = productList[position].brand
//        holder.mainHotNameTxt.text = productList[position].name
        var item: ProductList = productList[position]
        holder.setItem(item,holder)

    }




}