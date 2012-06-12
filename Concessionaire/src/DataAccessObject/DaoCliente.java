
package DataAccessObject;

import BusinessObject.Cliente;
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
public class DaoCliente {
    private BDFachada fachada;
    private Connection con;
    private Statement stm;

    public DaoCliente() {
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
    
    public void save(Cliente c){
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
    
    public ArrayList<Cliente> search(String nombre){
        
        String query = "SELECT * FROM cliente WHERE nombre LIKE '"+nombre+"';";
        ResultSet table;
        try {
            table = stm.executeQuery(query);
            
            ArrayList<Cliente> res = new ArrayList<Cliente>();
        
            while(table.next()){
                Cliente c = new Cliente();
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
