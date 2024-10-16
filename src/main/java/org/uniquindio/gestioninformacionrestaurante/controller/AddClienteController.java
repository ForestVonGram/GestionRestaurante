package org.uniquindio.gestioninformacionrestaurante.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.uniquindio.gestioninformacionrestaurante.modelo.Cliente;

public class AddClienteController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button agregarCliente_btn;

    @FXML
    private TextField apellidoCiente;

    @FXML
    private TextField cedulaCliente;

    @FXML
    private TextField codigoCliente;

    @FXML
    private TextField identificacionCliente;

    @FXML
    private TextField nombreCliente;

    @FXML
    private TextField telefonoCliente;

    @FXML
    private Button volver_btn;

    private SceneController sceneController = new SceneController();
    private Cliente clienteActual;

    private void agregarCliente(ActionEvent event) {
        String codigo = codigoCliente.getText();
        String cedula = cedulaCliente.getText();
        String tipoid = identificacionCliente.getText();
        String nombre = nombreCliente.getText();
        String apellido = apellidoCiente.getText();
        String telefono = telefonoCliente.getText();

        if (codigo.isEmpty() || cedula.isEmpty() || tipoid.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || telefono.isEmpty()) {
            mostrarAlerta("Error.", "Todos los campos deben ser completados.");
            return;
        }

        clienteActual = new Cliente(codigo, Integer.parseInt(cedula), tipoid, nombre, apellido, Integer.parseInt(telefono));

        String datosCliente = String.join("@", codigo, cedula, tipoid, nombre, apellido, telefono);


        try (BufferedWriter escritura = new BufferedWriter(new FileWriter("clientes.txt", true))) {
            escritura.write(datosCliente);
            escritura.newLine();
            System.out.println("Cliente agregado: " + datosCliente);
            sceneController.addCliente(event);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al guardar el cliente.");
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    @FXML
    void initialize() {
        agregarCliente_btn.setOnAction(event -> agregarCliente(event));

        assert agregarCliente_btn != null : "fx:id=\"agregarCliente_btn\" was not injected: check your FXML file 'addCliente-view.fxml'.";
        assert apellidoCiente != null : "fx:id=\"apellidoCiente\" was not injected: check your FXML file 'addCliente-view.fxml'.";
        assert cedulaCliente != null : "fx:id=\"cedulaCliente\" was not injected: check your FXML file 'addCliente-view.fxml'.";
        assert codigoCliente != null : "fx:id=\"codigoCliente\" was not injected: check your FXML file 'addCliente-view.fxml'.";
        assert identificacionCliente != null : "fx:id=\"identificacionCliente\" was not injected: check your FXML file 'addCliente-view.fxml'.";
        assert nombreCliente != null : "fx:id=\"nombreCliente\" was not injected: check your FXML file 'addCliente-view.fxml'.";
        assert telefonoCliente != null : "fx:id=\"telefonoCliente\" was not injected: check your FXML file 'addCliente-view.fxml'.";
        assert volver_btn != null : "fx:id=\"volver_btn\" was not injected: check your FXML file 'addCliente-view.fxml'.";

    }

}
