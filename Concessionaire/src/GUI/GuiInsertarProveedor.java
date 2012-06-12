/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author joedrovi
 */
public class GuiInsertarProveedor extends GuiFormProveedor implements ActionListener {
    public GuiInsertarProveedor() {
        super();
        setTitle("Insertar Proveedor");   
        
        btnRestaurar.addActionListener(this);
        btnAceptar.addActionListener(this);
      
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
            return;
        }
        
        if( controlador.existe(nit) ) {
            JOptionPane.showMessageDialog(this, "Este nit ya se encuentra registrado.", "Insertar proveedor - Error", JOptionPane.ERROR_MESSAGE);
            return;
        }       
        
        controlador.insertar(nit, razonSocial, telefono, direccion, email);
            
        JOptionPane.showMessageDialog(this, "Se ha almacenado un nuevo proveedor.", "Insertar proveedor", JOptionPane.INFORMATION_MESSAGE);
        return;        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if( e.getSource() == btnRestaurar ) {
            restaurar();
        }
        
        if( e.getSource() == btnAceptar ) {
            insertar();
            dispose();
        }
    }
}
