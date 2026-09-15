package com.anime.oc.characters.avatar.ui.main.show

import com.anime.oc.characters.avatar.data.model.custom.BodyPartModel
import com.anime.oc.characters.avatar.data.model.custom.ColorModel
import com.anime.oc.characters.avatar.data.model.custom.SelectionIndex
import org.junit.Assert.assertEquals
import org.junit.Test

class ShowMatchPercentTest {
    private val coloredPart = BodyPartModel(
        listPath = arrayListOf(
            ColorModel("red", arrayListOf("none", "dice", "red_1", "red_2")),
            ColorModel("blue", arrayListOf("none", "dice", "blue_1", "blue_2"))
        )
    )

    @Test
    fun correctItemAndWrongColorGivesPartialProgress() {
        val percent = calculateMatchPercent(
            parts = listOf(coloredPart),
            target = listOf(SelectionIndex(0, colorIndex = 1, pathIndex = 3)),
            user = listOf(SelectionIndex(0, colorIndex = 0, pathIndex = 3))
        )

        assertEquals(50, percent)
    }

    @Test
    fun correctColorAndWrongItemGivesPartialProgress() {
        val percent = calculateMatchPercent(
            parts = listOf(coloredPart),
            target = listOf(SelectionIndex(0, colorIndex = 1, pathIndex = 3)),
            user = listOf(SelectionIndex(0, colorIndex = 1, pathIndex = 2))
        )

        assertEquals(50, percent)
    }

    @Test
    fun correctColorAndItemGivesFullProgress() {
        val selection = SelectionIndex(0, colorIndex = 1, pathIndex = 3)

        assertEquals(
            100,
            calculateMatchPercent(
                parts = listOf(coloredPart),
                target = listOf(selection),
                user = listOf(selection)
            )
        )
    }

    @Test
    fun diceOnlyTargetDoesNotCreateImpossibleProgress() {
        val diceOnlyPart = BodyPartModel(
            listPath = arrayListOf(ColorModel("", arrayListOf("dice")))
        )

        assertEquals(
            0,
            calculateMatchPercent(
                parts = listOf(diceOnlyPart),
                target = listOf(SelectionIndex(0, 0, 0)),
                user = listOf(SelectionIndex(0, 0, 1))
            )
        )
    }
}
