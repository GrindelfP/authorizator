module to.grindelf.authorizator {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens to.grindelf.authorizator to javafx.fxml;
    exports to.grindelf.authorizator;

    opens to.grindelf.authorizator.controllers to javafx.fxml;

}