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
 * @author jeodrovi
 */
public class GuiInsertarCliente extends GuiFormCliente implements ActionListener {
    public GuiInsertarCliente() {
        super();
        setTitle("Insertar Cliente");   
        
        btnRestaurar.addActionListener(this);
        btnAceptar.addActionListener(this);
      
        setVisible(true);      
    }
    
    private void restaurar() {
        txtId.setText("");          
        txtTipoId.setText("");
        txtNombre.setText(""); 
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtEmail.setText("");    
    
        jcbGenero.setSelectedIndex(0);
    }
    
    private void insertar() {
        String id = txtId.getText();
        String nombre = txtNombre.getText();
        String tipoId = txtTipoId.getText();
        String direccion = txtDireccion.getText();
        String telefono = txtTelefono.getText();
        String email = txtEmail.getText();
        
        char genero = (Character)jcbGenero.getSelectedItem();
        
        if( id.isEmpty() || nombre.isEmpty() || tipoId.isEmpty() ||  direccion.isEmpty() || telefono.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Insertar Cliente - Error", JOptionPane.ERROR_MESSAGE);
            return;
        } 
        
        
       /* if( controlador.existe(id) ) {
            JOptionPane.showMessageDialog(this, "Este id ya se encuentra registrado.", "Insertar Cliente - Error", JOptionPane.ERROR_MESSAGE);
            return;
        }       
        
        if( controlador.insertar(id, tipoId, nombre, genero , direccion, telefono, email)) {         
            JOptionPane.showMessageDialog(this, "Se ha almacenado el cliente " + id + ".", "Insertar Cliente", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            return;
        }*/
       
        JOptionPane.showMessageDialog(this, "La operación ha sido abortada.", "Insertar Cliente - Error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if( ae.getSource() == btnRestaurar ) {
            restaurar();
        }
        
        if( ae.getSource() == btnAceptar ) {
           insertar();
        }
    }
}
