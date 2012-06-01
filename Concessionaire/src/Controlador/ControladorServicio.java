/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import BusinessObject.Servicio;
import DAO.DaoServicio;
import java.util.ArrayList;

/**
 *
 * @author claito
 */
public class ControladorServicio {
    private DaoServicio daoTipoServicio;
    
    public ControladorServicio() {
        daoTipoServicio = new DaoServicio();
    }
    
    public boolean insertar(String id, String descripcion, int duracion, double costo) {
        Servicio s = new Servicio();
        
        s.setId(id);
        s.setDescripcion(descripcion);
        s.setDuracion(duracion);
        s.setCosto(costo);
        
        boolean opExitosa = daoTipoServicio.insertar(s);
        return opExitosa;
    }
    
    public boolean modificar(String id, String descripcion, int duracion, double costo) {
        Servicio s = new Servicio();
        
        s.setId(id);
        s.setDescripcion(descripcion);
        s.setDuracion(duracion);
        s.setCosto(costo);
        
        boolean opExitosa = daoTipoServicio.modificar(s);
        return opExitosa;        
    }
    
    public ArrayList<Servicio> listar() {
        ArrayList<Servicio> listaServicios = daoTipoServicio.listar();
        return listaServicios;
    }
    
    public ArrayList<Servicio> filtrar(int opcion, String palabraClave) {
        ArrayList<Servicio> listaServicios = daoTipoServicio.filtrar(opcion, palabraClave);
        return listaServicios;
    }
    
    public boolean eliminar(String id) {
        Servicio s = new Servicio();
        s.setId(id);
        
        boolean opExitosa = daoTipoServicio.eliminar(s);
        return opExitosa;
    }
    
    public boolean existe(String id) {
        Servicio s = new Servicio();
        s.setId(id);
        
        boolean value = daoTipoServicio.existe(s);
        return value;
    }
}
