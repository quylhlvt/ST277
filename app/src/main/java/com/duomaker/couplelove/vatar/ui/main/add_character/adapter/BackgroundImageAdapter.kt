package com.duomaker.couplelove.vatar.ui.main.add_character.adapter

import com.duomaker.couplelove.vatar.core.base.BaseAdapter
import com.duomaker.couplelove.vatar.core.extention.gone
import com.duomaker.couplelove.vatar.core.extention.onClick
import com.duomaker.couplelove.vatar.core.extention.visible
import com.duomaker.couplelove.vatar.data.model.addcharacter.SelectedAddModel
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.duomaker.couplelove.vatar.R
import com.duomaker.couplelove.vatar.databinding.ItemBackgroundImageBinding
import com.duomaker.couplelove.vatar.utils.DataLocal
import com.facebook.shimmer.ShimmerDrawable


class BackgroundImageAdapter : BaseAdapter<SelectedAddModel, ItemBackgroundImageBinding>(
    ItemBackgroundImageBinding::inflate
) {
    var onAddImageClick: (() -> Unit) = {}
    var onNoneImageClick: (() -> Unit) = {}
    var onBackgroundImageClick: ((String, Int) -> Unit) = { _, _ -> }
    var currentSelected = -1

    override fun onBind(binding: ItemBackgroundImageBinding, item: SelectedAddModel, position: Int) {
        binding.apply {
            val shimmerDrawable = ShimmerDrawable().apply { setShimmer(DataLocal.shimmer1) }
            if (currentSelected == position) {
                materiaForcus.visible()
            } else {
                materiaForcus.gone()
            }
            if (position == ADD_BACKGROUND_POSITION) {
                clearRemoteImageIfNeeded(imvImage, ADD_ITEM_TAG)
                lnlAddItem.visible()
                imvImage.gone()
                imvImageNone.gone()
                lnlAddItem.onClick { onAddImageClick() }
            } else if (position == NONE_BACKGROUND_POSITION) {
                clearRemoteImageIfNeeded(imvImage, NONE_ITEM_TAG)
                imvImageNone.visible()
                imvImage.gone()
                lnlAddItem.gone()
                imvImageNone.onClick { onNoneImageClick() }
            } else {
                lnlAddItem.gone()
                imvImageNone.gone()
                imvImage.visible()
                if (imvImage.tag != item.path) {
                    imvImage.tag = item.path
                    Glide.with(imvImage)
                        .load(item.path)
                        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                        .dontAnimate()
                        .placeholder(shimmerDrawable)
                        .into(imvImage)
                }
                imvImage.onClick { onBackgroundImageClick(item.path, position) }
            }
        }
    }

    private fun clearRemoteImageIfNeeded(imageView: android.widget.ImageView, tag: String) {
        if (imageView.tag == tag) return
        Glide.with(imageView).clear(imageView)
        imageView.tag = tag
    }

    fun selectItem(position: Int) {
        if (position == currentSelected) return
        val old = currentSelected
        currentSelected = position
        if (old in items.indices) notifyItemChanged(old)
        if (position in items.indices) notifyItemChanged(position)
    }

    fun clearSelection() {
        if (currentSelected < 0) return
        val old = currentSelected
        currentSelected = -1
        if (old in items.indices) notifyItemChanged(old)
    }

    private companion object {
        const val ADD_BACKGROUND_POSITION = 0
        const val NONE_BACKGROUND_POSITION = 1
        const val ADD_ITEM_TAG = "background_add_item"
        const val NONE_ITEM_TAG = "background_none_item"
    }
}
