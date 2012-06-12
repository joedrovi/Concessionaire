/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BusinessObject.Accesorio;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 *
 * @author joedrovi
 */
public class TablaAccesorio extends JTable {
    private ModeloTabla modeloTabla;
    
    private Object[][] datos;
    private final String[] cabeceras = new String[] {"Serail", "Tipo", "Descripcion", "Proveedor", "Costo"};
     
    public TablaAccesorio(ArrayList<Accesorio> listaAccesorios) {
        if( listaAccesorios.isEmpty() ) {
            datos = new Object[0][0];
        }
        else {
            datos = new Object[listaAccesorios.size()][cabeceras.length];
            
            for( int i = 0 ; i < listaAccesorios.size() ; i++ ) {
                Accesorio a = listaAccesorios.get(i);

                datos[i][0] = a.getSerial();
                datos[i][1] = a.getTipo();
                datos[i][2] = a.getDescripcion();
                datos[i][3] = a.getProveedor();
                datos[i][4] = a.getCosto();
            }
        }
        
        modeloTabla = new ModeloTabla(datos, cabeceras); 
        setModel(modeloTabla);
        
        getTableHeader().setReorderingAllowed(false);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
}
