/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;
import Fachada.BDFachada;
import java.sql.*;

/**
 *
 * @author Chavelo
 */
public class DaoInformes {
    
    private BDFachada fachada;
    private Connection conexion;
    private Statement instruccion;
    
    public DaoInformes(){
        fachada=new BDFachada();
    }
    
    private void abrirConexion(){
        conexion=fachada.abrirConexion();
        
        try{
            instruccion=conexion.createStatement();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    private void cierraConexion(){
        fachada.cerrarConexion(conexion);
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
