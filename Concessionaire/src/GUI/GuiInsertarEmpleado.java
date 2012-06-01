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
 * @author claito
 */
public class GuiInsertarEmpleado extends GuiFormEmpleado implements ActionListener {
    public GuiInsertarEmpleado() {
        super();
        setTitle("Insertar empleado");   
        
        btnRestaurar.addActionListener(this);
        btnAceptar.addActionListener(this);
      
        setVisible(true);      
    }
    
    private void restaurar() {
        txtId.setText("");
        txtNombre.setText("");   
        txtCargo.setText("");
        txtSalario.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtEmail.setText("");
    
        txtContrasenia.setText("");
    
        jcbGenero.setSelectedIndex(0);
    }
    
    private void insertar() {
        String id = txtId.getText();
        String contrasenia = new String(txtContrasenia.getPassword());
        String nombre = txtNombre.getText();
        String cargo = txtCargo.getText();
        String cSalario = txtSalario.getText();
        String direccion = txtDireccion.getText();
        String telefono = txtTelefono.getText();
        String email = txtEmail.getText();
        
        char genero = (Character)jcbGenero.getSelectedItem();
        
        double salario = 0.0;
        
        if( id.isEmpty() || contrasenia.isEmpty() || nombre.isEmpty() || cargo.isEmpty() || cSalario.isEmpty() || direccion.isEmpty() || telefono.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Insertar empleado - Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            salario = Integer.parseInt(cSalario);
        }
        catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El salario debe ser numérico.", "Insertar empleado - Error", JOptionPane.ERROR_MESSAGE);
            return;
        }              
        
        if( controlador.existe(id) ) {
            JOptionPane.showMessageDialog(this, "Este id ya se encuentra registrado.", "Insertar empleado - Error", JOptionPane.ERROR_MESSAGE);
            return;
        }       
        
        if( controlador.insertar(id, contrasenia, nombre, telefono, email, cargo, direccion, genero, salario) ) {         
            JOptionPane.showMessageDialog(this, "Se ha almacenado el empleado " + id + ".", "Insertar empleado", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            return;
        }
       
        JOptionPane.showMessageDialog(this, "La operación ha sido abortada.", "Insertar empleado - Error", JOptionPane.ERROR_MESSAGE);
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
