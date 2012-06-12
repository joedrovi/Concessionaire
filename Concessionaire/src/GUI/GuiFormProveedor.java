/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controlador.ControladorProveedor;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author claito
 */
public class GuiFormProveedor extends JDialog {
    protected Container contenedor;
    
    protected JTextField txtNit;
    protected JTextField txtRazonSocial;
    protected JTextField txtTelefono;
    protected JTextField txtDireccion;
    protected JTextField txtEmail;
    
    protected JButton btnAceptar;
    protected JButton btnRestaurar;
    
    protected ControladorProveedor controlador;

    public GuiFormProveedor() {
        setTitle("Proveedor");
        setModal(true);
        
        controlador = new ControladorProveedor();
        
        contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());
        
        JPanel panelDatos = new JPanel(new GridLayout(5, 2, 10, 10));
        panelDatos.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 20));
        
        panelDatos.add(new JLabel("NIT", SwingConstants.RIGHT));
        
        txtNit = new JTextField();
        txtNit.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panelDatos.add(txtNit);
        
        panelDatos.add(new JLabel("Razón Social", SwingConstants.RIGHT));
        
        txtRazonSocial = new JTextField();
        txtRazonSocial.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panelDatos.add(txtRazonSocial);
        
        panelDatos.add(new JLabel("Teléfono", SwingConstants.RIGHT));
        
        txtTelefono = new JTextField();
        txtTelefono.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panelDatos.add(txtTelefono);
        
        panelDatos.add(new JLabel("Dirección", SwingConstants.RIGHT));
        
        txtDireccion = new JTextField();
        txtDireccion.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panelDatos.add(txtDireccion);
        
        panelDatos.add(new JLabel("E-mail", SwingConstants.RIGHT));
        
        txtEmail = new JTextField();
        txtEmail.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panelDatos.add(txtEmail);
        
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
        
        setSize(320,300);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);    
    }        
    
}
