/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import java.sql.*;

/**
 *
 * @author maxbernal
 */
public class DBFacade {
    String url, usuario, password;
    Connection conexion;
    Statement instruccion;
    ResultSet tabla;
        
    DBFacade(){
        url="jdbc:postgresql://localhost:5432/joseabm";
        usuario="joseabm";
        password="joseabm";
    }

    public Connection open(){
        try {
            Class.forName("org.postgresql.Driver");
        } 
        catch (ClassNotFoundException ex) {
            System.out.println( "Error: Cannot charge the driver" );
        }
        
        try {
            conexion = DriverManager.getConnection(url, usuario, password);
            return conexion;
        } 
        catch (SQLException ex) {
            System.out.println( "Error: Cannot connect db" );
            return null;
        }        
    }

    public void close(Connection c){
        try{
            c.close();
        } 
        catch( Exception e ) {
            System.out.println( "Error: cannot close db connection" );
        }
    }
}
