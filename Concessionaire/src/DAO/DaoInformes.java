/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Facade.DBFacade;
import java.sql.*;

/**
 *
 * @author Chavelo
 */
public class DaoInformes {
    
    private DBFacade fachada;
    private Connection conexion;
    private Statement instruccion;
    
    public DaoInformes(){
        fachada=new DBFacade();
    }
    
    private void abrirConexion(){
        conexion=fachada.open();
        
        try{
            instruccion=conexion.createStatement();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    private void cierraConexion(){
        fachada.close(conexion);
    }
    
    public ResultSet consulta(String query){
        abrirConexion();
        
        ResultSet resultados=null;
        try{
            resultados=instruccion.executeQuery(query);
        }catch(SQLException e){
            System.out.println(e);
        }
        
        cierraConexion();
        return resultados;
        
    }
}
