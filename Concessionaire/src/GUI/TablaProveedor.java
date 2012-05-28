/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BusinessObject.Proveedor;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author claito
 */
public class TablaProveedor extends JTable {
    private ModeloTabla modeloTabla;
    
    private Object[][] datos;
    private final String[] cabeceras = new String[] {"NIT", "Razón Social", "Teléfono", "Dirección", "E-mail"};
    
    public TablaProveedor(ArrayList<Proveedor> listaProveedores) {
        
        if( listaProveedores.isEmpty() ) {
            datos = new Object[0][0];
        }
        else {
            datos = new Object[listaProveedores.size()][cabeceras.length];
            
            for( int i = 0 ; i < listaProveedores.size() ; i++ ) {
                Proveedor p = listaProveedores.get(i);

                datos[i][0] = p.getNit();
                datos[i][1] = p.getRazonSocial();
                datos[i][2] = p.getTelefono();
                datos[i][3] = p.getDireccion();
                datos[i][4] = p.getEmail();
            }
        }        
        
        modeloTabla = new ModeloTabla(datos, cabeceras); 
        setModel(modeloTabla);
        
        getTableHeader().setReorderingAllowed(false);
    }
}
