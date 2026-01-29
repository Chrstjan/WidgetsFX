@file:Suppress("unused")

package io.github.chrstjan.widgetsfx.layouts.labels

import io.github.chrstjan.widgetsfx.layouts.extensions.addStyle
import io.github.chrstjan.widgetsfx.layouts.plusAssign
import javafx.beans.property.StringProperty
import javafx.beans.value.ObservableObjectValue
import javafx.beans.value.ObservableStringValue
import javafx.scene.Node
import javafx.scene.control.ContentDisplay
import javafx.scene.control.Label
import javafx.scene.control.Labeled

/**
 * General purpose defined label styles
 */
enum class LabelStyle(val selector: String) {
    H1("label-heading-one"),
    H2("label-heading-two"),
    H3("label-heading-three"),
    H4("label-heading-four"),
    H5("label-heading-five"),
    H6("label-heading-six"),
    PROMPT("label-prompt"),
    DATA("label-data")
}

/**
 * Decorator function used to apply a defined [LabelStyle] to a Label
 *
 * @receiver [Labeled]
 * @param labelStyle [LabelStyle] to apply to the Label
 * @return [Labeled]
 */
infix fun <T: Labeled> T.styleAs(labelStyle: LabelStyle): T = apply { styleClass += labelStyle.selector }

/**
 * Decorator function that binds a Labeled's textProperty to an external Property
 *
 * @param value The external ObservableStringValue to bind to the Label's Text Property
 */
infix fun <T: Labeled> T.bindTo(value: ObservableStringValue): T = apply { textProperty().bind(value) }
fun <T: Labeled> T.wrapText(): T = apply { isWrapText = true }
infix fun <T: Labeled> T.underlined(setUnderlineOn: Boolean): T = apply { isUnderline = setUnderlineOn }
infix fun <T: Labeled> T.oriented(orientation: ContentDisplay): T = apply { contentDisplay = orientation }

/**
 * Decorator function that binds a Labeled's graphicsProperty to the specified Property
 *
 * @param graphicProperty ObservableObjectValue<Node> To bind to the graphicProperty
 */
infix fun <T: Labeled> T.bindGraphics(graphicProperty: ObservableObjectValue<Node>): T = apply { graphicProperty().bind(graphicProperty()) }

/**
 * Factory method that creates a [LabelStyle.PROMPT] Label with a textProperty bound to an external Property
 *
 * @param value The external Property to bind to the Text property
 */
fun promptOf(value: ObservableStringValue) = Label() styleAs LabelStyle.PROMPT bindTo value

/**
 * Factory method that creates a [LabelStyle.PROMPT] Label with a provided static Text value
 *
 * @param String The Text Value for the Label
 */
fun promptOf(value: String) = Label(value) styleAs LabelStyle.PROMPT

/**
 * Factory method that creates a Label with a bound textProperty to an external property
 *
 * @param value The external ObservableStringValue to bind to the Label's Text Property
 */
fun labelOf(value: ObservableStringValue) = Label() bindTo value

/**
 * Factory method that creates a Label with a bound textProperty to an external property,
 * Along with a styleClass selector and with an optional set Graphic value
 *
 * @param value The external ObservableStringValue to bind to the Label's Text Property
 * @param styleClass String to use as style class selector
 * @param graphicNode Optional: Node used as the Label's Graphic property
 */
fun labelOf(value: ObservableStringValue, styleClass: String, graphicNode: Node? = null) = Label().apply {
    graphicNode?.let { graphic = it }
} bindTo value addStyle styleClass

/**
 * Factory method that creates a Label with a bound textProperty to an external property,
 * Along with a styleClass selector and the Graphic property bound to an ObservableObjectValue<Node>
 *
 * @param value The external ObservableStringValue to bind to the Label's Text Property
 * @param styleClass String to use as style class selector
 * @param graphicProperty ObservableObjectValue<Node> To bind to the graphicProperty
 */
fun labelOf(value: ObservableStringValue, styleClass: String, graphicProperty: ObservableObjectValue<Node>) =
    Label() bindTo value bindGraphics graphicProperty addStyle styleClass

/**
 * Factory function that creates a [Label] styled with the provided [LabelStyle] and static text
 *
 * @param value The static text for the Label
 * @param style The style to apply for the Label,
 * [LabelStyle.H1] styled as default
 *
 * @return [Label]
 */
fun hOf(value: String, style: LabelStyle = LabelStyle.H1, graphic: Node? = null) = Label(value, graphic) styleAs style

/**
 * Factory function that creates a [Label] styled with the provided [LabelStyle] and with a bound text property
 *
 * @param value The Label's bound external ObservableStringProperty
 * @param style The style to apply for the Label,
 * [LabelStyle.H1] styled as default
 */
fun hOf(value: ObservableStringValue, style: LabelStyle = LabelStyle.H1, graphic: Node? = null) =
    Label("", graphic) styleAs style bindTo value

/**
 * Factory method that creates a [LabelStyle.H1] styled [Label] with static text
 *
 * @param value The static text for the Label
 * @return [Label]
 */
fun h1Of(value: String, graphic: Node? = null) = hOf(value, LabelStyle.H1, graphic)

/**
 * Factory method that creates a [LabelStyle.H1] styled [Label] with a bound text property
 *
 * @param value The Label's bound external ObservableStringProperty
 * @return [Label]
 */
fun h1Of(value: ObservableStringValue, graphic: Node? = null) = hOf(value, LabelStyle.H1, graphic)

/**
 * Factory method that creates a [LabelStyle.H2] styled [Label] with static text
 *
 * @param value The static text for the Label
 * @return [Label]
 */
fun h2Of(value: String, graphic: Node? = null) = hOf(value, LabelStyle.H2, graphic)

/**
 * Factory method that creates a [LabelStyle.H2] styled [Label] with a bound text property
 *
 * @param value The Label's bound external ObservableStringProperty
 * @return [Label]
 */
fun h2Of(value: ObservableStringValue, graphic: Node? = null) = hOf(value, LabelStyle.H2, graphic)

/**
 * Factory method that creates a [LabelStyle.H3] styled [Label] with static text
 *
 * @param value The static text for the Label
 * @return [Label]
 */
fun h3Of(value: String, graphic: Node? = null) = hOf(value, LabelStyle.H3, graphic)

/**
 * Factory method that creates a [LabelStyle.H3] styled [Label] with a bound text property
 *
 * @param value The Label's bound external ObservableStringProperty
 * @return [Label]
 */
fun h3Of(value: ObservableStringValue, graphic: Node? = null) = hOf(value, LabelStyle.H3, graphic)

/**
 * Factory method that creates a [LabelStyle.H4] styled [Label] with static text
 *
 * @param value The static text for the Label
 * @return [Label]
 */
fun h4Of(value: String, graphic: Node? = null) = hOf(value, LabelStyle.H4, graphic)

/**
 * Factory method that creates a [LabelStyle.H4] styled [Label] with a bound text property
 *
 * @param value The Label's bound external ObservableStringProperty
 * @return [Label]
 */
fun h4Of(value: ObservableStringValue, graphic: Node? = null) = hOf(value, LabelStyle.H4, graphic)

/**
 * Factory method that creates a [LabelStyle.H5] styled [Label] with static text
 *
 * @param value The static text for the Label
 * @return [Label]
 */
fun h5Of(value: String, graphic: Node? = null) = hOf(value, LabelStyle.H5, graphic)

/**
 * Factory method that creates a [LabelStyle.H5] styled [Label] with a bound text property
 *
 * @param value The Label's bound external ObservableStringProperty
 * @return [Label]
 */
fun h5Of(value: ObservableStringValue, graphic: Node? = null) = hOf(value, LabelStyle.H5, graphic)

/**
 * Factory method that creates a [LabelStyle.H6] styled [Label] with static text
 *
 * @param value The static text for the Label
 * @return [Label]
 */
fun h6Of(value: String, graphic: Node? = null) = hOf(value, LabelStyle.H6, graphic)

/**
 * Factory method that creates a [LabelStyle.H6] styled [Label] with a bound text property
 *
 * @param value The Label's bound external ObservableStringProperty
 * @return [Label]
 */
fun h6Of(value: ObservableStringValue, graphic: Node? = null) = hOf(value, LabelStyle.H6, graphic)

/**
 * Factory method that creates a [LabelStyle.DATA] Label with static text
 *
 * @param value The static text for the Label
 * @return [Label]
 */
fun dataOf(value: String) = Label(value) styleAs LabelStyle.DATA

/**
 * Factory method that creates a [LabelStyle.DATA] Label with a textProperty bound to an external Property
 *
 * @param value The external Property to bind to the Text property
 * @return [Label]
 */
fun dataOf(value: ObservableStringValue) = Label() styleAs LabelStyle.DATA bindTo value

/**
 * += Operator definition that binds another StringProperty to the Label's Text property
 */
operator fun Labeled.plusAssign(otherProperty: StringProperty) = run { textProperty() += otherProperty }