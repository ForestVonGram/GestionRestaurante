package org.uniquindio.gestioninformacionrestaurante.modelo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class InicioSesionUtil {
    public static boolean verificarCredenciales (String usuario, String contrasena) throws IOException {
        Properties propiedades = new Properties();
        FileInputStream entrada = new FileInputStream("login.properties");
        propiedades.load(entrada);

        String usuarioGuardado = propiedades.getProperty("usuario");
        String contrasenaGuardada = propiedades.getProperty("contrasena");

        return usuario.equals(usuarioGuardado) && contrasena.equals(contrasenaGuardada);
    }
}
