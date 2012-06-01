/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import BusinessObject.Servicio;
import DataAccessObject.DaoServicio;
import java.util.ArrayList;

/**
 *
 * @author claito
 */
public class ControladorServicio {
    private DaoServicio daoServicio;
    
    public ControladorServicio() {
        daoServicio = new DaoServicio();
    }
    
    public boolean insertar(String id, String descripcion, int duracion, double costo) {
        Servicio s = new Servicio();
        
        s.setId(id);
        s.setDescripcion(descripcion);
        s.setDuracion(duracion);
        s.setCosto(costo);
        
        return daoServicio.insertar(s);
    }
    
    public boolean modificar(String id, String descripcion, int duracion, double costo) {
        Servicio s = new Servicio();
        
        s.setId(id);
        s.setDescripcion(descripcion);
        s.setDuracion(duracion);
        s.setCosto(costo);
        
        return daoServicio.modificar(s);   
    }
    
    public ArrayList<Servicio> listar() {
        ArrayList<Servicio> listaServicios = daoServicio.listar();
        return listaServicios;
    }
    
    public ArrayList<Servicio> filtrar(int opcion, String palabraClave) {
        ArrayList<Servicio> listaServicios = daoServicio.filtrar(opcion, palabraClave);
        return listaServicios;
    }
    
    public boolean eliminar(String id) {
        Servicio s = new Servicio();
        s.setId(id);
        
        return daoServicio.eliminar(s);
    }
    
    public boolean existe(String id) {
        Servicio s = new Servicio();
        s.setId(id);
        
        return daoServicio.existe(s);
    }
}
