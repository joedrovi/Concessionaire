/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Chavelo
 */

import BusinessObject.Employee;
import Facade.DBFacade;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoEmployee {
    private DBFacade facade;
    private Connection con;
    private Statement stm;
    
    public DaoEmployee()
    {
        facade = new DBFacade(); 
    }
    
    public void open()
    {
        con = facade.open();
        try 
        {
            stm = con.createStatement();
        } 
        catch (SQLException ex)
        {
            System.out.println("Error: bad statement creation");
        }
    }
    
    public void close()
    {
        facade.close(con);
    }
    
     public void save(Employee e)
     {
        String query;
        query="INSERT INTO empleado VALUES ('" +
                e.getId() + "', '" +
                e.getPassword() +  "', '" +
                e.getNombre() + "', '"  +
                e.getCargo()  + "', "  +
                e.getSalario()  + ", '"  +
                e.getGenero() + "', '"  +
                e.getDireccion() + "', "  +
                e.getTelefono() + ", '"  +
                e.getEmail() + ")";
        try 
        {
            stm.executeUpdate(query);
        } 
        catch (SQLException ex) 
        {
            System.out.println("Error: cannot execute query");
        }
    }
     
     public ArrayList<Employee> search(String nombre){
        
        String query = "SELECT * FROM empleado WHERE nombre_emp LIKE '"+nombre+"';";
        ResultSet table;
        try 
        {
            table = stm.executeQuery(query);
            
            ArrayList<Employee> res = new ArrayList<Employee>();
        
            while(table.next())
            {
                Employee e = new Employee();
                e.setId(table.getString("id"));
                e.setPassword(table.getString("password"));
                e.setNombre(table.getString("nombre_emp"));
                e.setCargo(table.getString("cargo_emp"));
                e.setSalario(Double.parseDouble(table.getString("salario_emp")));
                e.setGenero(table.getString("genero_emp"));
                e.setDireccion(table.getString("dir_emp"));
                e.setTelefono(table.getString("tel_emp"));
                e.setEmail(table.getString("email_emp"));
                res.add(e);
            }
            
            return res;
        } 
        catch (SQLException ex)
        {
            System.out.println("Error: cannot execute query");
            return null;
        }
    }
    
    public void delete(String nombre)
    {
        String query = "DELETE FROM empleado WHERE nombre_emp = '"+nombre+"';";
        try 
        {
            stm.executeQuery(query);
        } 
        catch (SQLException ex) 
        {
            System.out.println("Error: cannot execute query");
        }
    }
    
    
    
    
}
