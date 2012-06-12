/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BusinessObject.Vehiculo;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 *
 * @author joedrovi
 */
public class TablaVehiculo extends JTable {
    private ModeloTabla modeloTabla;
    
    private Object[][] datos;
    private final String[] cabeceras = new String[] {"#Chasis", "#Motor", "Color", "#Serie", "Marca", "AñoFab.", "Año de Garant.", "Costo", "Cilindraje"};
     
    public TablaVehiculo(ArrayList<Vehiculo> listaVehiculos) {
        if( listaVehiculos.isEmpty() ) {
            datos = new Object[0][0];
        }
        else {
            datos = new Object[listaVehiculos.size()][cabeceras.length];
            
            for( int i = 0 ; i < listaVehiculos.size() ; i++ ) {
                Vehiculo e = listaVehiculos.get(i);

                datos[i][0] = e.getNumChasis();
                datos[i][1] = e.getNumMotor();
                datos[i][2] = e.getColor();
                datos[i][3] = e.getNumSerie();
                datos[i][4] = e.getMarca();
                datos[i][5] = e.getAnioFabricacion();
                datos[i][6] = e.getAnioGarantia();
                datos[i][7] = e.getCosto();
                datos[i][8] = e.getCilindraje();
            }
        }
        
        modeloTabla = new ModeloTabla(datos, cabeceras); 
        setModel(modeloTabla);
        
        getTableHeader().setReorderingAllowed(false);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
}
