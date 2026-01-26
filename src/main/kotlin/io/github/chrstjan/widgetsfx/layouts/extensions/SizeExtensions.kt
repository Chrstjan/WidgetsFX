@file:Suppress("unused")

package io.github.chrstjan.widgetsfx.layouts.extensions

import javafx.geometry.Insets
import javafx.scene.layout.Region

/**
 * Infix extension function that adds equally padding amount to all sides of a Region
 *
 * @param padSize The amount of padding to apply to all sides
 */
infix fun <T : Region> T.padWith(padSize: Double): T = apply { padding = Insets(padSize) }

/**
 * Infix extension function to specify the min width of a Region
 *
 * @param size The minimum width size amount
 */
infix fun <T: Region> T.minWidthOf(size: Double): T = apply { minWidth = size }

/**
 * Infix extension function to specify the max width of a Region
 *
 * @param size The max width size amount
 */
infix fun <T: Region> T.maxWidthOf(size: Double): T = apply { maxWidth = size }

/**
 * Infix extension function to specify the min height of a Region
 *
 * @param size The minimum height size amount
 */
infix fun <T: Region> T.minHeightOf(size: Double): T = apply { minHeight = size }

/**
 * Infix extension function to specify the max height of a Region
 *
 * @param size The max height size amount
 */
infix fun <T: Region> T.maxHeightOf(size: Double): T = apply { maxHeight = size }
