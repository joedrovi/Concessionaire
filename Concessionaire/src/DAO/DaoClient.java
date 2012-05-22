
package DAO;

import BusinessObject.Client;
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
public class DaoClient {
    private DBFacade facade;
    private Connection con;
    private Statement stm;

    public DaoClient() {
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
        
        String query = "SELECT * FROM cliente WHERE nombre LIKE "+nombre+";";
        ResultSet table;
        try {
            table = stm.executeQuery(query);
            
            ArrayList<Client> res = new ArrayList<Client>();
        
            System.out.println("Nombre");
        
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
    
    
}
