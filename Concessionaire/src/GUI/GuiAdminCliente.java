/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BusinessObject.Cliente;
//import Controlador.ControladorCliente;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author joedrovi
 */
public class GuiAdminCliente extends GuiAdministrar implements ActionListener, WindowListener {
    private TablaCliente tablaCliente;
    //private ControladorCliente controlador;
    private GuiInsertarCliente guiInsertar;
    private GuiModificarCliente guiModificar;
    
    public GuiAdminCliente() {
        super();
        setTitle("Administrar Clientes");
        
        btnInsertar.addActionListener(this);
        btnModificar.addActionListener(this);
        btnConsultar.addActionListener(this);
        btnEliminar.addActionListener(this);        
        
        //controlador = new ControladorCliente();
        
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
        
        jcbCriterio = new JComboBox(new String[]{"Id", "Nombre", "Genero"});
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
        //ArrayList<Cliente> listaClientes = controlador.listar();
        ArrayList<Cliente> listaClientes = new ArrayList();
                
        tablaCliente = new TablaCliente(listaClientes);
        JScrollPane scroll = new JScrollPane(tablaCliente);
        
        contenedor.add(scroll, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if( ae.getSource() == btnInsertar ) {
            guiInsertar = new GuiInsertarCliente();
            guiInsertar.addWindowListener(this);
        }
        
        if( ae.getSource() == btnModificar ) {
            if( validarSeleccion(tablaCliente) ) {
                int row = tablaCliente.getSelectedRow();

                String[] datos = new String[8];

                for( int col = 0 ; col < datos.length ; col++ ) {
                    datos[col] = tablaCliente.getValueAt(row, col).toString();
                }

                guiModificar = new GuiModificarCliente(datos);
                guiModificar.addWindowListener(this);
            }
        }
        
        /*if( ae.getSource() == btnEliminar ) {
            if( validarSeleccion(tablaCliente) ) {
                int row = tablaCliente.getSelectedRow();
                int col = 0;

                String id = tablaCliente.getValueAt(row, col).toString();

                int opcion = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar el Cliente " + id + "?", "Eliminar Cliente", JOptionPane.OK_CANCEL_OPTION);

                if( opcion == JOptionPane.OK_OPTION ) {
                    if( controlador.eliminar(id) )
                        JOptionPane.showMessageDialog(this, "El Cliente " + id + " ha sido eliminado.", "Eliminar Cliente", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        
        if( ae.getSource() == btnListar) {
            ArrayList<Cliente> listaClientes = controlador.listar();
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
