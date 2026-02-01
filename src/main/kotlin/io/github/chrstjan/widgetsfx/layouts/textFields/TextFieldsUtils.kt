@file:Suppress("unused")

package io.github.chrstjan.widgetsfx.layouts.textFields

import javafx.scene.control.TextFormatter
import javafx.util.converter.DoubleStringConverter
import javafx.util.converter.IntegerStringConverter
import java.util.function.UnaryOperator

/**
 * Custom Integer-String converter that helps convert empty [String] values into 0 instead of Null
 *
 * @return An [Integer] from the converted string value
 */
class ZeroIntegerStringConverter : IntegerStringConverter() {
    override fun fromString(value: String): Int {
        if (value.isEmpty())
            return 0
        return super.fromString(value)
    }
}

/**
 * Custom Double-String converter that helps convert empty [String] values into 0.0 instead of Null.
 *
 * Also formats output strings into a fixed number of decimal places.
 *
 * @param decimalPlaces The number of decimal places to be used in the formatted output
 */
class FixedDecimalConverter(private val decimalPlaces: Int) : DoubleStringConverter() {

    override fun toString(value: Double): String {
        return String.format("%." + decimalPlaces + "f", value)
    }

    override fun fromString(value: String): Double {
        if (value.isEmpty())
            return 0.0
        return super.fromString(value)
    }
}

/**
 * [javafx.scene.control.TextField] Filter util that supports fixed place decimal inputs.
 *
 * @param decimalPlaces The number of decimal places to be used in the data entry
 */
class FixedDecimalFilter(private val decimalPlaces: Int): UnaryOperator<TextFormatter.Change?> {
    override fun apply (valueChange: TextFormatter.Change?): TextFormatter.Change? {
        valueChange ?: return null // rejects if object is null
        val text = valueChange.controlText
        val decimalPos = text.indexOf(".").let { if (it == -1) text.length else it }
        val caretPos = valueChange.controlCaretPosition

        handleToggleKeys(valueChange, decimalPos, caretPos)?.let { return it }

        if (valueChange.isContentChange && caretPos > decimalPos)
            adjustDecimalLength(valueChange, decimalPos)

        return if (valueChange.controlNewText.matches("-?([0-9]*)?(\\.[0-9]*)?".toRegex())) valueChange else null
    }

    private fun handleToggleKeys(change: TextFormatter.Change, decimalPos: Int, caretPos: Int): TextFormatter.Change? {
        return when (change.text) {
            "." -> {
                change.text = ""
                change.setRange(0, 0)

                if (caretPos <= decimalPos) {
                    change.caretPosition = decimalPos + 1
                    change.anchor = change.controlText.length
                }
                else {
                    change.caretPosition = decimalPos
                    change.anchor = 0
                }
                change
            }

            "-" -> {
                if (change.controlText.startsWith("-")) {
                    change.text = ""
                    change.setRange(0, 1)
                    change.caretPosition -= 2
                    change.anchor -= 2
                }
                else
                    change.setRange(0, 0)

                change
            }

            else -> null
        }
    }

    private fun adjustDecimalLength(change: TextFormatter.Change, decimalPos: Int) {
        val newText = change.controlNewText
        val decimalLength = newText.length - decimalPos - 1

        when {
            decimalLength < decimalPlaces -> change.text += "0"

            decimalLength > decimalPlaces -> {
                change.setRange(decimalPos + 1, decimalPos + 1 + decimalPlaces)
            }
        }
    }
}

/**
 * [javafx.scene.control.TextField] Filter util that only allows valid integer numbers input
 */
class IntegerFilter : UnaryOperator<TextFormatter.Change?> {
    override fun apply (valueChange: TextFormatter.Change?): TextFormatter.Change? {
        valueChange ?: return null // rejects if object is null
        val newText = valueChange.controlNewText

        // text input minus sign toggle on user input
        if (newText == "-") {

            // Removes "-" from the beginning of the text if it already exist
            if (valueChange.controlText.startsWith("-")) {
                valueChange.text = ""
                // removes the first character ( the "-")
                valueChange.setRange(0, 1)

                valueChange.caretPosition -= 2
                valueChange.anchor -= 2
                return valueChange
            }
            // Adds "-" to the beginning if a "-" doesn't already exist
            else {
                // inserts a "-" at the beginning of the text
                valueChange.setRange(0, 0)
                return valueChange
            }
        }

        return if (newText.matches("-?([1-9][0-9]*)?".toRegex()) || newText == "0") valueChange else null
    }
}