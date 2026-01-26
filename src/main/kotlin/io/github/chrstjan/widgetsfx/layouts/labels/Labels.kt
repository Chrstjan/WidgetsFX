package io.github.chrstjan.widgetsfx.layouts.labels

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