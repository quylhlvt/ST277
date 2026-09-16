package com.duomaker.couplelove.vatar.ui.main.createPony

import com.duomaker.couplelove.vatar.core.base.BaseAdapter
import com.duomaker.couplelove.vatar.data.model.custom.CustomModel
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.duomaker.couplelove.vatar.R
import com.duomaker.couplelove.vatar.databinding.ItemChooseBinding
import com.duomaker.couplelove.vatar.utils.DataLocal
import com.facebook.shimmer.ShimmerDrawable

class ChoosePonyAdapter(
    private val onClick: (character: CustomModel, position: Int) -> Unit
) : BaseAdapter<CustomModel, ItemChooseBinding>(ItemChooseBinding::inflate) {

    init {
        setHasStableIds(true)
    }

    override fun getItemId(position: Int): Long =
        items.getOrNull(position)?.id?.hashCode()?.toLong() ?: position.toLong()

    override fun onBind(binding: ItemChooseBinding, item: CustomModel, position: Int) {
        if (binding.imvImage.tag != item.avatar) {
            val shimmerDrawable = ShimmerDrawable().apply { setShimmer(DataLocal.shimmer1) }
            binding.imvImage.tag = item.avatar
            Glide.with(binding.imvImage)
                .load(item.avatar)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .override(512)
                .dontAnimate()
                .placeholder(shimmerDrawable)
                .into(binding.imvImage)
        }

        binding.root.setOnClickListener { onClick(item, position) }
    }
}
