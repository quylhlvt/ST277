package com.warrior.oc.ca.data.model.custom

import kotlin.random.Random

/**
 * Randomizes the visible item of one body part. When the part exposes color
 * codes, the color and the item belonging to that color are randomized as one
 * selection so their indexes can never get out of sync.
 */
internal fun randomizePartSelection(
    bodyPart: BodyPartModel,
    currentSelection: SelectionIndex,
    random: Random = Random.Default
): SelectionIndex {
    if (bodyPart.listPath.isEmpty()) return currentSelection

    val safeCurrentColor = currentSelection.colorIndex.coerceIn(
        0,
        bodyPart.listPath.lastIndex
    )
    val colorsWithCodes = bodyPart.listPath.indices.filter { colorIndex ->
        bodyPart.listPath[colorIndex].color.isNotBlank()
    }
    val colorCandidates = colorsWithCodes.ifEmpty { listOf(safeCurrentColor) }
    val colorsWithItems = colorCandidates.filter { colorIndex ->
        selectablePathIndices(bodyPart.listPath[colorIndex].listPath).isNotEmpty()
    }
    val randomColorIndex = (colorsWithItems.ifEmpty { colorCandidates }).random(random)
    val paths = bodyPart.listPath[randomColorIndex].listPath
    val pathCandidates = selectablePathIndices(paths)
    val fallbackPathIndex = if (paths.isEmpty()) {
        0
    } else {
        currentSelection.pathIndex.coerceIn(0, paths.lastIndex)
    }
    val randomPathIndex = pathCandidates.randomOrNull(random) ?: fallbackPathIndex

    return SelectionIndex(
        bodyPartIndex = currentSelection.bodyPartIndex,
        colorIndex = randomColorIndex,
        pathIndex = randomPathIndex
    )
}

private fun selectablePathIndices(paths: List<String>): List<Int> =
    paths.indices.filter { index ->
        val path = paths[index]
        !path.equals("none", ignoreCase = true) &&
            !path.equals("dice", ignoreCase = true)
    }
