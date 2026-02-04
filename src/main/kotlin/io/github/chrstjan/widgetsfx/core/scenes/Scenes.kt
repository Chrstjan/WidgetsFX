@file:Suppress("unused")

package io.github.chrstjan.widgetsfx.core.scenes

import javafx.collections.ObservableList
import javafx.scene.Group
import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.layout.HBox
import javafx.scene.layout.Pane

typealias Scene = javafx.scene.Scene
typealias SubScene = javafx.scene.SubScene
typealias SceneAntialiasing = javafx.scene.SceneAntialiasing

/**
 * Factory method that creates a [javafx.scene.Scene] with the provided [initializer]
 *
 * @param initializer (Optional:) Lambda to configure the [javafx.scene.Scene]
 * @return [HBox]
 */
inline fun scene(
    root: Parent = Group(),
    width: Double = -1.0,
    height: Double = -1.0,
    depthBuffer: Boolean = false,
    antiAliasing: SceneAntialiasing = SceneAntialiasing.DISABLED,
    initializer: Scene.() -> Unit = {}
): Scene {
    return Scene(root, width, height, depthBuffer, antiAliasing).apply { initializer() }
}

val Scene.rootNode: Parent
    get() = root

fun Scene.setRoot(node: Parent): Scene = apply {
    root = node
}

val Scene.rootChildren: ObservableList<Node>
    get() = when (val r = root) {
        is Group -> r.children
        is Pane -> r.children
        else -> error("Scene root must be a Group or Pane to access children!")
    }

var Scene.rootChild: Node
    get() = rootChildren.first()
    set(value) {
        rootChildren.setAll(value)
    }

fun Scene.setRootChildren(nodes: Collection<Node>): Scene = apply {
    rootChildren.setAll(nodes)
}

operator fun Scene.plusAssign(node: Node) {
    rootChildren += node
}

operator fun Scene.invoke(vararg nodes: Node) {
    rootChildren.setAll(nodes.toList())
}