package org.uniquindio.gestioninformacionrestaurante.modelo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class ArchivoXMLUtil {
    public static void guardarPedidoXML (Cliente cliente, List<Producto> productos, String rutaArchivos) throws Exception {
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();

        Element root = document.createElement("pedido");
        document.appendChild(root);

        Element clienteElement = document.createElement("cliente");

        Element codigo = document.createElement("codigo");
        codigo.appendChild(document.createTextNode(cliente.getCodigo()));
        clienteElement.appendChild(codigo);

        Element nombre = document.createElement("nombre");
        nombre.appendChild(document.createTextNode(cliente.getNombre()));
        clienteElement.appendChild(nombre);

        root.appendChild(clienteElement);

        Element productosElement = document.createElement("productos");

        for (Producto producto : productos) {
            Element productoElement = document.createElement("producto");

            Element codigoProducto = document.createElement("codigoProducto");
            codigoProducto.appendChild(document.createTextNode(producto.getCodigo()));
            productoElement.appendChild(codigoProducto);

            Element nombreProducto = document.createElement("nombreProducto");
            nombreProducto.appendChild(document.createTextNode(producto.getNombre()));
            productoElement.appendChild(nombreProducto);

            Element precioProducto = document.createElement("precioProducto");
            precioProducto.appendChild(document.createTextNode(String.valueOf(producto.getPrecio())));
            productoElement.appendChild(precioProducto);

            productosElement.appendChild(productoElement);
        }

        root.appendChild(productosElement);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(new File(rutaArchivos));

        transformer.transform(domSource, streamResult);

        System.out.println("Pedido guardado en: " + rutaArchivos);

    }
}
