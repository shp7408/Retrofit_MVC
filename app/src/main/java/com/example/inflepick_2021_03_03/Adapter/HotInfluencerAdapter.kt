package com.example.inflepick_2021_03_03.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.inflepick_2021_03_03.Model.InfluencerList
import com.example.inflepick_2021_03_03.Model.PostsList
import com.example.inflepick_2021_03_03.Model.Statistics
import com.example.inflepick_2021_03_03.Model.adDTO
import com.example.inflepick_2021_03_03.R


private const val TAG = "HotInfluencerAdapter"


class HotInfluencerAdapter(
    val items: ArrayList<InfluencerList>
) :
    RecyclerView.Adapter<HotInfluencerAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_influencer, parent, false)
        // Adapter 내부에 정의된 ViewHolder에 정의된 레이아웃을 inflate해서 반환
        return ViewHolder(inflater)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        var item: InfluencerList = items[position]
        viewHolder.setItem(item, viewHolder)


    }

    override fun getItemCount(): Int {
//        return items.size
        return items.size
    }


    // ViewHolder 클래스 정의를 통해 Adapter에서 사용할 뷰들을 연결
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var influencerImg: ImageView
        var influencerNameTxt: TextView
        var influencerCatTxt: TextView

        init {

            influencerImg = itemView.findViewById(R.id.influencerImg)
            influencerNameTxt = itemView.findViewById(R.id.influencerNameTxt)
            influencerCatTxt = itemView.findViewById(R.id.influencerCatTxt)

        }


        fun setItem(item: InfluencerList, viewHolder: ViewHolder?) {

            //컨텐츠 제목
            influencerNameTxt.text = item.nickname

            /* category_name 이 list로 받아옴
            * "category_name": [
                "패션"
               ]
            * */
            var categoryName: List<String>? = item.categoryName

            // TODO: 2021-03-15 일단 카테고리 하나만 보이게 함. 나중에 변경해야 함.. 
/*            var category = ""

            for (i in 0 .. categoryName!!.size-1) {
                Log.d(TAG, "=== categoryName() 반복문 === i : $i")
                Log.d(TAG, "=== categoryName() 반복문 === i : ${categoryName[i]}")
                category.plus(categoryName[i])
            }*/

            influencerCatTxt.text = categoryName!!.get(0)

            Glide.with(viewHolder!!.influencerImg.context)
                .load(item.profileImagePath)
                .circleCrop()
                .into(influencerImg)

        }

    }
}