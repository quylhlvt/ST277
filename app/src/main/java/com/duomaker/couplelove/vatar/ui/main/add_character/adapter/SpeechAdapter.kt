package com.duomaker.couplelove.vatar.ui.main.add_character.adapter

import com.duomaker.couplelove.vatar.core.base.BaseAdapter
import com.duomaker.couplelove.vatar.core.extention.onClick
import com.duomaker.couplelove.vatar.data.model.addcharacter.SelectedAddModel
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.duomaker.couplelove.vatar.core.extention.gone
import com.duomaker.couplelove.vatar.core.extention.visible
import com.duomaker.couplelove.vatar.databinding.ItemSpeechBinding
import com.duomaker.couplelove.vatar.utils.DataLocal
import com.facebook.shimmer.ShimmerDrawable

class SpeechAdapter : BaseAdapter<SelectedAddModel, ItemSpeechBinding>(ItemSpeechBinding::inflate) {
    var onItemClick: ((String, Int) -> Unit) = { _, _ -> }
    var currentSelected = -1
        private set

    override fun onBind(binding: ItemSpeechBinding, item: SelectedAddModel, position: Int) {
        binding.apply {
            if (currentSelected == position) {
                materiaForcus.visible()
            } else {
                materiaForcus.gone()
            }
            val shimmerDrawable = ShimmerDrawable().apply { setShimmer(DataLocal.shimmer1) }
            if (imvImage.tag != item.path) {
                imvImage.tag = item.path
                Glide.with(imvImage)
                    .load(item.path)
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .override(256)
                    .dontAnimate()
                    .placeholder(shimmerDrawable)
                    .into(imvImage)
            }
            root.onClick {
                onItemClick(item.path, position)
            }
        }
    }

    fun selectItem(position: Int) {
        if (position == currentSelected) return
        val old = currentSelected
        currentSelected = position
        if (old in items.indices) notifyItemChanged(old)
        if (position in items.indices) notifyItemChanged(position)
    }

    fun clearSelection() {
        if (currentSelected !in items.indices) {
            currentSelected = -1
            return
        }
        val old = currentSelected
        currentSelected = -1
        notifyItemChanged(old)
    }
}
