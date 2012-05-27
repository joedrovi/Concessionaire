/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
    
    public void abrirConexion() {
        conexion = fachada.open();
        
        try {
            instruccion = conexion.createStatement();
        } 
        catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void cerrarConexion() {
        fachada.close(conexion);
    }
    
     public void insertar(Proveedor p) {
        String query = "INSERT INTO proveedor VALUES ('" +
                        p.getNit() + "', '" +
                        p.getRazonSocial() +  "', '" +                
                        p.getTelefono() + ", '"  +
                        p.getDireccion() + "', "  +
                        p.getEmail() + "')";
        
        try {
            instruccion.executeUpdate(query);
        } 
        catch (SQLException e) {
            System.out.println(e);
        }
    }
     
     public ArrayList<Proveedor> listar() {
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
         
         return resultado;
     }
     
     public ArrayList<Proveedor> consultar(String razonSocial) {        
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
        
        return resultado;
     }
     
     public void eliminar(String razonSocial) {
         String query = "DELETE FROM proveedor WHERE razon_social_prov LIKE '" + razonSocial + "'";
         
         try {
             instruccion.executeUpdate(query);
         }
         catch(SQLException e) {
             System.out.println(e);
         }
     }    
}
