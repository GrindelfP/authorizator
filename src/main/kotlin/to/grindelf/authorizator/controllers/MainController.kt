package to.grindelf.authorizator.controllers

import javafx.fxml.FXML
import javafx.scene.control.*
import javafx.stage.Stage
import to.grindelf.authorizator.dataprocessor.DataBaseOperator
import java.util.*

class MainController {
    @FXML
    private lateinit var welcomeText: Label

    @FXML
    private fun onHelloButtonClick() {
        welcomeText.text = "Welcome to JavaFX Application!"
    }
}