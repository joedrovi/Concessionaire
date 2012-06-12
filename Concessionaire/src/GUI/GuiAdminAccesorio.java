/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BusinessObject.Accesorio;
//import Controlador.ControladorAccesorio;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author joedrovi
 */
public class GuiAdminAccesorio extends GuiAdministrar implements ActionListener, WindowListener {
    private TablaAccesorio tablaAccesorio;
    //private ControladorAccesorio controlador;
    private GuiInsertarAccesorio guiInsertar;
    private GuiModificarAccesorio guiModificar;
    
    public GuiAdminAccesorio() {
        super();
        setTitle("Administrar Accesorios");
        
        btnInsertar.addActionListener(this);
        btnModificar.addActionListener(this);
        btnConsultar.addActionListener(this);
        btnEliminar.addActionListener(this);        
        
        //controlador = new ControladorAccesorio();
        
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
        
        jcbCriterio = new JComboBox(new String[]{"Serial", "Tipo", "Proveedor"});
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
        //ArrayList<Accesorio> listaAccesorios = controlador.listar();
        ArrayList<Accesorio> listaAccesorios = new ArrayList();
                
        tablaAccesorio = new TablaAccesorio(listaAccesorios);
        JScrollPane scroll = new JScrollPane(tablaAccesorio);
        
        contenedor.add(scroll, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if( ae.getSource() == btnInsertar ) {
            guiInsertar = new GuiInsertarAccesorio();
            guiInsertar.addWindowListener(this);
        }
        
        if( ae.getSource() == btnModificar ) {
            if( validarSeleccion(tablaAccesorio) ) {
                int row = tablaAccesorio.getSelectedRow();

                String[] datos = new String[8];

                for( int col = 0 ; col < datos.length ; col++ ) {
                    datos[col] = tablaAccesorio.getValueAt(row, col).toString();
                }

                guiModificar = new GuiModificarAccesorio(datos);
                guiModificar.addWindowListener(this);
            }
        }
        
        /*if( ae.getSource() == btnEliminar ) {
            if( validarSeleccion(tablaAccesorio) ) {
                int row = tablaAccesorio.getSelectedRow();
                int col = 0;

                String id = tablaAccesorio.getValueAt(row, col).toString();

                int opcion = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar el Accesorio " + id + "?", "Eliminar Accesorio", JOptionPane.OK_CANCEL_OPTION);

                if( opcion == JOptionPane.OK_OPTION ) {
                    if( controlador.eliminar(id) )
                        JOptionPane.showMessageDialog(this, "El Accesorio " + id + " ha sido eliminado.", "Eliminar Accesorio", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        
        if( ae.getSource() == btnListar) {
            ArrayList<Accesorio> listaAccesorios = controlador.listar();
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
