/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Fachada.BDFachada;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author claito
 */
public class Dao {
    protected BDFachada fachada;
    protected Connection conexion;
    protected Statement instruccion;
    
    public Dao() {
        fachada = new BDFachada(); 
    }
    
    protected void abrirConexion() {
        conexion = fachada.abrirConexion();
        
        try {
            instruccion = conexion.createStatement();
        } 
        catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    protected void cerrarConexion(){
        fachada.cerrarConexion(conexion);
    }
}
