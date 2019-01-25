/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.DaoCambios;
import java.util.List;
import model.Articulo;
import model.Cambio;

/**
 *
 * @author Ragnar
 */
public class ServiciosCambios {
    
    public List<Cambio> cargarTodosLosCambiosDeUnArticulo(Articulo art){
        DaoCambios dc = new DaoCambios();
        return dc.cargarTodosLosCambiosDeUnArticulo(art);
    }
    
}
