/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BusinessObject.Vehiculo;
//import Controlador.ControladorVehiculo;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author joedrovi
 */
public class GuiAdminVehiculo extends GuiAdministrar implements ActionListener, WindowListener {
    private TablaVehiculo tablaVehiculo;
    //private ControladorVehiculo controlador;
    private GuiInsertarVehiculo guiInsertar;
    private GuiModificarVehiculo guiModificar;
    
    public GuiAdminVehiculo() {
        super();
        setTitle("Administrar Vehiculos");
        
        btnInsertar.addActionListener(this);
        btnModificar.addActionListener(this);
        btnConsultar.addActionListener(this);
        btnEliminar.addActionListener(this);        
        
        //controlador = new ControladorVehiculo();
        
        setPanelFormulario();
        setTabla();
        
        setSize(500,500);
        setVisible(true);
    }
    
    private void setPanelFormulario() {
        JPanel panel = new JPanel();

        crearBorde("Filtrar");       
        panel.setBorder(borde);  
        
        BorderLayout layout = new BorderLayout();
        layout.setHgap(20);        
        
        panel.setLayout(layout);
        
        jcbCriterio = new JComboBox(new String[]{"#Chasis", "#Motor", "#Serie", "Marca", "AñoFab", "Cilindraje"});
        panel.add(jcbCriterio, BorderLayout.WEST);
        
        txtPalabraClave = new JTextArea();
        txtPalabraClave.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panel.add(txtPalabraClave, BorderLayout.CENTER);
        
        btnListar = new JButton("Listar");
        btnListar.addActionListener(this);
        panel.add(btnListar, BorderLayout.EAST);
        
        contenedor.add(panel, BorderLayout.PAGE_START);
    }
    
    private void setTabla() {
        //ArrayList<Vehiculo> listaVehiculos = controlador.listar();
        ArrayList<Vehiculo> listaVehiculos = new ArrayList();
                
        tablaVehiculo = new TablaVehiculo(listaVehiculos);
        JScrollPane scroll = new JScrollPane(tablaVehiculo);
        
        contenedor.add(scroll, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if( ae.getSource() == btnInsertar ) {
            guiInsertar = new GuiInsertarVehiculo();
            guiInsertar.addWindowListener(this);
        }
        
        if( ae.getSource() == btnModificar ) {
            if( validarSeleccion(tablaVehiculo) ) {
                int row = tablaVehiculo.getSelectedRow();

                String[] datos = new String[8];

                for( int col = 0 ; col < datos.length ; col++ ) {
                    datos[col] = tablaVehiculo.getValueAt(row, col).toString();
                }

                guiModificar = new GuiModificarVehiculo(datos);
                guiModificar.addWindowListener(this);
            }
        }
        
        /*if( ae.getSource() == btnEliminar ) {
            if( validarSeleccion(tablaVehiculo) ) {
                int row = tablaVehiculo.getSelectedRow();
                int col = 0;

                String id = tablaVehiculo.getValueAt(row, col).toString();

                int opcion = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar el Vehiculo " + id + "?", "Eliminar Vehiculo", JOptionPane.OK_CANCEL_OPTION);

                if( opcion == JOptionPane.OK_OPTION ) {
                    if( controlador.eliminar(id) )
                        JOptionPane.showMessageDialog(this, "El Vehiculo " + id + " ha sido eliminado.", "Eliminar Vehiculo", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        
        if( ae.getSource() == btnListar) {
            ArrayList<Vehiculo> listaVehiculos = controlador.listar();
        }*/
    }
    
    @Override
    public void windowOpened(WindowEvent we) {        
    }

    @Override
    public void windowClosing(WindowEvent we) {        
    }

    @Override
    public void windowClosed(WindowEvent we) {
    }

    @Override
    public void windowIconified(WindowEvent we) {        
    }

    @Override
    public void windowDeiconified(WindowEvent we) {        
    }

    @Override
    public void windowActivated(WindowEvent we) {       
    }

    @Override
    public void windowDeactivated(WindowEvent we) {        
    }    
}
