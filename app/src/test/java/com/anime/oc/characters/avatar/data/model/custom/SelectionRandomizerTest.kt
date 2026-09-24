package com.warrior.oc.ca.data.model.custom

import com.warrior.oc.ca.data.model.custom.BodyPartModel
import com.warrior.oc.ca.data.model.custom.ColorModel
import com.warrior.oc.ca.data.model.custom.SelectionIndex
import com.warrior.oc.ca.data.model.custom.randomizePartSelection
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import kotlin.random.Random

class SelectionRandomizerTest {

    @Test
    fun randomizesColorAndPathAsOneValidSelection() {
        val bodyPart = BodyPartModel(
            listPath = arrayListOf(
                ColorModel("red", arrayListOf("none", "dice", "red_1", "red_2")),
                ColorModel("blue", arrayListOf("none", "dice", "blue_1", "blue_2"))
            )
        )
        val random = Random(277)
        val selectedColors = mutableSetOf<Int>()

        repeat(100) {
            val selection = randomizePartSelection(
                bodyPart = bodyPart,
                currentSelection = SelectionIndex(0, colorIndex = 0, pathIndex = 2),
                random = random
            )
            selectedColors += selection.colorIndex
            val color = bodyPart.listPath[selection.colorIndex]
            val path = color.listPath[selection.pathIndex]

            assertFalse(path.equals("none", ignoreCase = true))
            assertFalse(path.equals("dice", ignoreCase = true))
            assertTrue(path.startsWith(color.color))
        }

        assertEquals(setOf(0, 1), selectedColors)
    }

    @Test
    fun keepsCurrentColorWhenPartHasNoColorCodes() {
        val bodyPart = BodyPartModel(
            listPath = arrayListOf(
                ColorModel("", arrayListOf("none", "dice", "part_1", "part_2"))
            )
        )

        repeat(20) {
            val selection = randomizePartSelection(
                bodyPart = bodyPart,
                currentSelection = SelectionIndex(0, colorIndex = 0, pathIndex = 2),
                random = Random(it)
            )

            assertEquals(0, selection.colorIndex)
            assertTrue(selection.pathIndex == 2 || selection.pathIndex == 3)
        }
    }

    @Test
    fun ignoresColorEntriesWithoutAColorCodeOrSelectableItem() {
        val bodyPart = BodyPartModel(
            listPath = arrayListOf(
                ColorModel("", arrayListOf("none", "dice", "uncolored_1")),
                ColorModel("red", arrayListOf("none", "dice")),
                ColorModel("blue", arrayListOf("none", "dice", "blue_1"))
            )
        )

        repeat(20) {
            val selection = randomizePartSelection(
                bodyPart = bodyPart,
                currentSelection = SelectionIndex(0, colorIndex = 0, pathIndex = 2),
                random = Random(it)
            )

            assertEquals(2, selection.colorIndex)
            assertEquals(2, selection.pathIndex)
        }
    }
}
