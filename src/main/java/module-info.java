module org.uniquindio.gestioninformacionrestaurante {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.uniquindio.gestioninformacionrestaurante to javafx.fxml;
    opens org.uniquindio.gestioninformacionrestaurante.controller to javafx.fxml;

    exports org.uniquindio.gestioninformacionrestaurante;
    exports org.uniquindio.gestioninformacionrestaurante.controller;
}