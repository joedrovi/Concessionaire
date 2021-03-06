/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BusinessObject.Servicio;
import Controlador.ControladorServicio;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author claito
 */
public class GuiAdminServicio extends GuiAdministrar implements ActionListener, WindowListener {
    private TablaServicio tablaServicio;    
    private ControladorServicio controlador;    
    private GuiInsertarServicio guiInsertar;
    private GuiModificarServicio guiModificar;
    
    public GuiAdminServicio() {
        super();
        setTitle("Administrar Servicios");
        
        btnInsertar.addActionListener(this);
        btnModificar.addActionListener(this);
        btnConsultar.addActionListener(this);
        btnEliminar.addActionListener(this);        
        
        controlador = new ControladorServicio();
        
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
        
        jcbCriterio = new JComboBox(new String[]{"ID", "Descripción"});
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
        ArrayList<Servicio> listaServicios = controlador.listar();
        
        tablaServicio = new TablaServicio(listaServicios);
        JScrollPane scroll = new JScrollPane(tablaServicio);
        
        contenedor.add(scroll, BorderLayout.CENTER);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if( ae.getSource() == btnInsertar ) {
            guiInsertar = new GuiInsertarServicio();
            guiInsertar.addWindowListener(this);            
        }

        if( ae.getSource() == btnModificar ) {
            if( validarSeleccion(tablaServicio) ) {
                int row = tablaServicio.getSelectedRow();

                String[] datos = new String[4];

                for( int col = 0 ; col < datos.length ; col++ ) {
                    datos[col] = tablaServicio.getValueAt(row, col).toString();
                }

                guiModificar = new GuiModificarServicio(datos);
                guiModificar.addWindowListener(this);  
            }
        }

        if( ae.getSource() == btnEliminar ) {
            if( validarSeleccion(tablaServicio) ) {
                int row = tablaServicio.getSelectedRow();
                int col = 0;

                String id = tablaServicio.getValueAt(row, col).toString();

                int opcion = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar el servicio " + id + "?", "Eliminar servicio", JOptionPane.OK_CANCEL_OPTION);

                if( opcion == JOptionPane.OK_OPTION ) {
                    if( controlador.eliminar(id) )
                        JOptionPane.showMessageDialog(this, "El servicio " + id + " ha sido eliminado.", "Eliminar servicio", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        
        if( ae.getSource() == btnListar) {
            ArrayList<Servicio> listaServicios = controlador.listar();
        }
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
