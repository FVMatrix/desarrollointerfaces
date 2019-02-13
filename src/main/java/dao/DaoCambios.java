/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Articulo;
import model.Cambio;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author Ragnar
 */
public class DaoCambios {
    public List<Cambio> cargarTodosLosCambiosDeUnArticulo(Articulo art) {
        List<Cambio> lista = null;
        DBConnection db = new DBConnection();
        Connection con = null;
        try {
            con = db.getConnection();

            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<Cambio>> handler = new BeanListHandler<>(Cambio.class);
            lista = qr.query(con, "select * FROM cambios where id_articulo = ?", handler, art.getId_articulo());

        } catch (Exception ex) {
            Logger.getLogger(DaoCambios.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.cerrarConexion(con);
        }
        return lista;
    }
}
