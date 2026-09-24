package com.warrior.oc.ca.ui.language

import android.annotation.SuppressLint
import android.content.Context
import androidx.core.content.ContextCompat
import com.warrior.oc.ca.core.base.BaseAdapter
import com.warrior.oc.ca.core.extention.onClick
import com.warrior.oc.ca.data.model.language.LanguageModel
import com.warrior.oc.ca.R
import com.warrior.oc.ca.databinding.ItemLanguageBinding

class LanguageAdapter (val context: Context) : BaseAdapter<LanguageModel, ItemLanguageBinding>(
    ItemLanguageBinding::inflate
) {
    var onItemClick: ((String) -> Unit) = {}
    override fun onBind(
        binding: ItemLanguageBinding, item: LanguageModel, position: Int
    ) {
        binding.apply {
            imvFlag.setImageResource(item.flag)
            val strokeStartColor = ContextCompat.getColor(
                context,
                if (item.activate) R.color.white else R.color.language_stroke_start
            )
            val strokeCenterColor = ContextCompat.getColor(
                context,
                if (item.activate) R.color.white else R.color.language_stroke_center
            )
            val strokeEndColor = ContextCompat.getColor(
                context,
                if (item.activate) R.color.white else R.color.language_stroke_end
            )
            imgLangFor.setGradientColors(
                strokeStartColor,
                strokeCenterColor,
                strokeEndColor
            )
            tvLang.setGradientColors(strokeStartColor, strokeEndColor)
            bg.setBackgroundResource(if (item.activate) R.drawable.bg_linear_color else R.color.white4)
            btnRadio.setImageResource(if (item.activate) R.drawable.ic_select_lang else R.drawable.ic_un_select_lang)
            tvLang.text = item.name
            root.onClick { onItemClick.invoke(item.code) }
        }
    }
    @SuppressLint("NotifyDataSetChanged")
    fun submitItem(position: Int) {
        val oldSelected = items.indexOfFirst { it.activate }
        items.forEach { it.activate = false }
        items[position].activate = true
        // Chỉ update 2 item thay đổi, không redraw toàn bộ list
        if (oldSelected >= 0) notifyItemChanged(oldSelected)
        notifyItemChanged(position)
    }
}
