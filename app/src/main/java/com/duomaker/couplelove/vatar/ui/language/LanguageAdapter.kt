package com.duomaker.couplelove.vatar.ui.language

import android.annotation.SuppressLint
import android.content.Context
import com.duomaker.couplelove.vatar.core.base.BaseAdapter
import com.duomaker.couplelove.vatar.core.extention.onClick
import com.duomaker.couplelove.vatar.data.model.language.LanguageModel
import com.duomaker.couplelove.vatar.R
import com.duomaker.couplelove.vatar.databinding.ItemLanguageBinding

class LanguageAdapter (val context: Context) : BaseAdapter<LanguageModel, ItemLanguageBinding>(
    ItemLanguageBinding::inflate
) {
    var onItemClick: ((String) -> Unit) = {}
    override fun onBind(
        binding: ItemLanguageBinding, item: LanguageModel, position: Int
    ) {
        binding.apply {
            imvFlag.setImageResource(item.flag)
            bg.setBackgroundResource(if (item.activate) R.drawable.bg_linear_color else R.color.app_color5)
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