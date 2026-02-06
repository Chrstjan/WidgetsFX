@file:Suppress("unused")

package io.github.chrstjan.widgetsfx.layouts.extensions

import javafx.geometry.Insets
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
 * Extension function that adds specified padding amount to all sides of a Region
 *
 * @param top The padding amount for the top
 * @param right The padding amount for the right
 * @param bottom (Optional: defaults to top padding) the padding amount for the bottom
 * @param left (Optional: defaults to right padding) the padding amount for the left
 */
fun <T : Region> T.padWith(
    top: Double, right: Double = top, bottom: Double = top, left: Double = right
): T = apply {
    padding = Insets(top, right, bottom, left)
}

/**
 * Extension function that adds specified margin amount tied to the parent layout
 *
 * @param node The [Node] to apply the margin for
 * @param top The margin amount for the top
 * @param right The margin amount for the right
 * @param bottom (Optional: defaults to top margin) the margin amount for the bottom
 * @param left (Optional: defaults to right margin) the margin amount for the left
 */
fun HBox.margin(
    node: Node,
    top: Double,
    right: Double = top,
    bottom: Double = top,
    left: Double = right
): HBox = apply {
    HBox.setMargin(node, Insets(top, right, bottom, left))
}

/**
 * Extension function that adds specified margin amount tied to the parent layout
 *
 * @param node The [Node] to apply the margin for
 * @param top The margin amount for the top
 * @param right The margin amount for the right
 * @param bottom (Optional: defaults to top margin) the margin amount for the bottom
 * @param left (Optional: defaults to right margin) the margin amount for the left
 */
fun VBox.margin(
    node: Node,
    top: Double,
    right: Double = top,
    bottom: Double = top,
    left: Double = right
): VBox = apply {
    VBox.setMargin(node, Insets(top, right, bottom, left))
}