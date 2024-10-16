package org.uniquindio.gestioninformacionrestaurante.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PedidoCreadoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button crearOtroPedido_btn;

    @FXML
    private Button salir_btn;

    @FXML
    void initialize() {
        assert crearOtroPedido_btn != null : "fx:id=\"crearOtroPedido_btn\" was not injected: check your FXML file 'pedidoCreado-view.fxml'.";
        assert salir_btn != null : "fx:id=\"salir_btn\" was not injected: check your FXML file 'pedidoCreado-view.fxml'.";

    }

}
