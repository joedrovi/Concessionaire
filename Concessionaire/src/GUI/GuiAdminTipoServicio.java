/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BusinessObject.TipoServicio;
import Controlador.ControladorTipoServicio;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author claito
 */
public class GuiAdminTipoServicio extends JInternalFrame implements ActionListener {
    private Container contenedor;
    private TablaTipoServicio tablaTipoServicio;
    
    private JButton btnInsertar;
    private JButton btnModificar;
    private JButton btnConsultar;
    private JButton btnEliminar;
    
    public GuiAdminTipoServicio() {
        super("Administrar Servicios", false, true, false);
        JDialog.setDefaultLookAndFeelDecorated(true);
        
        contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());
        
        confTabla();
        confPanelBtn();
        
        setSize(500,500);
        setVisible(true);
    }
    
    private void confTabla() {
        ControladorTipoServicio controlador = new ControladorTipoServicio();
        ArrayList<TipoServicio> listaServicios = controlador.listar();
        
        tablaTipoServicio = new TablaTipoServicio(listaServicios);
        JScrollPane scroll = new JScrollPane(tablaTipoServicio);
        
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
    
    public void actionPerformed(ActionEvent e) {
        if( e.getSource() == btnInsertar ) {
            GuiFormTipoServicio formTipoServicio = new GuiFormTipoServicio();
        }
    }
}
