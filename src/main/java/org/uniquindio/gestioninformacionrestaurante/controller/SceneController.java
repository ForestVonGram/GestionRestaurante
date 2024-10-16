package org.uniquindio.gestioninformacionrestaurante.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void inicioSesion(ActionEvent event) throws IOException {
        cambiarEscena(event, "/org/uniquindio/gestioninformacionrestaurante/view/paginaPrincipal-view.fxml");
    }

    public void paginaPrincipal(ActionEvent event) throws IOException {
        cambiarEscena(event, "/org/uniquindio/gestioninformacionrestaurante/view/addCliente-view.fxml");

    }

    public void addCliente(ActionEvent event) throws IOException {
        cambiarEscena(event, "/org/uniquindio/gestioninformacionrestaurante/view/addProducto-view.fxml");

    }

    public void addProducto(ActionEvent event) throws IOException {
        cambiarEscena(event, "/org/uniquindio/gestioninformacionrestaurante/view/confirmarPedido-view.fxml");

    }

    public void confirmarPedido(ActionEvent event) throws IOException {
        cambiarEscena(event, "/org/uniquindio/gestioninformacionrestaurante/view/pedidoCreado-view.fxml");

    }

    public void cambiarEscena(ActionEvent event, String rutaFxml) throws IOException {
        root = FXMLLoader.load(getClass().getResource(rutaFxml));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
