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
public class Objeto {

    private int id_objeto;
    private int id_categoria;
    private String imagenes;
    private String descripcion;
    private String ubicacion;
    private int id_responsable;
    private Date fecha_de_alta;
    private int id_fecha_cambios;

    public Objeto(int id_objeto, int id_categoria, String imagenes, String descripcion, String ubicacion, int id_responsable, Date fecha_de_alta) {
        this.id_objeto = id_objeto;
        this.id_categoria = id_categoria;
        this.imagenes = imagenes;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.id_responsable = id_responsable;
        this.fecha_de_alta = fecha_de_alta;
    }

    
    public Objeto(int id_objeto, int id_categoria, String imagenes, String descripcion, String ubicacion, int id_responsable, Date fecha_de_alta, int id_fecha_cambios) {
        this.id_objeto = id_objeto;
        this.id_categoria = id_categoria;
        this.imagenes = imagenes;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.id_responsable = id_responsable;
        this.fecha_de_alta = fecha_de_alta;
        this.id_fecha_cambios = id_fecha_cambios;
    }

    
    
    public int getId_objeto() {
        return id_objeto;
    }

    public void setId_objeto(int id_objeto) {
        this.id_objeto = id_objeto;
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

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getId_responsable() {
        return id_responsable;
    }

    public void setId_responsable(int id_responsable) {
        this.id_responsable = id_responsable;
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
        return "Objeto{" + "id_objeto=" + id_objeto + ", id_categoria=" + id_categoria + ", imagenes=" + imagenes + ", descripcion=" + descripcion + ", ubicacion=" + ubicacion + ", id_responsable=" + id_responsable + ", fecha_de_alta=" + fecha_de_alta + ", id_fecha_cambios=" + id_fecha_cambios + '}';
    }
    
    
}
