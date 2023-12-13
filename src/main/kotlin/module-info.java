module to.grindelf.authorizator {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;

    requires org.kordamp.bootstrapfx.core;

    opens to.grindelf.authorizator to javafx.fxml;
    exports to.grindelf.authorizator;
}