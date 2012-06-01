/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BusinessObject.Empleado;
import Controlador.ControladorEmpleado;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author claito
 */
public class GuiAdminEmpleado extends GuiAdministrar implements ActionListener, WindowListener {
    private TablaEmpleado tablaEmpleado;
    private ControladorEmpleado controlador;
    private GuiInsertarEmpleado guiInsertar;
    private GuiModificarEmpleado guiModificar;
    
    public GuiAdminEmpleado() {
        super();
        setTitle("Administrar Empleados");
        
        btnInsertar.addActionListener(this);
        btnModificar.addActionListener(this);
        btnConsultar.addActionListener(this);
        btnEliminar.addActionListener(this);        
        
        controlador = new ControladorEmpleado();
        
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
        
        jcbCriterio = new JComboBox(new String[]{"ID", "Nombre", "Género", "Cargo"});
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
        ArrayList<Empleado> listaEmpleados = controlador.listar();
        
        tablaEmpleado = new TablaEmpleado(listaEmpleados);
        JScrollPane scroll = new JScrollPane(tablaEmpleado);
        
        contenedor.add(scroll, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if( ae.getSource() == btnInsertar ) {
            guiInsertar = new GuiInsertarEmpleado();
            guiInsertar.addWindowListener(this);
        }
        
        if( ae.getSource() == btnModificar ) {
            if( validarSeleccion(tablaEmpleado) ) {
                int row = tablaEmpleado.getSelectedRow();

                String[] datos = new String[8];

                for( int col = 0 ; col < datos.length ; col++ ) {
                    datos[col] = tablaEmpleado.getValueAt(row, col).toString();
                }

                guiModificar = new GuiModificarEmpleado(datos);
                guiModificar.addWindowListener(this);
            }
        }
        
        if( ae.getSource() == btnEliminar ) {
            if( validarSeleccion(tablaEmpleado) ) {
                int row = tablaEmpleado.getSelectedRow();
                int col = 0;

                String id = tablaEmpleado.getValueAt(row, col).toString();

                int opcion = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar el empleado " + id + "?", "Eliminar empleado", JOptionPane.OK_CANCEL_OPTION);

                if( opcion == JOptionPane.OK_OPTION ) {
                    if( controlador.eliminar(id) )
                        JOptionPane.showMessageDialog(this, "El empleado " + id + " ha sido eliminado.", "Eliminar empleado", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        
        if( ae.getSource() == btnListar) {
            ArrayList<Empleado> listaEmpleados = controlador.listar();
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
