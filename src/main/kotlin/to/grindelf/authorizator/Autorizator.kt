package to.grindelf.authorizator

import javafx.application.Application
import javafx.application.Application.launch
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.FileChooser
import javafx.stage.Stage
import to.grindelf.authorizator.controllers.MainController
import to.grindelf.authorizator.dataprocessor.DataBaseOperator
import java.io.File

object Autorizator {

    @JvmStatic
    fun main(args: Array<String>) {
        launch(AutorizatorApplication::class.java)
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
