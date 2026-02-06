package io.github.chrstjan.widgetsfx

import io.github.chrstjan.widgetsfx.core.scenes.plusAssign
import io.github.chrstjan.widgetsfx.core.scenes.scene
import io.github.chrstjan.widgetsfx.layouts.extensions.isHidden
import io.github.chrstjan.widgetsfx.layouts.extensions.padWith
import io.github.chrstjan.widgetsfx.layouts.hBox
import io.github.chrstjan.widgetsfx.layouts.labels.dataOf
import io.github.chrstjan.widgetsfx.layouts.labels.h1Of
import io.github.chrstjan.widgetsfx.layouts.labels.h2Of
import io.github.chrstjan.widgetsfx.layouts.labels.h3Of
import io.github.chrstjan.widgetsfx.layouts.plusAssign
import io.github.chrstjan.widgetsfx.layouts.stackPane
import io.github.chrstjan.widgetsfx.layouts.vBox
import javafx.application.Application
import javafx.stage.Stage

class Main : Application() {
    override fun start(stage: Stage) {

        val testScene = scene {
            this += stackPane {
                this += hBox {
                    this += h1Of("Widgets FX testing")
                    this += dataOf("Hello there")
                }.padWith(20.0, 10.0, 0.0, 200.0)

                this += h2Of("Hidden text testing").isHidden(true)

                this += vBox {
                    this += h3Of("VBox Container")
                    this += dataOf("Data Label in VBOX Container")
                }
            }
        }

        stage.title = "Hello!"
        stage.scene = testScene
        stage.show()
    }
}
  
