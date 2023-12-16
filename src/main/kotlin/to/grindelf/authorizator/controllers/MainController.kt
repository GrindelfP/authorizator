package to.grindelf.authorizator.controllers

import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Alert
import javafx.scene.control.Alert.AlertType
import javafx.scene.control.PasswordField
import javafx.scene.control.TextField
import javafx.stage.Stage
import to.grindelf.authorizator.DiaryApplication
import to.grindelf.authorizator.dataprocessor.Processor

class MainController {
    @FXML
    lateinit var loginField: TextField
    @FXML
    lateinit var passwordField: PasswordField

    @FXML
    fun loginButtonClicked() {
        val login = loginField.text
        val password = passwordField.text
        if (login.isEmpty() || password.isEmpty()) {
            showAlert(message = "Enter your login and password!", alertType = AlertType.WARNING)
        } else {
            val result = Processor.authorizeUser(login, password)
            if (result == "User authorized successfully") {
                showAlert("Successful signing in!")
            } else {
                showAlert( message = "Incorrect login or password!", alertType = AlertType.WARNING)
            }
        }
    }

    @FXML
    fun registerButtonClicked() {
        val registerLoader = FXMLLoader(javaClass.getResource("/to/grindelf/authorizator/register.fxml"))
        val registerParent = registerLoader.load<Parent>()
        val registerScene = Scene(registerParent)
        val registerStage = Stage()
        registerStage.height = DiaryApplication.WINDOW_HEIGHT
        registerStage.width = DiaryApplication.WINDOW_HEIGHT
        registerStage.scene = registerScene
        registerStage.show()
    }
}

fun showAlert(message: String, alertType: AlertType = AlertType.INFORMATION) {
    val alert = Alert(alertType)
    alert.headerText = null
    alert.contentText = message
    alert.showAndWait()
}
