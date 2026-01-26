@file:Suppress("unused")

package io.github.chrstjan.widgetsfx.layouts.extensions

import javafx.scene.Node
import javafx.scene.Scene

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