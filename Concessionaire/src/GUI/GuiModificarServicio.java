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
public class GuiModificarServicio extends GuiFormServicio implements ActionListener {
    private String[] datos;
    
    public GuiModificarServicio(String[] datos) {
        super();
        setTitle("Modificar servicio");   
        
        this.datos = datos;
        restaurar();
        
        txtId.setEditable(false);
        
        btnRestaurar.addActionListener(this);
        btnAceptar.addActionListener(this);       
      
        setVisible(true);
    }
    
    private void restaurar() {
        txtId.setText(datos[0]);
        txtDescripcion.setText(datos[1]);
        txtDuracion.setText(datos[2]);
        txtCosto.setText(datos[3]);
    }
    
    private void modificar() {
        String id = txtId.getText();
        String descripcion = txtDescripcion.getText();
        String cDuracion = txtDuracion.getText();
        String cCosto = txtCosto.getText();
        
        int duracion = 0;
        double costo = 0.0;
        
        if( descripcion.isEmpty() || cDuracion.isEmpty() || cCosto.isEmpty() ) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Modificar servicio - Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            duracion = Integer.parseInt(cDuracion);
            costo = Double.parseDouble(cCosto);
        }
        catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Los valores duracion y costo deben ser numéricos.", "Modificar servicio - Error", JOptionPane.ERROR_MESSAGE);
            return;
        } 
        
        if( controlador.modificar(id, descripcion, duracion, costo) ) {         
            JOptionPane.showMessageDialog(this, "Se ha modificado el servicio " + id + ".", "Modificar servicio", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            return;            
        }
       
        JOptionPane.showMessageDialog(this, "La operación ha sido abortada.", "Modificar servicio - Error", JOptionPane.ERROR_MESSAGE);
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
