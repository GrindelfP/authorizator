package to.grindelf.authorizator.controllers

import javafx.fxml.FXML
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
            showAlert("Incorrect input!", alertType = AlertType.WARNING)
        } else {
            Processor.insertUser(login, password)
            showAlert("Successful signing in!")
            val stage = passwordField.scene.window as Stage
            stage.close()
        }
    }
}
