/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.DaoArticulos;
import model.Objeto;

/**
 *
 * @author mykha
 */
public class ServiciosArticulos {

    public int añadrirObjeto(Objeto o) {
        dao.DaoArticulos da = new DaoArticulos();
        return da.añadirObjeto(o);
    }
}
