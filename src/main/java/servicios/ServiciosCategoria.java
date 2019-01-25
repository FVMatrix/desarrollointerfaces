/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.DaoCategorias;
import java.util.List;
import model.Categoria;

/**
 *
 * @author mykha
 */
public class ServiciosCategoria {
    
    public List<Categoria> cargarTodosLasCategorias(){
        dao.DaoCategorias dc = new DaoCategorias();
        return dc.cargarTodasLasCategorias();
    }
    
    public int añadirCategoria(Categoria cat){
        dao.DaoCategorias dc = new DaoCategorias();
        return dc.añadirCategoria(cat);
    }
    
    public int borrarCategoria(Categoria cat){
        dao.DaoCategorias dc = new DaoCategorias();
        return dc.borrarCategoria(cat);
    }
    
    public Categoria cargarCategoriaPorID(int id){
        dao.DaoCategorias dc = new DaoCategorias();
        return dc.cargarCategoriaPorID(id);
    }
    
    public int modificarArticulo(Categoria cat){
        dao.DaoCategorias dc = new DaoCategorias();
        return dc.modificarCategoria(cat);
    }
}
