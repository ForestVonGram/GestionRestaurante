package org.uniquindio.gestioninformacionrestaurante.modelo;

import java.util.Date;
import java.util.List;

public class Pedido {
    private Date fecha;
    private double total;
    private Cliente cliente;
    private List<Producto> productos;

    public Pedido(Date fecha, double total, Cliente cliente, List<Producto> productos) {
        this.fecha = fecha;
        this.total = total;
        this.cliente = cliente;
        this.productos = productos;
    }

    public Date getFecha() {
        return fecha;
    }

    public double getTotal() {
        return total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public String toXML() {
        StringBuilder xml = new StringBuilder();
        xml.append("<Pedido>\n");
        xml.append("\t<fecha>").append(fecha).append("</fecha>\n");
        xml.append("\t<total>").append(total).append("</total>\n");
        xml.append("\t<cliente>").append(cliente.toString()).append("</cliente>\n");
        xml.append("\t<productos>\n");

        for (Producto producto : productos) {
            xml.append("\t\t<producto>").append(producto.toString()).append("</producto>\n");
        }

        xml.append("\t</productos>\n");
        xml.append("</Pedido>\n");
        return xml.toString();
    }

}
