package to.grindelf.authorizator

import javafx.application.Application
import javafx.application.Application.launch
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage
import to.grindelf.authorizator.dataprocessor.Processor
import java.io.File

object Diary {

    @JvmStatic
    fun main(args: Array<String>) {
        launch(DiaryApplication::class.java)
    }
}

class DiaryApplication : Application() {

    companion object {
        const val WINDOW_HEIGHT = 600.0
        const val WINDOW_WIDTH = 800.0
    }

    init {
        val databaseFile = File(Processor.DATABASE_PATH)
        if (!databaseFile.exists()) {
            Processor.createDataBase()
        }
    }

    override fun start(primaryStage: Stage) {
        val root = FXMLLoader.load<Parent>(javaClass.getResource("/to/grindelf/authorizator/main.fxml"))
        primaryStage.title = "Diary Application"
        primaryStage.scene = Scene(root)
        primaryStage.height = WINDOW_HEIGHT
        primaryStage.width = WINDOW_WIDTH
        primaryStage.show()
    }
}
