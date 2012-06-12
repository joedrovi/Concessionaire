package DataAccessObject;

import Fachada.BDFachada;
import BusinessObject.Vehiculo;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Chavelo
 */
public class DaoVehiculo {
    private BDFachada fachada;
    private Connection con;
    private Statement stm;

    public DaoVehiculo() {
        fachada=new BDFachada();
    }
    
    public void open(){
        con=fachada.abrirConexion();
        try{
            stm=con.createStatement();
        }
        catch (SQLException ex){
            System.out.println("Error: bad statement creation");
        }
    }
    
    public void close(){
        fachada.cerrarConexion(con);
    }
    
    public void save(Vehiculo c){
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
    
    public ArrayList search(String marca){
        
        String querry="SELECT * FROM vehiculo WHERE marca LIKE"+marca+";";
        ResultSet table;
        try{
            table=stm.executeQuery(querry);
            
            ArrayList res=new ArrayList();
            
            System.out.println("Marca");
            
            while(table.next()){
                Vehiculo c=new Vehiculo();
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
