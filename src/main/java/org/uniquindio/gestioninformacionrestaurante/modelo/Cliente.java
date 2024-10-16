package org.uniquindio.gestioninformacionrestaurante.modelo;

public class Cliente {
    private String codigo;
    private int cedula;
    private String tipoIdentificacion;
    private String nombre;
    private String apellido;
    private int telefono;

    public Cliente(String codigo, int cedula, String tipoIdentificacion, String nombre, String apellido, int telefono) {
        this.codigo = codigo;
        this.cedula = cedula;
        this.tipoIdentificacion = tipoIdentificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getCedula() {
        return cedula;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return codigo + "@" + cedula + "@" + tipoIdentificacion + "@" + nombre + "@" + apellido + "@" + telefono;
    }
}
