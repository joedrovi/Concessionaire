
package DataAccessObject;

import BusinessObject.Factura;
import BusinessObject.Cuota;
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
public class DaoCouta {
    private BDFachada fachada;
    private Connection con;
    private Statement stm;
    
    public DaoCouta() {
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
    
    /*Bill bill;
    int id;
    String date;
    double deposit;
    double interest;*/
    
    public void save(Cuota f){
        Factura b = f.getFactura();
        String query;
        query="INSERT INTO  VALUES ('" +
                b.getEmpleado() + "', '" +
                b.getVehiculo() +  "', '" +
                b.getCliente() + "', "  +
                f.getId() + ", '"  +
                f.getFecha() + "', "  +
                f.getDeposito() + ", "  +
                f.getInteres() + ")";
        try {
            stm.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println("Error: cannot execute query");
        }
    }
    
    public ArrayList<Cuota> search(String nombreCliente){
        String query = "SELECT * FROM cuota WHERE nombre LIKE '"+nombreCliente+"';";
        ResultSet table;
        try {
            table = stm.executeQuery(query);
            
            
            while(table.next()){
            }
            
            return null;
        } catch (SQLException ex) {
            System.out.println("Error: cannot execute query");
            return null;
        }
    }
    
    public void delete(int id){
        String query = "DELETE FROM cliente WHERE id = "+id+";";
        try {
            stm.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println("Error: cannot execute query");
        }
    }
}
