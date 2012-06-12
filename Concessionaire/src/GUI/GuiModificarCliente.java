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
public class GuiModificarCliente extends GuiFormCliente implements ActionListener {
    private String[] datos;
    
    public GuiModificarCliente(String[] datos) {
        super();
        setTitle("Modificar Cliente");   
        
        this.datos = datos;
        restaurar();
        
        txtId.setEditable(false);
        
        btnRestaurar.addActionListener(this);
        btnAceptar.addActionListener(this);       
      
        setVisible(true);
    }
    
    private void restaurar() {
        txtId.setText(datos[0]);
        txtTipoId.setText(datos[1]);
        txtNombre.setText(datos[2]);  
        txtDireccion.setText(datos[4]);
        txtTelefono.setText(datos[5]);
        txtEmail.setText(datos[6]);
    
        jcbGenero.setSelectedItem(datos[3]);
    }
    
    private void modificar() {
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
       
       
        JOptionPane.showMessageDialog(this, "La operación ha sido abortada.", "Modificar Cliente - Error", JOptionPane.ERROR_MESSAGE);
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
