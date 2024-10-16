package org.uniquindio.gestioninformacionrestaurante.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.uniquindio.gestioninformacionrestaurante.modelo.Producto;

public class AddProductoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button agregarProducto_btn;

    @FXML
    private Button continuar_btn;

    @FXML
    private TextField codigoProducto;

    @FXML
    private TextField nombreProducto;

    @FXML
    private TextField precioProducto;

    private SceneController sceneController = new SceneController();
    private List<Producto> productosActuales = new ArrayList<>();

    private void agregarProducto(ActionEvent event) {
        String codigo = codigoProducto.getText();
        String nombre = nombreProducto.getText();
        String precio = precioProducto.getText();

        if (codigo.isEmpty() || nombre.isEmpty() || precio.isEmpty()) {
            mostrarAlerta ("Error", "Todos los campos deben ser completados.");
            return;
        }

        Producto producto = new Producto(codigo, nombre, Double.parseDouble(precio));
        productosActuales.add(producto);
        limpiarCampos();

        String datosProducto = String.join("#", codigo, nombre, precio);

        try (BufferedWriter escritura = new BufferedWriter(new FileWriter("productos.txt", true))) {
            escritura.write(datosProducto);
            escritura.newLine();
            System.out.println("Cliente agregado: " + datosProducto);
            sceneController.addCliente(event);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al guardar el cliente.");
        }
    }

    private void limpiarCampos() {
        codigoProducto.clear();
        nombreProducto.clear();
        precioProducto.clear();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    @FXML
    void continuarConPedido(ActionEvent event) {
        try {
            sceneController.addProducto(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        agregarProducto_btn.setOnAction(event -> agregarProducto(event));
        continuar_btn.setOnAction(event -> continuarConPedido(event));

        assert agregarProducto_btn != null : "fx:id=\"agregarProducto_btn\" was not injected: check your FXML file 'addProducto-view.fxml'.";
        assert codigoProducto != null : "fx:id=\"codigoProducto\" was not injected: check your FXML file 'addProducto-view.fxml'.";
        assert nombreProducto != null : "fx:id=\"nombreProducto\" was not injected: check your FXML file 'addProducto-view.fxml'.";
        assert precioProducto != null : "fx:id=\"precioProducto\" was not injected: check your FXML file 'addProducto-view.fxml'.";
    }

}
