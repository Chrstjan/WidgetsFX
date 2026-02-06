@file:Suppress("unused")

package io.github.chrstjan.widgetsfx.layouts

import io.github.chrstjan.widgetsfx.core.scenes.add
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.layout.Pane
import javafx.scene.layout.StackPane
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox

inline fun stackPane(vararg children: Node, initializer: StackPane.() -> Unit = {}): StackPane {
    return StackPane(*children).apply(initializer)
}

@JvmName("stackPaneOfArray")
inline fun stackPane(children: Array<out Node>, initializer: StackPane.() -> Unit = {}): StackPane {
    return StackPane(*children).apply(initializer)
}

inline fun stackPane(children: Collection<Node>, initializer: StackPane.() -> Unit = {}): StackPane {
    return StackPane().apply { this.children.addAll(children) }.apply(initializer)
}

/**
 * Operator that adds a Node as a child to a [Pane] or [Pane] subclass
 *
 * @receiver The [Pane] which the [Node] is added to
 * @param node The [Node] to add to the [Pane]
 */
operator fun Pane.plusAssign(node: Node) {
    children += node
}

/**
 * Infix extension function that adds this Node to the specified Pane & returns the Node
 *
 * @receiver [Node] The [Node] to add to the [Pane]
 * @param  pane The target container
 * @return The [Node] instance
 */
infix fun <T: Node> T.addToPane(pane: Pane): T = also { pane.children += it }

/**
 * Factory method that creates a [HBox] with the provided [initializer]
 *
 * @param initializer (Optional:) Lambda to configure the [HBox]
 * @return [HBox]
 */
inline fun hBox(initializer: HBox.() -> Unit = {}): HBox {
    return HBox().apply(initializer)
}

/**
 * Factory method that creates a [HBox] with the provided [initializer]
 *
 * @param initializer (Optional:) Lambda to configure the [HBox]
 * @return [HBox]
 */
inline fun hBox(spacing: Double, initializer: HBox.() -> Unit = {}): HBox {
    return HBox(spacing).apply { initializer() }
}

inline fun hBox(vararg children: Node, initializer: HBox.() -> Unit = {}): HBox {
    return HBox(*children).apply { initializer() }
}

inline fun hBox(spacing: Double, vararg children: Node, initializer: HBox.() -> Unit = {}): HBox {
    return HBox(spacing, *children).apply { initializer() }
}

@JvmName("hBoxOfArray")
inline fun hBox(children: Array<out Node>, initializer: HBox.() -> Unit = {}): HBox {
    return HBox(*children).apply { initializer() }
}

@JvmName("hBoxOfArray")
inline fun hBox(spacing: Double, children: Array<out Node>, initializer: HBox.() -> Unit = {}): HBox {
    return HBox(spacing, *children).apply { initializer() }
}

inline fun hBox(children: Collection<Node>, initializer: HBox.() -> Unit = {}) : HBox {
    return HBox().apply { this.children.addAll(children) }.apply(initializer)
}

inline fun hBox(spacing: Double, children: Collection<Node>, initializer: HBox.() -> Unit = {}): HBox {
    return HBox(spacing).apply { this.children.addAll(children) }.apply(initializer)
}

/**
 * Infix extension function to specify the alignment of an HBox
 *
 * @receiver HBox
 * @param pos The Pos alignment to apply
 */
infix fun HBox.alignTo(pos: Pos): HBox = apply { alignment = pos }

/**
 * Operator that adds a Node as a child to a [HBox]
 *
 * @receiver The [HBox] which the Node is added to
 * @param node The [Node] to add to the [HBox]
 */
operator fun HBox.plusAssign(node: Node) {
    children += node
}

/**
 * Factory method that creates a [VBox] with the provided [initializer]
 *
 * @param initializer (Optional:) Lambda to configure the [VBox]
 * @return [VBox]
 */
inline fun vBox(initializer: VBox.() -> Unit = {}) : VBox {
    return VBox().apply(initializer)
}

inline fun vBox(spacing: Double, initializer: VBox.() -> Unit = {}) : VBox {
    return VBox(spacing).apply { initializer() }
}

inline fun Parent.vBox(spacing: Double, initializer: VBox.() -> Unit = {}) : VBox {
    val box = VBox(spacing)
    add(box)
    box.initializer()
    return box
}

inline fun vBox(vararg children: Node, initializer: VBox.() -> Unit = {}) : VBox {
    return VBox(*children).apply { initializer() }
}

inline fun vBox(spacing: Double, vararg children: Node, initializer: VBox.() -> Unit = {}) : VBox {
    return VBox(spacing, *children).apply { initializer() }
}

@JvmName("vBoxOfArray")
inline fun vBox(children: Array<out Node>, initializer: VBox.() -> Unit = {}) : VBox {
    return VBox(*children).apply { initializer() }
}

@JvmName("vBoxOfArray")
inline fun vBox(spacing: Double, children: Array<out Node>, initializer: VBox.() -> Unit) : VBox {
    return VBox(spacing, *children).apply { initializer() }
}

inline fun vBox(children: Collection<Node>, initializer: VBox.() -> Unit = {}) : VBox {
    return VBox().apply { this.children.addAll(children) }.apply(initializer)
}

inline fun vBox(spacing: Double, children: Collection<Node>, initializer: VBox.() -> Unit = {}) : VBox {
    return VBox(spacing).apply { this.children.addAll(children) }.apply(initializer)
}


/**
 * Infix extension function to specify the alignment of an VBox
 *
 * @receiver VBox
 * @param pos The Pos alignment to apply
 */
infix fun VBox.alignTo(pos: Pos): VBox = apply { alignment = pos }

/**
 * Operator that adds a Node as a child to a [VBox]
 *
 * @receiver The [VBox] which the Node is added to
 * @param node The [Node] to add to the [VBox]
 */
operator fun VBox.plusAssign(node: Node) {
    children += node
}