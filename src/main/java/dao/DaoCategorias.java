/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Categoria;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

/**
 *
 * @author mykha
 */
public class DaoCategorias {

    public List<Categoria> cargarTodasLasCategorias() {
        List<Categoria> lista = null;
        DBConnection db = new DBConnection();
        Connection con = null;
        try {
            con = db.getConnection();

            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<Categoria>> handler = new BeanListHandler<>(Categoria.class);
            lista = qr.query(con, "select * FROM categorias", handler);

        } catch (Exception ex) {
            Logger.getLogger(DaoCategorias.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.cerrarConexion(con);
        }
        return lista;
    }

    public int añadirCategoria(Categoria cat) {
        int filas = -1;
        DBConnection db = new DBConnection();
        Connection con = null;
        try {
            con = db.getConnection();
            QueryRunner qr = new QueryRunner();
            Number id = qr.insert(con,
                    "insert into categorias (nombre, descripcion) values(?,?)",
                    new ScalarHandler<>(),
                    cat.getNombre(), cat.getDescripcion());
            filas = id.intValue();
        } catch (Exception ex) {
            Logger.getLogger(DaoCategorias.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.cerrarConexion(con);
        }
        return filas;
    }

    public int borrarCategoria(Categoria cat) {
        int filas = -1;
        DBConnection db = new DBConnection();
        Connection con = null;

        try {
            con = db.getConnection();

            QueryRunner qr = new QueryRunner();

            filas = qr.update(con,
                    "DELETE FROM categorias WHERE id_categoria = ?", cat.getIdCategoria());

        } catch (SQLException ex) {
            filas = -2;
            Logger.getLogger(DaoCategorias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoCategorias.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.cerrarConexion(con);
        }
        return filas;
    }

    public Categoria cargarCategoriaPorID(int id) {
        Categoria cat = new Categoria();
        DBConnection db = new DBConnection();
        Connection con = null;
        try {
            con = db.getConnection();

            QueryRunner qr = new QueryRunner();
            ResultSetHandler handler = new BeanHandler<>(Categoria.class);
            cat = (Categoria) qr.query(con, "select * FROM categorias where id_categoria = ?", handler, id);
        } catch (Exception ex) {
            Logger.getLogger(DaoCategorias.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.cerrarConexion(con);
        }
        return cat;
    }

    public int modificarCategoria(Categoria cat) {
        int filas = -1;
        Connection con = null;
        DBConnection db = new DBConnection();

        try {
            con = db.getConnection();

            QueryRunner qr = new QueryRunner();

            filas = qr.update(con,
                    "UPDATE categorias SET nombre = ?, descripcion = ? WHERE id_categoria = ?",
                    cat.getNombre(), cat.getDescripcion(), cat.getIdCategoria());

        } catch (Exception ex) {
            Logger.getLogger(DaoCategorias.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.cerrarConexion(con);
        }
        return filas;
    }
}
