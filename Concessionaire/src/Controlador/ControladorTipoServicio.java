/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import BusinessObject.TipoServicio;
import DAO.DaoTipoServicio;
import java.util.ArrayList;

/**
 *
 * @author claito
 */
public class ControladorTipoServicio {
    private DaoTipoServicio daoTipoServicio;
    
    public ControladorTipoServicio() {
        daoTipoServicio = new DaoTipoServicio();
    }
    
    public void insertar(String id, String descripcion, int duracion, double costo) {
        TipoServicio tp = new TipoServicio();
        
        tp.setId(id);
        tp.setDescripcion(descripcion);
        tp.setDuracion(duracion);
        tp.setCosto(costo);
        
        daoTipoServicio.insertar(tp);
    }
    
    public ArrayList<TipoServicio> listar() {
        ArrayList<TipoServicio> listaServicios = daoTipoServicio.listar();
        return listaServicios;
    }
    
    public ArrayList<TipoServicio> consultar(String descripcion) {
        ArrayList<TipoServicio> listaServicios = daoTipoServicio.consultar(descripcion);
        return listaServicios;
    }
    
    public void eliminar(String id) {
        daoTipoServicio.eliminar(id);
    }
}
