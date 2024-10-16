package org.uniquindio.gestioninformacionrestaurante.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class PaginaPrincipalController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button generarPedido_btn;

    @FXML
    private Text nombreUsuario;

    private SceneController sceneController = new SceneController();

    private void setNombreUsuario(String nombre) {
        nombreUsuario.setText(nombre);
    }

    private void cargarNombreUsuario() {
        Properties properties = new Properties();
        try {
            FileInputStream entrada = new FileInputStream("login.properties");
            properties.load(entrada);
            String usuario = properties.getProperty("usuario");
            setNombreUsuario(usuario);
            entrada.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("No se pudo cargar el nombre de usuario.");
        }
    }

    private void generarPedido(ActionEvent event) {
        try {
            System.out.println("Generando pedido...");
            sceneController.paginaPrincipal(event);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al generar pedido.");
        }
    }

    @FXML
    void initialize() {
        cargarNombreUsuario();
        generarPedido_btn.setOnAction(event -> generarPedido(event));
        assert generarPedido_btn != null : "fx:id=\"generarPedido_btn\" was not injected: check your FXML file 'paginaPrincipal-view.fxml'.";
        assert nombreUsuario != null : "fx:id=\"nombreUsuario\" was not injected: check your FXML file 'paginaPrincipal-view.fxml'.";

    }

}
