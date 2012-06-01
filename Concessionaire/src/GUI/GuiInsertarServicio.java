/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controlador.ControladorServicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author claito
 */
public class GuiInsertarServicio extends GuiFormServicio implements ActionListener {       
    public GuiInsertarServicio() {
        super();
        setTitle("Insertar servicio");   
        
        btnRestaurar.addActionListener(this);
        btnAceptar.addActionListener(this);
      
        setVisible(true);        
    }
    
    private void restaurar() {
        txtId.setText("");
        txtDescripcion.setText("");
        txtDuracion.setText("");
        txtCosto.setText("");
    }
    
    private void insertar() {
        String id = txtId.getText();
        String descripcion = txtDescripcion.getText();
        String cDuracion = txtDuracion.getText();
        String cCosto = txtCosto.getText();
        
        int duracion = 0;
        double costo = 0.0;
        
        if( id.isEmpty() || descripcion.isEmpty() || cDuracion.isEmpty() || cCosto.isEmpty() ) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Insertar servicio - Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            duracion = Integer.parseInt(cDuracion);
            costo = Double.parseDouble(cCosto);
        }
        catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Los valores duracion y costo deben ser numéricos.", "Insertar servicio - Error", JOptionPane.ERROR_MESSAGE);
            return;
        }              
        
        if( controlador.existe(id) ) {
            JOptionPane.showMessageDialog(this, "Este id ya se encuentra registrado.", "Insertar servicio - Error", JOptionPane.ERROR_MESSAGE);
            return;
        }       
        
        if( controlador.insertar(id, descripcion, duracion, costo) ) {         
            JOptionPane.showMessageDialog(this, "Se ha almacenado el servicio " + id + ".", "Insertar servicio", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            return;
        }
       
        JOptionPane.showMessageDialog(this, "La operación ha sido abortada.", "Insertar servicio - Error", JOptionPane.ERROR_MESSAGE);
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
