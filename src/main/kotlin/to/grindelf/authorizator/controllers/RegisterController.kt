package to.grindelf.authorizator.controllers

import javafx.fxml.FXML
import javafx.scene.control.Alert
import javafx.scene.control.Alert.AlertType
import javafx.scene.control.PasswordField
import javafx.scene.control.TextField
import javafx.stage.Stage
import to.grindelf.authorizator.dataprocessor.Processor

class RegisterController {
    @FXML
    lateinit var loginField: TextField
    @FXML
    lateinit var passwordField: PasswordField
    @FXML
    lateinit var passwordConfirmField: PasswordField

    @FXML
    fun registerButtonClicked() {
        val login = loginField.text
        val password = passwordField.text
        val passwordConfirm = passwordConfirmField.text
        if (login.isEmpty() || password.isEmpty() || passwordConfirm.isEmpty() || password != passwordConfirm) {
            showAlert("Неверное заполнение полей для регистрации!")
        } else {
            Processor.insertUser(login, password)
            showAlert("Успешная регистрация!")
            val stage = passwordField.scene.window as Stage
            stage.close()
        }
    }

    private fun showAlert(message: String) {
        val alert = Alert(AlertType.INFORMATION)
        alert.title = "Information"
        alert.headerText = null
        alert.contentText = message
        alert.showAndWait()
    }
}
