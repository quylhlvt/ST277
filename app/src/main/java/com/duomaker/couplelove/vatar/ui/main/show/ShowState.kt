package com.duomaker.couplelove.vatar.ui.main.show

import com.duomaker.couplelove.vatar.data.model.custom.BodyPartModel
import com.duomaker.couplelove.vatar.data.model.custom.ColorModel
import com.duomaker.couplelove.vatar.data.model.custom.CustomModel
import com.duomaker.couplelove.vatar.data.model.custom.SelectionIndex

data class ShowState(
    val template        : CustomModel?         = null,
    val listData        : List<BodyPartModel>  = emptyList(),
    /** Selections của nhân vật random từ Cosplay — đây là ĐÁP ÁN */
    val targetSelections: List<SelectionIndex> = emptyList(),
    /** Selections user đang chỉnh — giống CustomizeState.selections */
    val userSelections  : List<SelectionIndex> = emptyList(),
    val currentNavIndex     : Int     = 0,
    val currentNavIndexChar1: Int     = 0,
    val currentNavIndexChar2: Int     = 0,
    val activeCharacter    : Int     = 1,
    val isLoading          : Boolean = true,
    val matchPercent       : Int     = 0
) {
    val currentColors: List<ColorModel>
        get() = listData.getOrNull(currentNavIndex)?.listPath ?: emptyList()
    val currentPaths: List<String>
        get() {
            val sel = userSelections.getOrNull(currentNavIndex) ?: return emptyList()
            return listData.getOrNull(currentNavIndex)
                ?.listPath?.getOrNull(sel.colorIndex)?.listPath ?: emptyList()
        }
    val currentColorIndex: Int    get() = userSelections.getOrNull(currentNavIndex)?.colorIndex ?: 0
    val currentPathIndex : Int    get() = userSelections.getOrNull(currentNavIndex)?.pathIndex  ?: 0
    val hasMultipleColors: Boolean get() = (listData.getOrNull(currentNavIndex)?.listPath?.size ?: 0) > 1
}
