
package DataAccessObject;

import BusinessObject.Client;
import Fachada.BDFachada;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jose Bernal
 */
public class DaoClient {
    private BDFachada facade;
    private Connection con;
    private Statement stm;

    public DaoClient() {
        facade = new BDFachada(); 
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
    
    public void save(Client c){
        String query;
        query="INSERT INTO cliente VALUES ('" +
                c.getId() + "', '" +
                c.getTipoId() +  "', '" +
                c.getNombre() + "', '"  +
                c.getGenero() + "', '"  +
                c.getDireccion() + "', '"  +
                c.getTelefono() + "', '"  +
                c.getEmail() + ")";
        try {
            stm.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println("Error: cannot execute query");
        }
    }
    
    public ArrayList<Client> search(String nombre){
        
        String query = "SELECT * FROM cliente WHERE nombre LIKE '"+nombre+"';";
        ResultSet table;
        try {
            table = stm.executeQuery(query);
            
            ArrayList<Client> res = new ArrayList<Client>();
        
            while(table.next()){
                Client c = new Client();
                c.setId(table.getString("id"));
                c.setTipoId(table.getString("tipo_id"));
                c.setNombre(table.getString("nombre"));
                c.setGenero(table.getString("genero"));
                c.setDireccion(table.getString("direccion"));
                c.setTelefono(table.getString("telefono"));
                c.setEmail(table.getString("email"));
                res.add(c);
            }
            
            return res;
        } catch (SQLException ex) {
            System.out.println("Error: cannot execute query");
            return null;
        }
    }
    
    public void delete(String nombre){
        String query = "DELETE FROM cliente WHERE nombre = '"+nombre+"';";
        try {
            stm.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println("Error: cannot execute query");
        }
    }
}
