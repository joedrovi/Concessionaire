/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Joedrovi
 */

import BusinessObject.TipoServicio;
import Fachada.BDFachada;
import java.sql.*;
import java.util.ArrayList;

public class DaoTipoServicio {
    private BDFachada fachada;
    private Connection conexion;
    private Statement instruccion;
    
    public DaoTipoServicio() {
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
    
    public void insertar(TipoServicio tp) {
        abrirConexion();
        
        String query = "INSERT INTO tipo_servicio VALUES('" +
                        tp.getId() + "','" +
                        tp.getDescripcion() + "'," +
                        tp.getDuracion() + "," +
                        tp.getCosto() + ")";
        
        try {
            instruccion.executeUpdate(query);
        } 
        catch (SQLException e) {
            System.out.println(e);
        }

        cerrarConexion();                        
    }
    
    public ArrayList<TipoServicio> listar() {
        abrirConexion();
        
        String query = "SELECT * FROM tipo_servicio";
        ArrayList<TipoServicio> resultado = new ArrayList<TipoServicio>();
        
        try {
            ResultSet tabla = instruccion.executeQuery(query);

            while(tabla.next()) {
                TipoServicio tp = new TipoServicio();

                tp.setId(tabla.getString("id_serv"));
                tp.setDescripcion(tabla.getString("descripcion_serv"));
                tp.setDuracion(tabla.getInt("duracion_serv"));
                tp.setCosto(tabla.getDouble("costo_serv"));

                resultado.add(tp);
            }
        }
        catch (SQLException e) {
            System.out.println(e);
        }

        cerrarConexion(); 
        
        return resultado;
    }
    
    public ArrayList<TipoServicio> consultar(String descripcion) {
        abrirConexion();
        
        String query = "SELECT * FROM tipo_servicio WHERE descripcion_serv LIKE '" + descripcion + "'";
        ArrayList<TipoServicio> resultado = new ArrayList<TipoServicio>();
        
        try {
            ResultSet tabla = instruccion.executeQuery(query);

            while(tabla.next()) {
                TipoServicio tp = new TipoServicio();

                tp.setId(tabla.getString("id_serv"));
                tp.setDescripcion(tabla.getString("descripcion_serv"));
                tp.setDuracion(tabla.getInt("duracion_serv"));
                tp.setCosto(tabla.getDouble("costo_serv"));

                resultado.add(tp);
            }
        }
        catch (SQLException e) {
            System.out.println(e);
        }

        cerrarConexion(); 
        
        return resultado;
    }
    
    public void eliminar(String id) {
        abrirConexion();

        String query = "DELETE FROM proveedor WHERE id_serv LIKE '" + id + "'";

        try {
            instruccion.executeUpdate(query);
        }
        catch(SQLException e) {
            System.out.println(e);
        }

        cerrarConexion();
    } 
}