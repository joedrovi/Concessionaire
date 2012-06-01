/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BusinessObject.Empleado;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 *
 * @author claito
 */
public class TablaEmpleado extends JTable {
    private ModeloTabla modeloTabla;
    
    private Object[][] datos;
    private final String[] cabeceras = new String[] {"ID", "Nombre", "Género", "Cargo", "Salario", "Direcion", "Telefono", "E-mail"};
     
    public TablaEmpleado(ArrayList<Empleado> listaEmpleados) {
        if( listaEmpleados.isEmpty() ) {
            datos = new Object[0][0];
        }
        else {
            datos = new Object[listaEmpleados.size()][cabeceras.length];
            
            for( int i = 0 ; i < listaEmpleados.size() ; i++ ) {
                Empleado e = listaEmpleados.get(i);

                datos[i][0] = e.getId();
                datos[i][1] = e.getNombre();
                datos[i][2] = e.getGenero();
                datos[i][3] = e.getCargo();
                datos[i][4] = e.getSalario();
                datos[i][5] = e.getDireccion();
                datos[i][6] = e.getTelefono();
                datos[i][7] = e.getEmail();
            }
        }
        
        modeloTabla = new ModeloTabla(datos, cabeceras); 
        setModel(modeloTabla);
        
        getTableHeader().setReorderingAllowed(false);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
}
