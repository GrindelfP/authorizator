package to.grindelf.authorizator.controllers

import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Alert
import javafx.scene.control.PasswordField
import javafx.scene.control.TextField
import javafx.stage.Stage
import to.grindelf.authorizator.dataprocessor.Processor

class MainController {
    @FXML
    private lateinit var usernameField: TextField

    @FXML
    private lateinit var passwordField: PasswordField

    fun handleLogin() {
        val login = usernameField.text
        val password = passwordField.text

        val result = Processor.authorizeUser(login, password)
        showAlert(result)
    }

    fun handleRegister() {
        val loader = FXMLLoader(javaClass.getResource("register.fxml"))
        val root: Parent = loader.load()
        val controller = loader.getController<RegisterController>()

        val stage = Stage()
        stage.title = "Registration"
        stage.scene = Scene(root, 400.0, 300.0)
        stage.showAndWait()

        val result = controller.registrationResult
        showAlert(result)
    }

    private fun showAlert(message: String) {
        val alert = Alert(Alert.AlertType.INFORMATION)
        alert.title = "Result"
        alert.headerText = null
        alert.contentText = message
        alert.showAndWait()
    }
}
