/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

/**
 *
 * @author Joedrovi
 */

import BusinessObject.Proveedor;
import Fachada.BDFachada;
import java.sql.*;
import java.util.*;

public class DaoProveedor {
    private BDFachada fachada;
    private Connection conexion;
    private Statement instruccion;
    
    public DaoProveedor() {
        fachada = new BDFachada(); 
    }
    
    private void abrirConexion() {
        conexion = fachada.open();
        
        try {
            instruccion = conexion.createStatement();
        } 
        catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    private void cerrarConexion() {
        fachada.close(conexion);
    }
    
    public void insertar(Proveedor p) {
        abrirConexion();

        String query = "INSERT INTO proveedor VALUES ('" +
                        p.getNit() + "', '" +
                        p.getRazonSocial() +  "', '" +                
                        p.getTelefono() + "', '"  +
                        p.getDireccion() + "', '"  +
                        p.getEmail() + "')";

        try {
            instruccion.executeUpdate(query);
        } 
        catch (SQLException e) {
            System.out.println(e);
        }

        cerrarConexion();
    }
     
    public ArrayList<Proveedor> listar() {
        abrirConexion();

        String query = "SELECT * FROM proveedor";
        ArrayList<Proveedor> resultado = new ArrayList<Proveedor>();

        try {
            ResultSet tabla = instruccion.executeQuery(query);

            while(tabla.next()) {
                Proveedor p = new Proveedor();

                p.setNit(tabla.getString("nit_prov"));
                p.setRazonSocial(tabla.getString("razon_social_prov"));                
                p.setTelefono(tabla.getString("tel_prov"));
                p.setDireccion(tabla.getString("dir_prov"));
                p.setEmail(tabla.getString("email_prov"));

                resultado.add(p);
            }
        }
        catch(SQLException e) {
            System.out.println(e);
        }

        cerrarConexion();
        return resultado;
    }
     
    public ArrayList<Proveedor> consultar(String razonSocial) {
        abrirConexion();

        String query = "SELECT * FROM proveedor WHERE razon_social_prov LIKE '%" + razonSocial + "'%";
        ArrayList<Proveedor> resultado = new ArrayList<Proveedor>();

        try {
            ResultSet tabla = instruccion.executeQuery(query); 

            while(tabla.next()) {
                Proveedor p = new Proveedor();

                p.setNit(tabla.getString("nit_prov"));
                p.setRazonSocial(tabla.getString("razon_social_prov"));                
                p.setTelefono(tabla.getString("tel_prov"));
                p.setDireccion(tabla.getString("dir_prov"));
                p.setEmail(tabla.getString("email_prov"));

                resultado.add(p);
            }
        } 
        catch (SQLException e) {
            System.out.println(e);
        }

        cerrarConexion();
        return resultado;
    }
     
    public void eliminar(String nit) {
        abrirConexion();

        String query = "DELETE FROM proveedor WHERE nit_prov LIKE '" + nit + "'";

        try {
            instruccion.executeUpdate(query);
        }
        catch(SQLException e) {
            System.out.println(e);
        }

        cerrarConexion();
    }
    
    public boolean existe(String nit) {
        abrirConexion();
        
        String query = "SELECT * FROM proveedor WHERE nit_prov LIKE '" + nit + "'";
        
        try {
            ResultSet resultado = instruccion.executeQuery(query);
            
            if( resultado.next() ) {
                cerrarConexion();
                return true;
            }
        }
        catch(SQLException e) {
            System.out.println(e);
        }

        cerrarConexion();
        return false;
    }
}
