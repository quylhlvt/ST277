package com.warrior.oc.ca.ui.main.listcat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.warrior.oc.ca.databinding.ItemCatPageBinding

class ListCatAdapter(private val catAssets: List<String>) :
    RecyclerView.Adapter<ListCatAdapter.CatViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CatViewHolder(
        ItemCatPageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) =
        holder.bind(catAssets[position])

    override fun getItemCount() = catAssets.size

    class CatViewHolder(private val binding: ItemCatPageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(assetPath: String) {
            Glide.with(binding.catImage)
                .load("file:///android_asset/$assetPath")
                .fitCenter()
                .into(binding.catImage)
        }
    }
}
