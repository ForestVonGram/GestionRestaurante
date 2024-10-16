package org.uniquindio.gestioninformacionrestaurante.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.uniquindio.gestioninformacionrestaurante.modelo.Cliente;
import org.uniquindio.gestioninformacionrestaurante.modelo.Producto;

public class PedidoCreadoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button crearOtroPedido_btn;

    @FXML
    private Text rutaPedidoCreado;

    @FXML
    private Button salir_btn;

    private void mostrarRutaPedido(String rutaArchivo) {
        rutaPedidoCreado.setText("El pedido se ha creado en: " + rutaArchivo);
    }

    @FXML
    void crearOtroPedido(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/uniquindio/gestioninformacionrestaurante/view/paginaPrincipal-view.fxml"));
        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void salir(ActionEvent event) {
        Stage stage = (Stage) salir_btn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        assert crearOtroPedido_btn != null : "fx:id=\"crearOtroPedido_btn\" was not injected: check your FXML file 'pedidoCreado-view.fxml'.";
        assert rutaPedidoCreado != null : "fx:id=\"rutaPedidoCreado\" was not injected: check your FXML file 'pedidoCreado-view.fxml'.";
        assert salir_btn != null : "fx:id=\"salir_btn\" was not injected: check your FXML file 'pedidoCreado-view.fxml'.";

    }

}
