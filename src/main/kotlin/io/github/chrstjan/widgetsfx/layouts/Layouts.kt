@file:Suppress("unused")

package io.github.chrstjan.widgetsfx.layouts

import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.layout.HBox
import javafx.scene.layout.Pane
import javafx.scene.layout.VBox

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

/**
 * Operator that adds a Node as a child to a Pane or Pane subclass
 *
 * @receiver The Pane which the Node is added to
 * @param newChild The Node to add to the Pane
 */
operator fun Pane.plusAssign(newChild: Node) {
    children += newChild
}

/**
 * Infix extension function that adds this Node to the specified Pane & returns the Node
 *
 * @receiver Node The Node to add to the pane
 * @param  pane The target container
 * @return The Node instance
 */
infix fun <T: Node> T.addToPane(pane: Pane): T = also { pane.children += it }