package org.uniquindio.gestioninformacionrestaurante.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import org.uniquindio.gestioninformacionrestaurante.modelo.Cliente;
import org.uniquindio.gestioninformacionrestaurante.modelo.Producto;

public class ConfirmarPedidoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text datosCliente;

    @FXML
    private TextArea listaProductos;

    @FXML
    private Button crearPedidoFinal_btn;

    private SceneController sceneController = new SceneController();

    public void setDatosCliente(String nombreCliente) {
        datosCliente.setText(nombreCliente);
    }

    public void setListaProductos(String productos) {
        listaProductos.setText(productos);
    }

    private void mostrarPedido(Cliente cliente, List<Producto> productosActuales) {
        setDatosCliente(cliente.getNombre());

        StringBuilder productosTxt = new StringBuilder();
        for (Producto producto : productosActuales) {
            productosTxt.append(producto.toString()).append("\n");
        }
        setListaProductos(productosTxt.toString());
    }

    @FXML
    void initialize() {
        assert crearPedidoFinal_btn != null : "fx:id=\"crearPedidoFinal_btn\" was not injected: check your FXML file 'confirmarPedido-view.fxml'.";
        assert datosCliente != null : "fx:id=\"datosCliente\" was not injected: check your FXML file 'confirmarPedido-view.fxml'.";
        assert listaProductos != null : "fx:id=\"listaProductos\" was not injected: check your FXML file 'confirmarPedido-view.fxml'.";
    }

}

