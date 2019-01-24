/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Objeto;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

/**
 *
 * @author mykha
 */
public class DaoArticulos {

    public int añadirObjeto(Objeto o) {
        int filas = -1;
        DBConnection db = new DBConnection();
        Connection con = null;
        try {
            con = db.getConnection();
            QueryRunner qr = new QueryRunner();
            Number id = qr.insert(con,
                    "insert into objeto (id_categoria, imagenes, descripcion, ubicacion, responsable, fecha_de_alta) values(?,?,?)",
                    new ScalarHandler<>(),
                    o.getId_categoria(), o.getImagenes(), o.getDescripcion(), o.getUbicacion(), o.getId_responsable(), o.getFecha_de_alta());
            filas = id.intValue();
        } catch (Exception ex) {
            Logger.getLogger(DaoArticulos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.cerrarConexion(con);
        }
        return filas;
    }
}
