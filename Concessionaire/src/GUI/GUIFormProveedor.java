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
public class GUIFormProveedor extends JDialog implements ActionListener {
    private Container contenedor;
    
    private JTextField txtNit;
    private JTextField txtRazonSocial;
    private JTextField txtTelefono;
    private JTextField txtDireccion;
    private JTextField txtEmail;
    
    private JButton btnAceptar;
    private JButton btnRestaurar;

    public GUIFormProveedor() {
        setTitle("Proveedor");
        setModal(true);
        
        contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());
        
        JPanel panelDatos = new JPanel(new GridLayout(6, 2, 10, 10));
        panelDatos.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 20));
        
        panelDatos.add(new JLabel("NIT", SwingConstants.RIGHT));
        
        txtNit = new JTextField();
        panelDatos.add(txtNit);
        
        panelDatos.add(new JLabel("Razón Social", SwingConstants.RIGHT));
        
        txtRazonSocial = new JTextField();
        panelDatos.add(txtRazonSocial);
        
        panelDatos.add(new JLabel("Teléfono", SwingConstants.RIGHT));
        
        txtTelefono = new JTextField();
        panelDatos.add(txtTelefono);
        
        panelDatos.add(new JLabel("Dirección", SwingConstants.RIGHT));
        
        txtDireccion = new JTextField();
        panelDatos.add(txtDireccion);
        
        panelDatos.add(new JLabel("E-mail", SwingConstants.RIGHT));
        
        txtEmail = new JTextField();
        panelDatos.add(txtEmail);
        
        contenedor.add(panelDatos, BorderLayout.CENTER);
        
        JPanel panelIntermedio = new JPanel();
        panelIntermedio.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        
        JPanel panelBtn = new JPanel(new GridLayout(1, 2, 10, 10));
        
        btnRestaurar = new JButton("Restaurar");
        btnRestaurar.addActionListener(this);
        panelBtn.add(btnRestaurar);
        
        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(this);
        panelBtn.add(btnAceptar);
        
        panelIntermedio.add(panelBtn);        
        contenedor.add(panelIntermedio, BorderLayout.PAGE_END);
        
        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        setDefaultLookAndFeelDecorated(true);
        
        setSize(350,300);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);    
    }    
    
    private void restaurar() {
        txtNit.setText("");
        txtRazonSocial.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        txtEmail.setText("");
    }
    
    private void insertar() {
        String nit = txtNit.getText();
        String razonSocial = txtRazonSocial.getText();
        String telefono = txtTelefono.getText();
        String direccion = txtDireccion.getText();
        String email = txtEmail.getText();
        
        if( nit.isEmpty() || razonSocial.isEmpty() || telefono.isEmpty() || direccion.isEmpty() || email.isEmpty() ) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Insertar proveedor - Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            ControladorProveedor controlador = new ControladorProveedor();
            controlador.insertar(nit, razonSocial, telefono, direccion, email);
            
            JOptionPane.showMessageDialog(this, "Se ha almacenado un nuevo proveedor", "Insertar proveedor", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }
    }
    
    public void actionPerformed(ActionEvent e) {
        if( e.getSource() == btnRestaurar ) {
            restaurar();
        }
        
        if( e.getSource() == btnAceptar ) {
           insertar();
        }
    }
}
