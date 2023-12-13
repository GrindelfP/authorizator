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
    override fun start(primaryStage: Stage) {
        val mainLoader = FXMLLoader(javaClass.getResource("main.fxml"))
        val mainRoot: Parent = mainLoader.load()
        val mainController = mainLoader.getController<MainController>()

        primaryStage.title = "Authorization and Registration"
        primaryStage.scene = Scene(mainRoot, 400.0, 300.0)
        primaryStage.show()
    }
}
