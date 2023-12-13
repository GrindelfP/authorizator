package to.grindelf.authorizator

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.FileChooser
import javafx.stage.Stage
import to.grindelf.authorizator.dataprocessor.DataBaseOperator
import java.io.File

object Autorizator {

    private const val DATABASE_PATH: String = "src/main/resources/databases/users.db"
    private const val DATABASE_URL: String = "jdbc:sqlite:$DATABASE_PATH"

    @JvmStatic
    fun main(args: Array<String>) {
        val dataBaseOperator = DataBaseOperator(DATABASE_URL)

        if (!File(DATABASE_PATH).exists()) dataBaseOperator.createTable()

        val newUserLogin = "exampleUser"
        val newUserPassword = "examplePassword"
        dataBaseOperator.insertUser(newUserLogin, newUserPassword)

        // Пытаемся авторизоваться
        val loginAttempt = "exampleUser"
        val passwordAttempt = "examplePassword"

        if (dataBaseOperator.validator(loginAttempt, passwordAttempt)) {
            println("Successfully logged in")
        } else {
            println("Login failed")
        }
    }
}

class AutorizatorApplication : Application() {
    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(AutorizatorApplication::class.java.getResource("hello-view.fxml"))
        val scene = Scene(fxmlLoader.load(), 320.0, 240.0)
        stage.title = "Hello!"
        stage.scene = scene
        stage.show()
    }
}
