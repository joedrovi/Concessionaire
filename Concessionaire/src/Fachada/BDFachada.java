
package Fachada;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jose Bernal
 */
public class BDFachada {
    private String url;
    private String usuario;
    private String password;
    
    private Connection conexion;
        
    public BDFachada(){
        url="jdbc:postgresql://localhost:5432/mariacsg";
        usuario="mariacsg";
        password="mariacsg";
    }

    public Connection abrirConexion(){
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
            System.out.println(ex);
            return null;
        }        
    }

    public void cerrarConexion(Connection c){
        try{
            c.close();
        } 
        catch( Exception ex ) {
            System.out.println(ex);
        }
    }
}
