/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author mykha
 */
public class Usuario {

    private int id_usuario;
    private String dni;
    private String nombre;
    private String apellido;
    private int telefono;
    private String ubicacion;
    private int tipo_usuario;
    private String contraseña;
    private String email;

    public Usuario(int id_usuario, String dni, String nombre, String apellido, int telefono, String ubicacion, int tipo_usuario, String contraseña, String email) {
        this.id_usuario = id_usuario;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.ubicacion = ubicacion;
        this.tipo_usuario = tipo_usuario;
        this.contraseña = contraseña;
        this.email = email;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(int tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toStringConTodo() {
        return "ID:" + id_usuario + ". DNI: " + dni + ". NOMBRE: " + nombre + ". APELLIDOS: " + apellido + ". TELEFONO" + telefono + ". UBICACIÓN: " + ubicacion + ". TIPO DE USUARIO: " + tipo_usuario;
    }

    @Override
    public String toString() {
        return "DNI: " + dni + ". NOMBRE: " + nombre + ". APELLIDOS: " + apellido + ". TELEFONO" + telefono + ". UBICACIÓN: " + ubicacion;

    }

}
