/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.DaoInformes;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.sql.*;
import java.io.*;

/**
 *
 * @author Chavelo
 */
public class ControladorInformes {
    
    private DaoInformes daoInformes;
    
    public ControladorInformes(){
        daoInformes=new DaoInformes();
    }
    
    public String generaInformePersonalizados(String[] consultas){
        String filePath="";
        ResultSet resultados=null;
        
        for(int i=0;i<consultas.length;i++){
            
            
            
        }
        
        return filePath;
    }
    
    public String generaInformePredeterminado(){
        String filePath="";
        
        
        
        return filePath="";
    }
    
    
}
