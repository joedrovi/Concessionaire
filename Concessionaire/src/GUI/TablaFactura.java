/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BusinessObject.Factura;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 *
 * @author joedrovi
 */
public class TablaFactura extends JTable {
    private ModeloTabla modeloTabla;
    
    private Object[][] datos;
    private final String[] cabeceras = new String[] {"Empleado", "Vehiculo", "Cliente", "TipoPago", "Fecha", "Costo"};
     
    public TablaFactura(ArrayList<Factura> listaFacturas) {
        if( listaFacturas.isEmpty() ) {
            datos = new Object[0][0];
        }
        else {
            datos = new Object[listaFacturas.size()][cabeceras.length];
            
            for( int i = 0 ; i < listaFacturas.size() ; i++ ) {
                Factura e = listaFacturas.get(i);

                datos[i][0] = e.getEmpleado().getNombre();
                datos[i][1] = e.getVehiculo().getNumChasis();
                datos[i][2] = e.getCliente().getNombre();
                datos[i][3] = e.getTipoDePago();
                datos[i][4] = e.getFecha();
                datos[i][5] = e.getCosto();
            }
        }
        
        modeloTabla = new ModeloTabla(datos, cabeceras); 
        setModel(modeloTabla);
        
        getTableHeader().setReorderingAllowed(false);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
}
