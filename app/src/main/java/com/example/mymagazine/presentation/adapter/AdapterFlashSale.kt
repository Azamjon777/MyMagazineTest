package com.example.mymagazine.presentation.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mymagazine.R
import com.example.mymagazine.domain.models.FlashSaleItemD

class AdapterFlashSale(private val context: Context, val listener: Listener) :
    RecyclerView.Adapter<AdapterFlashSale.ViewHolder>() {
    var listFlashSaleProducts = emptyList<com.example.mymagazine.domain.models.FlashSaleItemD>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_flash_sale, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val nameF: TextView = holder.itemView.findViewById(R.id.item_product_name_flash)
        val categoryF: TextView = holder.itemView.findViewById(R.id.item_category_flash)
        val priceF: TextView = holder.itemView.findViewById(R.id.item_price_of_model_flash)
        val discountF: TextView = holder.itemView.findViewById(R.id.text_item_discount_flash)
        val imageViewF: ImageView = holder.itemView.findViewById(R.id.item_img_flash)

        nameF.text = listFlashSaleProducts[position].name
        categoryF.text = listFlashSaleProducts[position].category
        priceF.text = listFlashSaleProducts[position].price.toString()
        discountF.text = listFlashSaleProducts[position].discount.toString()
        Glide.with(context)
            .load(listFlashSaleProducts[position].image_url)
            .into(imageViewF)

        holder.itemView.setOnClickListener {
            listener.onClick(listFlashSaleProducts[position])
        }
    }

    override fun getItemCount(): Int {
        return listFlashSaleProducts.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setFlashList(listFlashSale: List<com.example.mymagazine.domain.models.FlashSaleItemD>) {
        listFlashSaleProducts = listFlashSale
        notifyDataSetChanged()

        Log.d("Flash", listFlashSaleProducts.toString())
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    interface Listener {
        fun onClick(flashItem: com.example.mymagazine.domain.models.FlashSaleItemD)
    }
}