package org.uniquindio.gestioninformacionrestaurante.modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArchivoUtil {

    public static List<Cliente> leerCliente(String rutaArchivo) throws IOException {
        List<Cliente> clientes = new ArrayList<Cliente>();
        BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo));
        String linea;
        while ((linea = lector.readLine()) != null) {
            String[] partes = linea.split("@");
            Cliente cliente = new Cliente(partes[0], Integer.parseInt(partes[1]), partes[2], partes[3], partes[4], Integer.parseInt(partes[5]));
            clientes.add(cliente);
        }
        lector.close();
        return clientes;
    }

    public static void escribirCliente(String rutaArchivo, Cliente cliente) throws IOException {
        BufferedWriter escribir = new BufferedWriter(new FileWriter(rutaArchivo, true));
        escribir.write(cliente.toString());
        escribir.newLine();
        escribir.close();
    }

    public static List<Producto> leerProducto(String rutaArchivo) throws IOException {
        List<Producto> productos = new ArrayList<>();
        BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo));
        String linea;
        while ((linea = lector.readLine()) != null) {
            String[] partes = linea.split("#");
            Producto producto = new Producto(partes[0], partes[1], Double.parseDouble(partes[2]));
            productos.add(producto);
        }
        lector.close();
        return productos;
    }

    public static void escribirProducto(String rutaArchivo, Producto producto) throws IOException {
        BufferedWriter escribir = new BufferedWriter(new FileWriter(rutaArchivo, true));
        escribir.write(producto.toString());
        escribir.newLine();
        escribir.close();
    }
}
