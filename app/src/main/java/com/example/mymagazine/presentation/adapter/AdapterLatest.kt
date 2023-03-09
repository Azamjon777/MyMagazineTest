package com.example.mymagazine.presentation.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mymagazine.R
import com.example.mymagazine.data.models.LatestItem

class AdapterLatest(private val context: Context) :
    RecyclerView.Adapter<AdapterLatest.ViewHolder>() {
    var listLatestProducts = emptyList<LatestItem>()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_latest, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val categoryL = holder.itemView.findViewById<TextView>(R.id.item_category_latest)
        val nameL = holder.itemView.findViewById<TextView>(R.id.item_product_name_latest)
        val priceL = holder.itemView.findViewById<TextView>(R.id.item_price_of_model_latest)
        val imageViewL: ImageView = holder.itemView.findViewById(R.id.item_img_latest)

        categoryL.text = listLatestProducts[position].category
        nameL.text = listLatestProducts[position].name
        priceL.text = listLatestProducts[position].price.toString()
        Glide.with(context)
            .load(listLatestProducts[position].image_url)
            .into(imageViewL)
    }

    override fun getItemCount(): Int {
        return listLatestProducts.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setListLatest(listLatest: List<LatestItem>) {
        listLatestProducts = listLatest
        notifyDataSetChanged()
    }
}