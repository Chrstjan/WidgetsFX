@file:Suppress("unused")

package io.github.chrstjan.widgetsfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.Scene
import javafx.scene.layout.HBox
import javafx.scene.layout.Region
import javafx.scene.layout.VBox

enum class TestStyle(val selector: String) {
    RED("test-red"),
    GREEN("test-green"),
    BLUE("test-blue")
}

/**
 * Extension function to add one of the standard testing styles to a Node.
 *
 * @param nodeStyle The testing style to be applied to the Node
 */
infix fun <T : Node> T.testStyleAs(nodeStyle: TestStyle) = apply { styleClass += nodeStyle.selector }

/**
 * Extension function to add a stylesheet to a Scene
 *
 * @receiver Scene
 * @param sheetName The filename of the stylesheet to add
 */
fun Scene.addStyleSheet(sheetName: String) = apply {
    object {}::class.java.getResource(sheetName)?.toString()?.let { stylesheets += it }
}

/**
 * Infix extension function to add a style class selector to a Node.
 *
 * @param newStyleClass The selector to apply to the Node
 */
infix fun <T: Node> T.addStyle(newStyleClass: String): T = apply { styleClass += newStyleClass }

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

/**
 * Infix extension function to specify the alignment of an HBox
 *
 * @receiver HBox
 * @param pos The Pos alignment to apply
 */
infix fun HBox.alignTo(pos: Pos): HBox = apply { alignment = pos }

/**
 * Infix extension function to specify the alignment of an VBox
 *
 * @receiver VBox
 * @param pos The Pos alignment to apply
 */
infix fun VBox.alignTo(pos: Pos): VBox = apply { alignment = pos }