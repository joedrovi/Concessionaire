
package DAO;

import BusinessObject.*;
import Facade.DBFacade;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Jose Bernal
 */
public class DaoBill {
    private DBFacade facade;
    private Connection con;
    private Statement stm;

    public DaoBill() {
        facade = new DBFacade(); 
    }
    
    public void open(){
        con= facade.open();
        try {
            stm = con.createStatement();
        } catch (SQLException ex) {
            System.out.println("Error: bad statement creation");
        }
    }
    
    public void close(){
        facade.close(con);
    }
    
    public void save(Employee e,Car c,Client cl,String payType,String date){
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
    
    public ArrayList<Bill> search(String nombre){
        
        String query = "SELECT * FROM venta NATURAL JOIN cliente WHERE cliente.nombre LIKE "+nombre+";";
        ResultSet table;
        try {
            table = stm.executeQuery(query);
            
            ArrayList<Bill> res = new ArrayList<Bill>();
        
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
