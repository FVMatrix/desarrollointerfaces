/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.DaoEmpleados;
import java.util.List;
import model.Empleado;

/**
 *
 * @author mykha
 */
public class ServiciosEmpleado {
    
    public List<Empleado> cargarTodosLosEmpleados(){
        dao.DaoEmpleados de = new DaoEmpleados();
        return de.cargarTodosLosEmpleados();
    }
    
    public int añadirEmpleado(Empleado emp){
        dao.DaoEmpleados de = new DaoEmpleados();
        return de.añadirEmpleado(emp);
    }
    
    public int borrarEmpleado(Empleado emp){
       dao.DaoEmpleados de = new DaoEmpleados();
        return de.borrarEmpleado(emp);
    }
    
    public Empleado cargarEmpleadoPorID(Empleado emp){
        dao.DaoEmpleados de = new DaoEmpleados();
        return de.cargarEmpleadoPorID(emp);
    }
    
    public Empleado cargarEmpleadoPorDNI(Empleado emp){
        dao.DaoEmpleados de = new DaoEmpleados();
        return de.cargarEmpleadoPorDNIDeUsuario(emp);
    }
    
    public int modificarEmpleado(Empleado emp){
        dao.DaoEmpleados de = new DaoEmpleados();
        return de.modificarEmpleado(emp);
    }
}
