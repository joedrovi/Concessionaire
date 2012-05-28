/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import BusinessObject.Proveedor;
import DAO.DaoProveedor;
import java.util.ArrayList;

/**
 *
 * @author claito
 */
public class ControladorProveedor {
    private DaoProveedor daoProveedor;
    
    public ControladorProveedor() {
        daoProveedor = new DaoProveedor();
    }
    
    public void insertar(String nit, String razonSocial, String telefono, String direccion, String email) {
        Proveedor p = new Proveedor();
       
        p.setNit(nit);
        p.setRazonSocial(razonSocial);
        p.setTelefono(telefono);
        p.setDireccion(direccion);
        p.setEmail(email);
        
        daoProveedor.insertar(p);
    }
    
    public ArrayList<Proveedor> listar() {
        ArrayList<Proveedor> listaProveedores = daoProveedor.listar();
        return listaProveedores;
    }
    
    public ArrayList<Proveedor> consultar(String razonSocial) {
        ArrayList<Proveedor> listaProveedores = daoProveedor.consultar(razonSocial);
        return listaProveedores;
    }
    
    public void eliminar(String nit) {
        daoProveedor.eliminar(nit);
    }
}
