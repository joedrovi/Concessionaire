/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Joedrovi
 */

import BusinessObject.Provider;
import Facade.DBFacade;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DaoProvider 
{
    private DBFacade facade;
    private Connection con;
    private Statement stm;
    
    public DaoProvider()
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
    
     public void save(Provider p)
     {
        String query;
        query="INSERT INTO proveedor VALUES ('" +
                p.getNit() + "', '" +
                p.getRazonSocial() +  "', '" +                
                p.getTelefono() + ", '"  +
                p.getDireccion() + "', "  +
                p.getEmail() + ")";
        try 
        {
            stm.executeUpdate(query);
        } 
        catch (SQLException ex) 
        {
            System.out.println("Error: cannot execute query");
        }
    }
     
     public ArrayList<Provider> search(String nombre){
        
        String query = "SELECT * FROM proveedor WHERE razon_social_prov LIKE '"+nombre+"';";
        ResultSet table;
        try 
        {
            table = stm.executeQuery(query);
            
            ArrayList<Provider> res = new ArrayList<Provider>();
        
            while(table.next())
            {
                Provider p = new Provider();
                p.setNit(table.getString("nit_prov"));
                p.setRazonSocial(table.getString("razon_social_prov"));                
                p.setTelefono(table.getString("tel_prov"));
                p.setDireccion(table.getString("dir_prov"));
                p.setEmail(table.getString("email_prov"));
                res.add(p);
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
        String query = "DELETE FROM proveedor WHERE razon_social_prov = '"+nombre+"';";
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
