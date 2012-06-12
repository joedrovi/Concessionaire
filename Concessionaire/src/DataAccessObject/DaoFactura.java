
package DataAccessObject;

import BusinessObject.*;
import Fachada.BDFachada;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Jose Bernal
 */
public class DaoFactura {
    private BDFachada fachada;
    private Connection con;
    private Statement stm;

    public DaoFactura() {
        fachada = new BDFachada(); 
    }
    
    public void open(){
        con= fachada.abrirConexion();
        try {
            stm = con.createStatement();
        } catch (SQLException ex) {
            System.out.println("Error: bad statement creation");
        }
    }
    
    public void close(){
        fachada.cerrarConexion(con);
    }
    
    public void save(Empleado e,Vehiculo c,Cliente cl,String payType,String date){
         String query;
        query="INSERT INTO venta VALUES ('" +
                e.getId() + "', '" +
                cl.getId() +  "', '" +
                c.getNumSerie() + "', '"  +
                c.getCosto() + "', '"  +
                date + "', '"  +
                payType + "')";
        try {
            stm.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println("Error: cannot execute query");
        }
    }
    
    public ArrayList<Factura> search(String nombre){
        
        String query = "SELECT * FROM venta NATURAL JOIN cliente WHERE cliente.nombre LIKE "+nombre+";";
        ResultSet table;
        try {
            table = stm.executeQuery(query);
            
            ArrayList<Factura> res = new ArrayList<Factura>();
        
            System.out.println("Nombre");
        
            while(table.next()){
               
                
            }
            
            return res;
        } catch (SQLException ex) {
            System.out.println("Error: cannot execute query");
            return null;
        }
    }
            
}
