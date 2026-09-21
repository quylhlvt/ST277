package com.duomaker.couplelove.vatar.ui.main.add_character.adapter

import androidx.core.content.ContextCompat
import com.duomaker.couplelove.vatar.core.base.BaseAdapter
import com.duomaker.couplelove.vatar.core.extention.onClick
import com.duomaker.couplelove.vatar.data.model.addcharacter.StickerCategoryModel
import com.duomaker.couplelove.vatar.R
import com.duomaker.couplelove.vatar.databinding.ItemTittleBackgroundImageBinding

class StickerCategoryAdapter :
    BaseAdapter<StickerCategoryModel, ItemTittleBackgroundImageBinding>(
        ItemTittleBackgroundImageBinding::inflate
    ) {

    var onCategoryClick: ((StickerCategoryModel, Int) -> Unit) = { _, _ -> }

    override fun onBind(
        binding: ItemTittleBackgroundImageBinding,
        item: StickerCategoryModel,
        position: Int
    ) {

        binding.apply {
            txtTittle.text = item.category.replace('_', ' ')
            val context = binding.root.context

            if (item.isSelected) {
                txtTittle.setTextColor(ContextCompat.getColor(context,R.color.app_color))
                frameTittle.background = ContextCompat.getDrawable(context, R.drawable.bg_8_title)
            } else {
                txtTittle.setTextColor(ContextCompat.getColor(context,R.color.white))
                frameTittle.background = ContextCompat.getDrawable(context, R.drawable.bg_8_title_null)
            }
        }
        binding.root.onClick { onCategoryClick(item, position) }
    }
}
