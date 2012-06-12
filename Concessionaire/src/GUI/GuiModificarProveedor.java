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
public class GuiModificarProveedor extends GuiFormProveedor implements ActionListener {
    private String[] datos;
    
    public GuiModificarProveedor(String[] datos) {
        super();
        setTitle("Modificar Proveedor");   
        
        this.datos = datos;
        restaurar();
        
        txtNit.setEditable(false);
        
        btnRestaurar.addActionListener(this);
        btnAceptar.addActionListener(this);       
      
        setVisible(true);
    }
    
    private void restaurar() {        
        txtNit.setText(datos[0]);
        txtRazonSocial.setText(datos[1]);
        txtTelefono.setText(datos[2]);
        txtDireccion.setText(datos[3]);
        txtEmail.setText(datos[4]);
    }
    
    private void modificar() {
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
    public void actionPerformed(ActionEvent ae) {
        if( ae.getSource() == btnAceptar ) {
            modificar();
        }
        
        if( ae.getSource() == btnRestaurar) {
            restaurar();
        }
    }
}
