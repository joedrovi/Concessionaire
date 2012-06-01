/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import BusinessObject.Empleado;
import DataAccessObject.DaoEmpleado;
import java.util.ArrayList;

/**
 *
 * @author claito
 */
public class ControladorEmpleado {
    private DaoEmpleado daoEmpleado;
    
    public ControladorEmpleado() {
        daoEmpleado = new DaoEmpleado();
    }
    
    public boolean insertar(String id, String password, String nombre, String telefono, String email, String cargo, String direccion, char genero, double salario) {
        Empleado e = new Empleado();
        
        e.setId(id);
        e.setPassword(password);
        e.setNombre(nombre);
        e.setTelefono(telefono);
        e.setEmail(email);
        e.setCargo(cargo);
        e.setDireccion(direccion);
        e.setGenero(genero);
        e.setSalario(salario);
        
        return daoEmpleado.insertar(e);
    }
    
    public boolean modificar(String id, String nombre, String telefono, String email, String cargo, String direccion, char genero, double salario) {
        Empleado e = new Empleado();
        
        e.setId(id);
        e.setNombre(nombre);
        e.setTelefono(telefono);
        e.setEmail(email);
        e.setCargo(cargo);
        e.setDireccion(direccion);
        e.setGenero(genero);
        e.setSalario(salario);
        
        return daoEmpleado.modificar(e);
    }
    
    public ArrayList<Empleado> listar() {
        ArrayList<Empleado> listaServicios = daoEmpleado.listar();
        return listaServicios;
    }
    
    public ArrayList<Empleado> filtrar(int criterio, String palabraClave) {
        ArrayList<Empleado> listaServicios = daoEmpleado.filtrar(criterio, palabraClave);
        return listaServicios;
    }
    
    public boolean eliminar(String id) {
        Empleado e = new Empleado();
        e.setId(id);
        
        return daoEmpleado.eliminar(e);
    }
    
    public boolean existe(String id) {
        Empleado e = new Empleado();
        e.setId(id);
        
        return daoEmpleado.existe(e);
    }
}
