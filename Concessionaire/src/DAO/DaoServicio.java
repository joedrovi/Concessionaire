/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Joedrovi
 */

import BusinessObject.Servicio;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoServicio extends Dao {    
    public DaoServicio() {
        super();
    }
        
    public boolean insertar(Servicio s) {
        abrirConexion();
        
        String query = "INSERT INTO servicio VALUES('" +
                        s.getId() + "','" +
                        s.getDescripcion() + "'," +
                        s.getDuracion() + "," +
                        s.getCosto() + ")";
        
        try {
            instruccion.executeUpdate(query);
            cerrarConexion();
            return true;
        } 
        catch (SQLException ex) {
            System.out.println(ex);
        }

        cerrarConexion();   
        return false;
    }
    
    public boolean modificar(Servicio s) {
        abrirConexion();
        
        String query = "UPDATE servicio SET " +
                        "descripcion_serv='" + s.getDescripcion() + "', " +
                        "duracion_serv=" + s.getDuracion() + ", " +
                        "costo_serv=" + s.getCosto() + "WHERE id_serv LIKE '" + s.getId() + "'";
        
        try {
            instruccion.executeUpdate(query);
            cerrarConexion();
            return true;
        } 
        catch (SQLException ex) {
            System.out.println(ex);
        }

        cerrarConexion();   
        return false;
    }
    
    public ArrayList<Servicio> listar() {
        abrirConexion();
        
        String query = "SELECT * FROM servicio";
        ArrayList<Servicio> resultado = new ArrayList<Servicio>();
        
        try {
            ResultSet tabla = instruccion.executeQuery(query);

            while(tabla.next()) {
                Servicio tp = new Servicio();

                tp.setId(tabla.getString("id_serv"));
                tp.setDescripcion(tabla.getString("descripcion_serv"));
                tp.setDuracion(tabla.getInt("duracion_serv"));
                tp.setCosto(tabla.getDouble("costo_serv"));

                resultado.add(tp);
            }
        }
        catch (SQLException ex) {
            System.out.println(ex);
        }

        cerrarConexion();         
        return resultado;
    }
    
    public ArrayList<Servicio> filtrar(int opcion, String palabraClave) {
        abrirConexion();
        
        String query = "SELECT * FROM servicio WHERE ";
        
        switch(opcion) {
            case 0:
                query = "id_serv LIKE '" + palabraClave + "'";
                break;
            
            case 1:
                query = "descripcion_serv LIKE '%" + palabraClave + "%'";
                break;
        }
        
        ArrayList<Servicio> resultado = new ArrayList<Servicio>();
        
        try {
            ResultSet tabla = instruccion.executeQuery(query);

            while(tabla.next()) {
                Servicio s = new Servicio();

                s.setId(tabla.getString("id_serv"));
                s.setDescripcion(tabla.getString("descripcion_serv"));
                s.setDuracion(tabla.getInt("duracion_serv"));
                s.setCosto(tabla.getDouble("costo_serv"));

                resultado.add(s);
            }
        }
        catch (SQLException ex) {
            System.out.println(ex);
        }

        cerrarConexion();        
        return resultado;
    }
    
    public boolean eliminar(Servicio s) {
        abrirConexion();
        
        String query = "DELETE FROM servicio WHERE id_serv LIKE '" + s.getId() + "'";
      
        try {
            instruccion.executeUpdate(query);
            cerrarConexion();
            return true;
        }
        catch(SQLException ex) {
            System.out.println(ex);
        }

        cerrarConexion();
        return false;
    }
    
    public boolean existe(Servicio s) {
        abrirConexion();
        
        String query = "SELECT * FROM servicio WHERE id_serv LIKE '" + s.getId() + "'";
        
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
