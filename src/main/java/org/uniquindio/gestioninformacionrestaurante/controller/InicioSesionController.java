package org.uniquindio.gestioninformacionrestaurante.controller;

import javafx.event.ActionEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.swing.*;

public class InicioSesionController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField contrasena;

    @FXML
    private Button ingresar_btn;

    @FXML
    private TextField usuario;

    private SceneController sceneController = new SceneController();

    private void verificarCredenciales(ActionEvent event) {
        try {
            String user = usuario.getText();
            String pass = contrasena.getText();

            Properties datosLogin = new Properties();
            FileInputStream entrada = new FileInputStream("login.properties");
            datosLogin.load(entrada);

            String usuarioGuardado = datosLogin.getProperty("usuario");
            String contrasenaGuardada = datosLogin.getProperty("contrasena");

            if (user.equals(usuarioGuardado) && pass.equals(contrasenaGuardada)) {
                System.out.println("Inicio de sesión exitoso.");
                sceneController.inicioSesion(event);
            } else {
                System.out.println("Credenciales incorrectas.");
            }

            entrada.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("No se pudo cargar la información.");
        }
    }

    @FXML
    void initialize() {
        ingresar_btn.setOnAction(event -> verificarCredenciales(event));

        assert contrasena != null : "fx:id=\"contrasena\" was not injected: check your FXML file 'iniciosesion-view.fxml'.";
        assert ingresar_btn != null : "fx:id=\"ingresar_btn\" was not injected: check your FXML file 'iniciosesion-view.fxml'.";
        assert usuario != null : "fx:id=\"usuario\" was not injected: check your FXML file 'iniciosesion-view.fxml'.";

    }

}
