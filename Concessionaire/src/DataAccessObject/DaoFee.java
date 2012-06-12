
package DataAccessObject;

import BusinessObject.Bill;
import BusinessObject.Fee;
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
public class DaoFee {
    private BDFachada facade;
    private Connection con;
    private Statement stm;
    
    public DaoFee() {
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
    
    /*Bill bill;
    int id;
    String date;
    double deposit;
    double interest;*/
    
    public void save(Fee f){
        Bill b = f.getBill();
        String query;
        query="INSERT INTO  VALUES ('" +
                b.getEmp() + "', '" +
                b.getCar() +  "', '" +
                b.getClient() + "', "  +
                f.getId() + ", '"  +
                f.getDate() + "', "  +
                f.getDeposit() + ", "  +
                f.getInterest() + ")";
        try {
            stm.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println("Error: cannot execute query");
        }
    }
    
    public ArrayList<Fee> search(String nombreCliente){
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
