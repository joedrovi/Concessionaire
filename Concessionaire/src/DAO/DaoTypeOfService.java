/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Joedrovi
 */

import BusinessObject.TypeOfService;
import Facade.DBFacade;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoTypeOfService 
{
    private DBFacade facade;
    private Connection con;
    private Statement stm;
    
    public DaoTypeOfService()
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
    
     public void save(TypeOfService t)
     {
        String query;
        query="INSERT INTO tipo_servicio VALUES ('" +
                t.getId() + "', " +
                t.getCosto() +  ", " +                 
                t.getDuracion() + ", '" +
                t.getDescripcion() + "')";
        try 
        {
            stm.executeUpdate(query);
        } 
        catch (SQLException ex) 
        {
            System.out.println("Error: cannot execute query");
        }
    }
     
     public ArrayList<TypeOfService> search(String id){
        
        String query = "SELECT * FROM tipo_servicio WHERE id_serv LIKE '"+id+"';";
        ResultSet table;
        try 
        {
            table = stm.executeQuery(query);
            
            ArrayList<TypeOfService> res = new ArrayList<TypeOfService>();
        
            while(table.next())
            {
                TypeOfService t = new TypeOfService();
                t.setId(table.getString("id_serv "));
                t.setDescripcion(table.getString("descripcion_serv"));                
                t.setCosto(Double.parseDouble(table.getString("costo_serv")));
                t.setDuracion(Integer.parseInt(table.getString("duracion_serv")));
                res.add(t);
            }
            
            return res;
        } 
        catch (SQLException ex)
        {
            System.out.println("Error: cannot execute query");
            return null;
        }
    }
    
    public void delete(String id)
    {
        String query = "DELETE FROM tipo_servicio WHERE id_serv = '"+id+"';";
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