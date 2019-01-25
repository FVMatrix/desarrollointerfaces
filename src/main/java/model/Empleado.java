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
public class Empleado {

    private int id_empleado;
    private String dni;
    private String nombre;
    private String apellido;
    private int telefono;
    private String ubicacion;
    private int tipo_empleado;
    private String contraseña;
    private String email;
    
    public Empleado(){
        
    }

    public Empleado(int id_empleado, String dni, String nombre, String apellido, int telefono, String ubicacion, int tipo_usuario, String contraseña, String email) {
        this.id_empleado = id_empleado;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.ubicacion = ubicacion;
        this.tipo_empleado = tipo_usuario;
        this.contraseña = contraseña;
        this.email = email;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
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

    public int getTipo_empleado() {
        return tipo_empleado;
    }

    public void setTipo_empleado(int tipo_empleado) {
        this.tipo_empleado = tipo_empleado;
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
        return "ID:" + id_empleado + ". DNI: " + dni + ". NOMBRE: " + nombre + ". APELLIDOS: " + apellido + ". TELEFONO" + telefono + ". UBICACIÓN: " + ubicacion + ". TIPO DE USUARIO: " + tipo_empleado;
    }

    @Override
    public String toString() {
        return "DNI: " + dni + ". NOMBRE: " + nombre + ". APELLIDOS: " + apellido + ". TELEFONO" + telefono + ". UBICACIÓN: " + ubicacion;

    }

}
