/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author mykha
 */
public class Articulo {

    private int id_articulo;
    private String nombre;
    private int id_categoria;
    private String imagenes;
    private String descripcion;
    private int ubicacion;
    private int responsable;
    private Date fecha_de_alta;
    private int id_fecha_cambios;

    public Articulo() {

    }

    public Articulo(int id_objeto, String nombre, String imagenes, String descripcion, int ubicacion, Date fecha_de_alta, int responsable, int id_categoria) {
        this.id_articulo = id_objeto;
        this.nombre = nombre;
        this.id_categoria = id_categoria;
        this.imagenes = imagenes;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.responsable = responsable;
        this.fecha_de_alta = fecha_de_alta;
    }

//    public Articulo(int id_objeto, String nombre, int id_categoria, String imagenes, String descripcion, int ubicacion, int responsable, Date fecha_de_alta, int id_fecha_cambios) {
//        this.id_articulo = id_objeto;
//        this.nombre = nombre;
//        this.id_categoria = id_categoria;
//        this.imagenes = imagenes;
//        this.descripcion = descripcion;
//        this.idUbicacion = ubicacion;
//        this.responsable = responsable;
//        this.fecha_de_alta = fecha_de_alta;
//        this.id_fecha_cambios = id_fecha_cambios;
//    }
    public int getId_articulo() {
        return id_articulo;
    }

    public void setId_articulo(int id_articulo) {
        this.id_articulo = id_articulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getImagenes() {
        return imagenes;
    }

    public void setImagenes(String imagenes) {
        this.imagenes = imagenes;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(int ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getResponsable() {
        return responsable;
    }

    public void setResponsable(int responsable) {
        this.responsable = responsable;
    }

    public Date getFecha_de_alta() {
        return fecha_de_alta;
    }

    public void setFecha_de_alta(Date fecha_de_alta) {
        this.fecha_de_alta = fecha_de_alta;
    }

    public int getId_fecha_cambios() {
        return id_fecha_cambios;
    }

    public void setId_fecha_cambios(int id_fecha_cambios) {
        this.id_fecha_cambios = id_fecha_cambios;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public String toStringConTodo() {
        return "id_articulo=" + id_articulo + ", nombre=" + nombre + ", id_categoria=" + id_categoria + ", imagenes=" + imagenes + ", descripcion=" + descripcion + ", ubicacion=" + ubicacion + ", responsable=" + responsable + ", fecha_de_alta=" + fecha_de_alta + ", id_fecha_cambios=" + id_fecha_cambios + '}';
    }

}
