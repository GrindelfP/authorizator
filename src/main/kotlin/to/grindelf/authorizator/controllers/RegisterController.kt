package to.grindelf.authorizator.controllers

import javafx.fxml.FXML
import javafx.scene.control.Alert
import javafx.scene.control.PasswordField
import javafx.scene.control.TextField
import to.grindelf.authorizator.dataprocessor.Processor

class RegisterController {
    @FXML
    private lateinit var usernameField: TextField

    @FXML
    private lateinit var passwordField: PasswordField

    @FXML
    private lateinit var confirmPasswordField: PasswordField

    var registrationResult: String = ""

    fun handleRegister() {
        val login = usernameField.text
        val password = passwordField.text
        val confirmPassword = confirmPasswordField.text

        if (password == confirmPassword) {
            Processor.insertUser(login, password)
            registrationResult = "User registered successfully"
        } else {
            registrationResult = "Passwords do not match. Please try again."
        }

        val alert = Alert(Alert.AlertType.INFORMATION)
        alert.title = "Result"
        alert.headerText = null
        alert.contentText = registrationResult
        alert.showAndWait()
    }
}
