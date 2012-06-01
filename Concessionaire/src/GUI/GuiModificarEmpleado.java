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
public class GuiModificarEmpleado extends GuiFormEmpleado implements ActionListener {
    private String[] datos;
    
    public GuiModificarEmpleado(String[] datos) {
        super();
        setTitle("Modificar empleado");   
        
        this.datos = datos;
        restaurar();
        
        txtId.setEditable(false);
        txtContrasenia.setEditable(false);;
        
        btnRestaurar.addActionListener(this);
        btnAceptar.addActionListener(this);       
      
        setVisible(true);
    }
    
    private void restaurar() {
        txtId.setText(datos[0]);
        txtNombre.setText(datos[1]);   
        txtCargo.setText(datos[3]);
        txtSalario.setText(datos[4]);
        txtDireccion.setText(datos[5]);
        txtTelefono.setText(datos[6]);
        txtEmail.setText(datos[7]);
    
        jcbGenero.setSelectedItem(datos[2]);
    }
    
    private void modificar() {
        String id = txtId.getText();
        String nombre = txtNombre.getText();
        String cargo = txtCargo.getText();
        String cSalario = txtSalario.getText();
        String direccion = txtDireccion.getText();
        String telefono = txtTelefono.getText();
        String email = txtEmail.getText();
        
        char genero = (Character)jcbGenero.getSelectedItem();
        
        double salario = 0.0;
        
        if( nombre.isEmpty() || cargo.isEmpty() || cSalario.isEmpty() || direccion.isEmpty() || telefono.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Insertar empleado - Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            salario = Integer.parseInt(cSalario);
        }
        catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El salario debe ser numérico.", "Modificar empleado - Error", JOptionPane.ERROR_MESSAGE);
            return;
        }              
        
        if( controlador.existe(id) ) {
            JOptionPane.showMessageDialog(this, "Este id ya se encuentra registrado.", "Modificar empleado - Error", JOptionPane.ERROR_MESSAGE);
            return;
        }       
        
        if( controlador.modificar(id, nombre, telefono, email, cargo, direccion, genero, salario) ) {         
            JOptionPane.showMessageDialog(this, "Se ha modificado el empleado " + id + ".", "Modificar empleado", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            return;
        }
       
        JOptionPane.showMessageDialog(this, "La operación ha sido abortada.", "Modificar empleado - Error", JOptionPane.ERROR_MESSAGE);
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
