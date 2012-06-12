/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BusinessObject.Cliente;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 *
 * @author joedrovi
 */
public class TablaCliente extends JTable {
    private ModeloTabla modeloTabla;
    
    private Object[][] datos;
    private final String[] cabeceras = new String[] {"ID", "TipoID", "Nombre", "Genero", "Direccion", "Telefono", "Email"};
     
    public TablaCliente(ArrayList<Cliente> listaClientes) {
        if( listaClientes.isEmpty() ) {
            datos = new Object[0][0];
        }
        else {
            datos = new Object[listaClientes.size()][cabeceras.length];
            
            for( int i = 0 ; i < listaClientes.size() ; i++ ) {
                Cliente c = listaClientes.get(i);

                datos[i][0] = c.getId();
                datos[i][1] = c.getTipoId();
                datos[i][2] = c.getNombre();
                datos[i][3] = c.getGenero();
                datos[i][4] = c.getDireccion();
                datos[i][5] = c.getTelefono();
                datos[i][6] = c.getEmail();
            }
        }
        
        modeloTabla = new ModeloTabla(datos, cabeceras); 
        setModel(modeloTabla);
        
        getTableHeader().setReorderingAllowed(false);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
}
