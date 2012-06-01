/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controlador.ControladorServicio;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author claito
 */
public class GuiFormServicio extends JDialog {
    protected Container contenedor;
    
    protected JTextField txtId;
    protected JTextField txtDescripcion;
    protected JTextField txtDuracion;
    protected JTextField txtCosto;
    
    protected JButton btnRestaurar;
    protected JButton btnAceptar;
    
    protected ControladorServicio controlador;
    
    public GuiFormServicio() {
        setModal(true);
        
        controlador = new ControladorServicio();
        
        contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());
        
        JPanel panelDatos = new JPanel(new GridLayout(4, 2, 10, 10));
        panelDatos.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 20));
        
        panelDatos.add(new JLabel("ID", SwingConstants.RIGHT));
        
        txtId = new JTextField();
        txtId.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panelDatos.add(txtId);
        
        panelDatos.add(new JLabel("Descripción", SwingConstants.RIGHT));
        
        txtDescripcion = new JTextField();
        txtDescripcion.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panelDatos.add(txtDescripcion);
        
        panelDatos.add(new JLabel("Duración", SwingConstants.RIGHT));        
        
        txtDuracion = new JTextField();
        txtDuracion.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panelDatos.add(txtDuracion);
        
        panelDatos.add(new JLabel("Costo", SwingConstants.RIGHT));        
        
        txtCosto = new JTextField();
        txtCosto.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panelDatos.add(txtCosto);
        
        contenedor.add(panelDatos, BorderLayout.CENTER);
        
        JPanel panelIntermedio = new JPanel();
        panelIntermedio.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        
        JPanel panelBtn = new JPanel(new GridLayout(1, 2, 10, 10));
        
        btnRestaurar = new JButton("Restaurar");
        panelBtn.add(btnRestaurar);
        
        btnAceptar = new JButton("Aceptar");
        panelBtn.add(btnAceptar);
        
        panelIntermedio.add(panelBtn);        
        contenedor.add(panelIntermedio, BorderLayout.PAGE_END);
        
        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        setDefaultLookAndFeelDecorated(true);
        
        setSize(350,280);
        setLocationRelativeTo(null);
        setResizable(false);
    }
}
