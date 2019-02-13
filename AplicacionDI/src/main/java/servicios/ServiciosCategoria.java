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

    public List<Categoria> devuelveTodasCategorias() {
        dao.DaoCategorias dc = new DaoCategorias();
        return dc.devuelveTodasCategorias();
    }
}
