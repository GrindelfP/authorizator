package to.grindelf.authorizator.controllers

import javafx.fxml.FXML
import javafx.scene.Scene
import javafx.scene.control.PasswordField
import javafx.scene.control.TextField
import javafx.scene.control.Alert
import javafx.scene.control.Alert.AlertType
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.stage.Stage
import to.grindelf.authorizator.dataprocessor.Processor

class MainController {
    @FXML lateinit var loginField: TextField
    @FXML lateinit var passwordField: PasswordField

    @FXML
    fun loginButtonClicked() {
        val login = loginField.text
        val password = passwordField.text
        if (login.isEmpty() || password.isEmpty()) {
            showAlert("Введите логин и пароль!")
        } else {
            val result = Processor.authorizeUser(login, password)
            if (result == "User authorized successfully") {
                showAlert("Успешный вход!")
            } else {
                showAlert("Неверные логин или пароль!")
            }
        }
    }

    @FXML
    fun registerButtonClicked() {
        val registerLoader = FXMLLoader(javaClass.getResource("/to/grindelf/authorizator/register.fxml"))
        val registerParent = registerLoader.load<Parent>()
        val registerScene = Scene(registerParent)
        val registerStage = Stage()
        registerStage.scene = registerScene
        registerStage.show()
    }

    private fun showAlert(message: String) {
        val alert = Alert(AlertType.INFORMATION)
        alert.title = "Information"
        alert.headerText = null
        alert.contentText = message
        alert.showAndWait()
    }
}
