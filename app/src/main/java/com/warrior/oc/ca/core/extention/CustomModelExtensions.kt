package com.warrior.oc.ca.core.extention

import com.warrior.oc.ca.data.model.custom.BodyPartModel
import com.warrior.oc.ca.data.model.custom.ColorModel
import com.warrior.oc.ca.data.model.custom.CustomModel
import com.google.gson.Gson

private val extensionGson = Gson()

fun CustomModel.withCleanListPath(): CustomModel {
    val cleanListPath = listPath.map { bp ->
        val bpJson = extensionGson.toJson(bp)
        val bodyPart = extensionGson.fromJson(bpJson, BodyPartModel::class.java)
        val charTypeFromPath = bodyPart.nav
            .substringBeforeLast('/')
            .substringAfterLast('/')
            .split('-')
            .getOrNull(2)
            ?.toIntOrNull()
            ?.takeIf { it == 1 || it == 2 }
        val resolvedCharType = charTypeFromPath
            ?: bodyPart.charType.takeIf { it == 1 || it == 2 }
            ?: 1
        val cleanColors = bodyPart.listPath.map { color ->
            val colorJson = extensionGson.toJson(color)
            extensionGson.fromJson(colorJson, ColorModel::class.java)
        }
        bodyPart.copy(
            listPath = ArrayList(cleanColors),
            charType = resolvedCharType
        )
    }
    return this.copy(listPath = ArrayList(cleanListPath))
}
