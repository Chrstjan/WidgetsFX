package io.github.chrstjan.widgetsfx.layouts

import javafx.beans.property.BooleanPropertyBase
import javafx.beans.property.StringProperty
import javafx.beans.value.ObservableValue
import javafx.css.PseudoClass
import javafx.scene.Node

/**
 * Operator function used to define += as a bind()
 */
operator fun StringProperty.plusAssign(otherProperty: ObservableValue<String>) = this.bind(otherProperty)

class PseudoClassProperty(private val node: Node, private val pseudoClass: PseudoClass) : BooleanPropertyBase() {
    override fun getBean() = node
    override fun getName(): String = pseudoClass.pseudoClassName

    override fun invalidated() {
        node.pseudoClassStateChanged(pseudoClass, value)
    }
}

infix fun Node.addPseudoClass(pseudoClass: PseudoClass) = PseudoClassProperty(this, pseudoClass)