/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BusinessObject.Proveedor;
import Controlador.ControladorProveedor;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author claito
 */
public class GuiAdminProveedor extends JInternalFrame implements ActionListener {
    private Container contenedor;
    private TablaProveedor tablaProveedor;
    
    private JButton btnInsertar;
    private JButton btnModificar;
    private JButton btnConsultar;
    private JButton btnEliminar;

    public GuiAdminProveedor() {
        super("Administrar Proveedores", false, true, false);
        JDialog.setDefaultLookAndFeelDecorated(true);
        
        contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());
        
        confTabla();
        confPanelBtn();

        setSize(500,500);
        setVisible(true);
    }
       
    private void confTabla() {
        ControladorProveedor controlador = new ControladorProveedor();
        ArrayList<Proveedor> listaProveedores = controlador.listar();
        
        tablaProveedor = new TablaProveedor(listaProveedores);
        JScrollPane scroll = new JScrollPane(tablaProveedor);
        
        contenedor.add(scroll, BorderLayout.CENTER);
    }
    
    private void confPanelBtn() {
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
    
    private boolean validarEliminacion() {
        int row = tablaProveedor.getSelectedRow();
        int col = tablaProveedor.getSelectedColumn();
            
        if( row == -1 && col == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un registro.", "Eliminar proveedor - Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if( tablaProveedor.getSelectedRowCount() != 1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar sólo un registro.", "Eliminar proveedor - Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }

    public void actionPerformed(ActionEvent e) {
        if( e.getSource() == btnInsertar ) {
            GuiFormProveedor formProveedor = new GuiFormProveedor();
        }
        
        if( e.getSource() == btnEliminar ) {
            if( validarEliminacion() ) {
                String nit = tablaProveedor.getValueAt(tablaProveedor.getSelectedRow(), 0).toString();
                String mynit = nit.trim();
                
                int opcion = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar el proveedor " + mynit + "?", "Eliminar proveedor", JOptionPane.OK_CANCEL_OPTION);
                
                if( opcion == JOptionPane.OK_OPTION ) {           
                    ControladorProveedor controlador = new ControladorProveedor();
                    controlador.eliminar(nit);
                    
                    JOptionPane.showMessageDialog(this, "El proveedor de nit " + mynit + " ha sido eliminado.", "Eliminar proveedor", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }
}
