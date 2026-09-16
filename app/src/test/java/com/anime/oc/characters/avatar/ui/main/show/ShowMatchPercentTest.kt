package com.duomaker.couplelove.vatar.ui.main.show

import com.duomaker.couplelove.vatar.data.model.custom.BodyPartModel
import com.duomaker.couplelove.vatar.data.model.custom.ColorModel
import com.duomaker.couplelove.vatar.data.model.custom.SelectionIndex
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
    fun correctItemAndWrongColorGivesNoProgress() {
        val percent = calculateMatchPercent(
            parts = listOf(coloredPart),
            target = listOf(SelectionIndex(0, colorIndex = 1, pathIndex = 3)),
            user = listOf(SelectionIndex(0, colorIndex = 0, pathIndex = 3))
        )

        assertEquals(0, percent)
    }

    @Test
    fun correctColorAndWrongItemGivesNoProgress() {
        val percent = calculateMatchPercent(
            parts = listOf(coloredPart),
            target = listOf(SelectionIndex(0, colorIndex = 1, pathIndex = 3)),
            user = listOf(SelectionIndex(0, colorIndex = 1, pathIndex = 2))
        )

        assertEquals(0, percent)
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

    @Test
    fun autoSelectedCorrectPartAndColorAreCountedAndRemovedWhenEitherIsWrong() {
        val bodyPart = BodyPartModel(
            listPath = arrayListOf(
                ColorModel("red", arrayListOf("dice", "red_body_1", "red_body_2")),
                ColorModel("blue", arrayListOf("dice", "blue_body_1", "blue_body_2"))
            )
        )
        val parts = listOf(bodyPart, coloredPart)
        val target = listOf(
            SelectionIndex(0, colorIndex = 0, pathIndex = 1),
            SelectionIndex(1, colorIndex = 0, pathIndex = 3)
        )
        val defaults = listOf(
            SelectionIndex(0, colorIndex = 0, pathIndex = 1),
            SelectionIndex(1, colorIndex = 0, pathIndex = 0)
        )
        val initialPercent = calculateMatchPercent(
            parts = parts,
            target = target,
            user = defaults
        )
        val afterWrongFirstPath = calculateMatchPercent(
            parts = parts,
            target = target,
            user = defaults.toMutableList().apply {
                this[0] = SelectionIndex(0, colorIndex = 0, pathIndex = 2)
            }
        )
        val afterWrongFirstColor = calculateMatchPercent(
            parts = parts,
            target = target,
            user = defaults.toMutableList().apply {
                this[0] = SelectionIndex(0, colorIndex = 1, pathIndex = 1)
            }
        )

        assertEquals(50, initialPercent)
        assertEquals(0, afterWrongFirstPath)
        assertEquals(0, afterWrongFirstColor)
    }
}
