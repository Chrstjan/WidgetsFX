@file:Suppress("unused")

package io.github.chrstjan.widgetsfx.layouts.extensions

import javafx.beans.value.ObservableBooleanValue
import javafx.scene.Node

/**
 * Infix extension function to apply Node visibility
 *
 * Sets the {@link Node#isVisible} property (does not affect layout participation)
 *
 * @receiver Node
 * @param visibility true for visible, false for invisible
 */
infix fun <T: Node> T.visibilityOf(visibility: Boolean): T = apply { isVisible = visibility }

/**
 * Infix extension function to apply Node hidden state
 *
 * When hidden, The Node is invisible & unmanaged (does not participate in layout.)
 *
 * @receiver Node
 * @param isHidden true for hidden & removed from layout, false for shown & part of the layout
 */
infix fun <T: Node> T.isHidden(isHidden: Boolean): T = apply {
    isVisible = !isHidden
    isManaged = !isHidden
}

/**
 * Infix extension function to bind Node visibility and layout participation.
 *
 * Binds both {@link Node#visibleProperty} and {@link Node#managedProperty}
 * to the given observable value.
 *
 * @receiver Node
 * @param visibleProperty observable boolean controlling visibility and managed state
 */
infix fun <T: Node> T.bindHidden(visibleProperty: ObservableBooleanValue): T = apply {
    this.visibleProperty().bind(visibleProperty)
    this.managedProperty().bind(visibleProperty)
}