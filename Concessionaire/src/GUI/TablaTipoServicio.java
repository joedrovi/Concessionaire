/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BusinessObject.TipoServicio;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author claito
 */
public class TablaTipoServicio extends JTable {
    private ModeloTabla modeloTabla;
    
    private Object[][] datos;
    private final String[] cabeceras = new String[] {"ID", "Descripción", "Duración", "Costo"};
     
    public TablaTipoServicio(ArrayList<TipoServicio> listaServicios) {
        if( listaServicios.isEmpty() ) {
            datos = new Object[0][0];
        }
        else {
            datos = new Object[listaServicios.size()][cabeceras.length];
            
            for( int i = 0 ; i < listaServicios.size() ; i++ ) {
                TipoServicio tp = listaServicios.get(i);

                datos[i][0] = tp.getId();
                datos[i][1] = tp.getDescripcion();
                datos[i][2] = tp.getDuracion();
                datos[i][3] = tp.getCosto();
            }
        }
        
        modeloTabla = new ModeloTabla(datos, cabeceras); 
        setModel(modeloTabla);
        
        getTableHeader().setReorderingAllowed(false);
    }
}
