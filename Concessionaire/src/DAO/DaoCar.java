package DAO;

import Facade.DBFacade;
import BusinessObject.Car;
import java.sql.*;
import java.util.LinkedList;

/**
 *
 * @author Chavelo
 */
public class DaoCar {
    private DBFacade facade;
    private Connection con;
    private Statement stm;

    public DaoCar() {
        facade=new DBFacade();
    }
    
    public void open(){
        con=facade.open();
        try{
            stm=con.createStatement();
        }
        catch (SQLException ex){
            System.out.println("Error: bad statement creation");
        }
    }
    
    public void close(){
        facade.close(con);
    }
    
    public void save(Car c){
        String querry;
        querry="INSERT INTO vehiculo VALUES ('"+
                c.getNumSerie()+"','"+
                c.getNumMotor()+"','"+
                c.getNumChasis()+"','"+
                c.getMarca()+"','"+
                c.getCosto()+"','"+
                c.getColor()+"','"+
                c.getAnioGarantia()+"','"+
                c.getAnioFabricacion()+")";
        try{
            stm.executeUpdate(querry);
        }catch(SQLException ex){
            System.out.println("Error: cannot execute querry");
        }
    }
    
    public LinkedList<Car> search(String marca){
        
        String querry="SELECT * FROM vehiculo WHERE marca LIKE"+marca+";";
        ResultSet table;
        try{
            table=stm.executeQuery(querry);
            
            LinkedList <Car> res=new LinkedList<Car>();
            
            System.out.println("Marca");
            
            while(table.next()){
                Car c=new Car();
                c.setNumSerie(table.getString("num_serie"));
                c.setNumMotor(table.getString("num_motor"));
                c.setNumChasis(table.getString("num_chasis"));
                c.setMarca(table.getString("marca"));
                c.setCosto(Integer.parseInt(table.getString("costo")));
                c.setColor(table.getString("color"));
                c.setCilindraje(Integer.parseInt(table.getString("cilindraje")));
                c.setAnioGarantia(table.getString("anio_garantia"));
                c.setAnioFabricacion(table.getString("anio_fabricacion"));
                res.add(c);
            }
            return res;
        }catch(SQLException ex)
        {
            System.out.println("Error: cannot execute querry");
            return null;
        }
    }
}
