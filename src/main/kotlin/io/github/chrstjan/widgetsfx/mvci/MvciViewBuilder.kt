@file:Suppress("unused")

package io.github.chrstjan.widgetsfx.mvci

import javafx.scene.layout.Region
import javafx.util.Builder

abstract class MvciViewBuilder<ViewModelClass>(protected var viewModel: ViewModelClass) : Builder<Region>