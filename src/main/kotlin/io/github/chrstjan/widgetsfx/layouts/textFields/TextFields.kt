@file: Suppress("unused")

package io.github.chrstjan.widgetsfx.layouts.textFields

import javafx.beans.binding.Bindings
import javafx.beans.property.Property
import javafx.beans.property.StringProperty
import javafx.scene.control.TextField
import javafx.scene.control.TextFormatter
import javafx.scene.layout.Region
import javafx.util.converter.NumberStringConverter

/**
 * Factory method that creates a [TextField] bound to a StringProperty
 *
 * @param boundValue The String property to bind to the text property
 */
fun textFieldOf(boundValue: StringProperty) = TextField().apply { textProperty().bindBidirectional(boundValue) }

/**
 * Factory method that creates a [TextField] bound bidirectionally to an external [StringProperty]
 *
 * @param contents [StringProperty] bound to the [TextField]
 */
fun stringField(contents: StringProperty) = TextField().apply {
    textProperty().bindBidirectional(contents)
    styleClass += "data-text"
}

/**
 * Infix function that binds a TextField's textProperty to an external StringProperty bidirectionally
 *
 * @param value The external StringProperty to bind to
 */
infix fun TextField.bindTo(value: StringProperty) = apply { textProperty().bindBidirectional(value) }

/**
 * Factory method that creates a [TextField] bound bidirectionally to an external [StringProperty]
 * With a specified maximum width
 *
 * @param contents [StringProperty] to bind to the [TextField]
 * @param maxWidth (Optional): The maximum allowed width of the [TextField]
 */
fun decimalField(contents: Property<Number>, maxWidth: Double = Region.USE_COMPUTED_SIZE) =
    decimalField(contents).apply {
        this.maxWidth = maxWidth
    }

/**
 * Factory method that creates a [TextField] bound bidirectionally to an external [Property<Number>]
 * Using [NumberStringConverter] to convert between the [TextField] contents and the external bound [Property]
 *
 * @param contents [Property<Number>] to bind to the [TextField]
 */
fun decimalField(contents: Property<Number>) = TextField().apply {
    Bindings.bindBidirectional(textProperty(), contents, NumberStringConverter())
    styleClass += "data-text"
}

/**
 * Factory method that creates a customized configured [TextField] for fixed spaced decimal digits entries.
 * See [FixedDecimalFilter]
 *
 * @param boundProperty [Property<Double>] to bidirectionally bind to the [TextField]
 * @param decimalPlaces The amount of decimal digits for the user input
 * @param maxWidth (Optional:) The maximum width of the [TextField]
 */
fun decimalField(boundProperty: Property<Double>, decimalPlaces: Int, maxWidth: Double = Region.USE_COMPUTED_SIZE) =
    TextField().apply {
        this.maxWidth = maxWidth

        val textFormatter = TextFormatter(
            FixedDecimalConverter(decimalPlaces),
            boundProperty.value,
            FixedDecimalFilter(decimalPlaces)
        )
        this.textFormatter = textFormatter
        boundProperty.bindBidirectional(textFormatter.valueProperty())
    }

/**
 * Factory method that creates a [TextField] bound bidirectionally to an external [javafx.beans.property.IntegerProperty]
 *
 * @param boundProperty [Property<Int>] to bidirectionally bind to the [TextField]
 * @param maxWidth (Optional:) The maximum width of the [TextField]
 */
fun integerField(boundProperty: Property<Int>, maxWidth: Double = Region.USE_COMPUTED_SIZE) =
    TextField().apply {
        this.maxWidth = maxWidth

        val textFormatter = TextFormatter(
            ZeroIntegerStringConverter(),
            boundProperty.value,
            IntegerFilter()
        )
        this.textFormatter = textFormatter
        boundProperty.bindBidirectional(textFormatter.valueProperty())
    }