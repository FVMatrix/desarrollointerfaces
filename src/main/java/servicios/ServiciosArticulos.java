/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.DaoArticulos;
import java.util.List;
import model.Articulo;

/**
 *
 * @author mykha
 */
public class ServiciosArticulos {

    public int añadirArticulo(Articulo art) {
        dao.DaoArticulos da = new DaoArticulos();
        return da.añadirArticulo(art);
    }
    
    public List<Articulo> cargarTodosLosArticulos(){
        dao.DaoArticulos da = new DaoArticulos();
        return da.cargarTodosLosArticulos();
    }
    
    public int borrarArticulo(Articulo art){
        dao.DaoArticulos da = new DaoArticulos();
        return da.borrarArticulo(art);
    }
    
    public Articulo cargarArticuloPorID(Articulo art){
        dao.DaoArticulos da = new DaoArticulos();
        return da.cargarArticuloPorID(art);
    }
    
    public int modificarArticulo(Articulo art){
        dao.DaoArticulos da = new DaoArticulos();
        return da.modificarArticulo(art);
    }
}
