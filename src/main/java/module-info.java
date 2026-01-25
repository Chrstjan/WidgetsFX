module io.github.chrstjan.widgetsfx {
    requires javafx.controls;
    requires kotlin.stdlib;


    opens io.github.chrstjan.widgetsfx to javafx.fxml;
    exports io.github.chrstjan.widgetsfx;
}