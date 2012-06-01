/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BusinessObject.Servicio;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 *
 * @author claito
 */
public class TablaServicio extends JTable {
    private ModeloTabla modeloTabla;
    
    private Object[][] datos;
    private final String[] cabeceras = new String[] {"ID", "Descripción", "Duración", "Costo"};
     
    public TablaServicio(ArrayList<Servicio> listaServicios) {
        if( listaServicios.isEmpty() ) {
            datos = new Object[0][0];
        }
        else {
            datos = new Object[listaServicios.size()][cabeceras.length];
            
            for( int i = 0 ; i < listaServicios.size() ; i++ ) {
                Servicio tp = listaServicios.get(i);

                datos[i][0] = tp.getId();
                datos[i][1] = tp.getDescripcion();
                datos[i][2] = tp.getDuracion();
                datos[i][3] = tp.getCosto();
            }
        }
        
        modeloTabla = new ModeloTabla(datos, cabeceras); 
        setModel(modeloTabla);
        
        getTableHeader().setReorderingAllowed(false);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
}
