/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BusinessObject.Servicio;
import Controlador.ControladorServicio;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author claito
 */
public class GuiAdminServicio extends JInternalFrame implements ActionListener, WindowListener {
    private Container contenedor;
    private JButton btnInsertar;
    private JButton btnModificar;
    private JButton btnConsultar;
    private JButton btnEliminar;
    private JButton btnListar;
    
    private JComboBox jcbCriterio;
    private JTextArea txtPalabraClave;    
    
    private TablaServicio tablaServicio;
    
    private ControladorServicio controlador;
    
    private GuiInsertarServicio guiInsertar;
    private GuiModificarServicio guiModificar;
    
    public GuiAdminServicio() {
        super("Administrar Servicios", false, true, false);
        JDialog.setDefaultLookAndFeelDecorated(true);
        
        contenedor = this.getContentPane();
        contenedor.setLayout(new BorderLayout());
        
        controlador = new ControladorServicio();
        
        setPanelFormulario();
        setTabla();
        setPanelBotones();
        
        setSize(500,500);
        setVisible(true);
    }
    
    private void setPanelFormulario() {
        JPanel panel = new JPanel();

        Border bordeTitulo = BorderFactory.createTitledBorder("Filtrar");
        Border bordeVacio  = BorderFactory.createEmptyBorder(20, 20, 20, 20);
        Border bordeCompuesto = BorderFactory.createCompoundBorder(bordeTitulo, bordeVacio);        
        
        panel.setBorder(bordeCompuesto);  
        
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
    
    private void setPanelBotones() {
        JPanel panel = new JPanel(new BorderLayout());        
        JPanel panelBotones = new JPanel(new GridLayout(1, 4, 10, 10));
        
        btnInsertar = new JButton("Insertar");
        btnInsertar.addActionListener(this);
        panelBotones.add(btnInsertar);
        
        btnConsultar = new JButton("Consultar");
        panelBotones.add(btnConsultar);
        
        btnModificar = new JButton("Modificar");
        btnModificar.addActionListener(this);
        panelBotones.add(btnModificar);
        
        btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(this);
        panelBotones.add(btnEliminar);
        
        panel.add(panelBotones, BorderLayout.LINE_END);        
        contenedor.add(panel, BorderLayout.PAGE_END);
    }
    
    private boolean validarSeleccion() {
        int row = tablaServicio.getSelectedRow();
        int col = tablaServicio.getSelectedColumn();
            
        if( row == -1 && col == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un registro.", "Eliminar proveedor - Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if( ae.getSource() == btnInsertar ) {
            guiInsertar = new GuiInsertarServicio();
            guiInsertar.addWindowListener(this);            
        }

        if( ae.getSource() == btnModificar ) {
            if( validarSeleccion() ) {
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
            if( validarSeleccion() ) {
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
        // Falta actualizar las tablitas
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
