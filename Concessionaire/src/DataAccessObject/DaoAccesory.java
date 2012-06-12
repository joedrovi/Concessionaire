/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

import BusinessObject.Accesorio;
import Fachada.BDFachada;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Chavelo
 */
public class DaoAccesory {
    private BDFachada facade;
    private Connection con;
    private Statement stm;
    
    public DaoAccesory() {
        facade = new BDFachada(); 
    }
    
    public void open(){
        con= facade.open();
        try {
            stm = con.createStatement();
        }
        catch (SQLException ex) {
            System.out.println("Error: bad statement creation");
        }
    }
    
    public void close(){
        facade.close(con);
    }
    
    public void save(Accesorio a){
        String query;
        query="INSERT INTO accesorio VALUES ('" +
                a.getSerial() + "', '" +                
                a.getTipo() +  "', '" +
                a.getDescripcion() + "', " +
                a.getCosto() + ", '"  +
                a.getProveedor() + ")";
        try {
            stm.executeUpdate(query);
        }
        catch (SQLException ex) {
            System.out.println("Error: cannot execute query");
        }
    }
    
    public ArrayList<Accesorio> search(String descripcion) {
        String query = "SELECT * FROM accesorio WHERE nombre LIKE "+descripcion+";";
        ResultSet table;
        
        try {
            table = stm.executeQuery(query);
            
            ArrayList<Accesorio> res = new ArrayList<Accesorio>();
            
            while(table.next()) {
                Accesorio a = new Accesorio();
                a.setSerial(table.getString("serial"));
                a.setTipo(table.getString("tipo"));
                a.setDescripcion(table.getString("descripcion"));
                a.setCosto(table.getDouble("costo"));
                a.setProveedor(table.getString("proveedor"));
                
                res.add(a);
            }
            
            return res;
        }
        catch (SQLException ex) {
            System.out.println("Error: cannot execute query");
            return null;
        }
    }
}
