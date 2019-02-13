/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Ragnar
 */
public class Cambio {
    private int id_fecha_cambio;
    private Date fecha_cambio;
    private String descripcion;
    
    public Cambio(){
        
    }

    public Cambio(int id_fecha_cambio, Date fecha_cambio, String descripcion) {
        this.id_fecha_cambio = id_fecha_cambio;
        this.fecha_cambio = fecha_cambio;
        this.descripcion = descripcion;
    }

    public int getId_fecha_cambio() {
        return id_fecha_cambio;
    }

    public void setId_fecha_cambio(int id_fecha_cambio) {
        this.id_fecha_cambio = id_fecha_cambio;
    }

    public Date getFecha_cambio() {
        return fecha_cambio;
    }

    public void setFecha_cambio(Date fecha_cambio) {
        this.fecha_cambio = fecha_cambio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Cambio{" + "id_fecha_cambio=" + id_fecha_cambio + ", fecha_cambio=" + fecha_cambio + ", descripcion=" + descripcion + '}';
    }
    
    
}
