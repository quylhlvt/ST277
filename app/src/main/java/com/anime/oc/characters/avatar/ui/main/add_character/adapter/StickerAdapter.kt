package com.anime.oc.characters.avatar.ui.main.add_character.adapter

import com.anime.oc.characters.avatar.core.base.BaseAdapter
import com.anime.oc.characters.avatar.core.extention.onClick
import com.anime.oc.characters.avatar.data.model.addcharacter.SelectedAddModel
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.anime.oc.characters.avatar.core.extention.gone
import com.anime.oc.characters.avatar.core.extention.visible
import com.anime.oc.characters.avatar.databinding.ItemStickerBinding
import com.anime.oc.characters.avatar.utils.DataLocal
import com.facebook.shimmer.ShimmerDrawable

class StickerAdapter : BaseAdapter<SelectedAddModel, ItemStickerBinding>(ItemStickerBinding::inflate) {
    var onItemClick: ((String, Int) -> Unit) = { _, _ -> }
    var currentSelected = -1
        private set

    override fun onBind(binding: ItemStickerBinding, item: SelectedAddModel, position: Int) {
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
