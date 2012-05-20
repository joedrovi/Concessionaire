/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
        catch( Exception e ) {
            System.out.println( "Error: Cannot charge the driver" );
        }

        try{

        conexion = DriverManager.getConnection(url, usuario, password);
        System.out.println( "Open connection" );
        return conexion;
        //Crear objeto Statement para realizar queries a la base de datos
        } 
        catch( Exception e ) {
            System.out.println( "Error: cannot connect db" );
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
