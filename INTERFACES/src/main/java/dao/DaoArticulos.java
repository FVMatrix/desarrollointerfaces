/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Articulo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

/**
 *
 * @author mykha
 */
public class DaoArticulos {

    public int añadirArticulo(Articulo art) {
        int filas = -1;
        DBConnection db = new DBConnection();
        Connection con = null;
        try {
            con = db.getConnection();

            con.setAutoCommit(false);
            QueryRunner qr = new QueryRunner();

            Number id = qr.insert(con,
                    "insert into articulos (nombre, imagenes, descripcion, ubicacion, fecha_alta, responsable, id_categoria) values(?,?,?,?,?,?,?)",
                    new ScalarHandler<>(),
                    art.getNombre(), art.getImagenes(), art.getDescripcion(), art.getUbicacion(), art.getFecha_de_alta(), art.getResponsable(), art.getId_categoria());
            filas = id.intValue();

            art.setId_articulo(filas);
            id = qr.insert(con,
                    "insert into cambios (id_articulo, fecha_cambio,descripcion) values(?,?,?)",
                    new ScalarHandler<>(),
                    art.getId_articulo(), art.getFecha_de_alta(), "Creación de artículo");
            filas = id.intValue();

            con.commit();
        } catch (Exception ex) {
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(DaoArticulos.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DaoArticulos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.cerrarConexion(con);
        }
        return filas;
    }

    public List<Articulo> cargarTodosLosArticulos() {
        List<Articulo> lista = null;
        DBConnection db = new DBConnection();
        Connection con = null;
        try {
            con = db.getConnection();

            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<Articulo>> handler = new BeanListHandler<>(Articulo.class);
            lista = qr.query(con, "select * FROM articulos", handler);

        } catch (Exception ex) {
            Logger.getLogger(DaoArticulos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.cerrarConexion(con);
        }
        return lista;
    }

    public int borrarArticulo(Articulo art) {
        int filas = -1;
        DBConnection db = new DBConnection();
        Connection con = null;

        try {
            con = db.getConnection();

            con.setAutoCommit(false);

            QueryRunner qr = new QueryRunner();

//            filas = qr.update(con,
//                    "DELETE FROM fechas_cambios WHERE id_articulo = ?", art.getId_articulo());
            filas = qr.update(con,
                    "DELETE FROM usuario_articulo WHERE id_articulo = ?", art.getId_articulo());

            filas += qr.update(con,
                    "DELETE FROM articulos WHERE id_articulo = ?", art.getId_articulo());

            Number num = qr.insert(con, "insert into cambios (id_articulo,fecha_cambio,descripcion) values(?,?,?)",
                    new ScalarHandler<>(),
                    art.getId_articulo(), Date.valueOf(LocalDate.now()), "Eliminación de artículo");
            filas += num.intValue();
            con.commit();

        } catch (Exception ex) {
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(DaoArticulos.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DaoArticulos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.cerrarConexion(con);
        }
        return filas;
    }

    public Articulo cargarArticuloPorID(Articulo art) {
        Articulo arti = new Articulo();
        DBConnection db = new DBConnection();
        Connection con = null;
        try {
            con = db.getConnection();

            QueryRunner qr = new QueryRunner();
            ResultSetHandler handler = new BeanHandler<>(Articulo.class);
            arti = (Articulo) qr.query(con, "select * FROM articulos where id_articulo = ?", handler, art.getId_articulo());
        } catch (Exception ex) {
            Logger.getLogger(DaoArticulos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.cerrarConexion(con);
        }
        return arti;
    }

    public int modificarArticulo(Articulo art) {
        int filas = -1;
        Connection con = null;
        DBConnection db = new DBConnection();

        try {
            con = db.getConnection();

            con.setAutoCommit(false);
            QueryRunner qr = new QueryRunner();

            filas = qr.update(con,
                    "UPDATE articulos SET nombre = ?, id_categoria = ?, imagenes = ?, descripcion = ?, ubicacion = ?, responsable = ?  WHERE id_articulo = ?",
                    art.getNombre(), art.getId_categoria(), art.getImagenes(), art.getDescripcion(), art.getUbicacion(), art.getResponsable(), art.getId_articulo());

            Number num = qr.insert(con, "insert into cambios (id_articulo,fecha_cambio,descripcion) values(?,?,?)",
                    new ScalarHandler<>(),
                    art.getId_articulo(), Date.valueOf(LocalDate.now()), "Modificación de artículo");
            filas += num.intValue();
            con.commit();
        } catch (Exception ex) {
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(DaoArticulos.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DaoArticulos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.cerrarConexion(con);
        }
        return filas;
    }
}
