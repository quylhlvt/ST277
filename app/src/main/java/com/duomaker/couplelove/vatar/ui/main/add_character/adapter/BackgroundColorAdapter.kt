package com.duomaker.couplelove.vatar.ui.main.add_character.adapter

import com.duomaker.couplelove.vatar.core.base.BaseAdapter
import com.duomaker.couplelove.vatar.core.extention.gone
import com.duomaker.couplelove.vatar.core.extention.onClick
import com.duomaker.couplelove.vatar.core.extention.visible
import com.duomaker.couplelove.vatar.data.model.addcharacter.SelectedAddModel
import com.duomaker.couplelove.vatar.databinding.ItemBackgroundColorBinding


class BackgroundColorAdapter : BaseAdapter<SelectedAddModel, ItemBackgroundColorBinding>(
    ItemBackgroundColorBinding::inflate
) {
    var onNoneColorClick: (() -> Unit) = {}
    var onChooseColorClick: (() -> Unit) = {}
    var onBackgroundColorClick: ((Int, Int) -> Unit) = { _, _ -> }
    var currentSelected = -1

    override fun onBind(binding: ItemBackgroundColorBinding, item: SelectedAddModel, position: Int) {
        binding.apply {
            if (currentSelected == position) {
                materiaForcus.visible()
            } else {
                materiaForcus.gone()
            }
            when (position) {
                NONE_COLOR_POSITION -> {
                    imvColorNone.visible()
                    imvAddColor.gone()
                    imvColor.gone()
                    root.onClick { onNoneColorClick() }
                }

                ADD_COLOR_POSITION -> {
                    imvColorNone.gone()
                    imvAddColor.visible()
                    imvColor.gone()
                    root.onClick { onChooseColorClick() }
                }

                else -> {
                    imvColorNone.gone()
                    imvAddColor.gone()
                    imvColor.visible()
                    imvColor.setBackgroundColor(item.color)
                    root.onClick { onBackgroundColorClick(item.color, position) }
                }
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
        if (currentSelected < 0) return
        val old = currentSelected
        currentSelected = -1
        if (old in items.indices) notifyItemChanged(old)
    }

    private companion object {
        const val NONE_COLOR_POSITION = 0
        const val ADD_COLOR_POSITION = 1
    }
}
