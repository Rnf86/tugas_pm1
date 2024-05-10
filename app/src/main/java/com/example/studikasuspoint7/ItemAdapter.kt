package com.example.studikasuspoint7

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ItemAdapter(private val items: List<News>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    var context:Context?= null
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivNews : ImageView = itemView.findViewById(R.id.iv_news)
        val tvTitle : TextView = itemView.findViewById(R.id.tv_title)
        val tvDescription : TextView = itemView.findViewById(R.id.tv_descript)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        context=parent.context
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = items[position]
        context?.let { Glide.with(it).load(currentItem.image_url).into(holder.ivNews) };
        holder.tvTitle.text = currentItem.title
        holder.tvDescription.text = currentItem.description
    }

    override fun getItemCount() = items.size
}
