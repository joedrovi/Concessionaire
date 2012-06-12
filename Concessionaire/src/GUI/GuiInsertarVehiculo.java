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
public class GuiInsertarVehiculo extends GuiFormVehiculo implements ActionListener {
    public GuiInsertarVehiculo() {
        super();
        setTitle("Insertar Vehiculo");   
        
        btnRestaurar.addActionListener(this);
        btnAceptar.addActionListener(this);
      
        setVisible(true);      
    }
    
    private void restaurar() {
        
        txtChasis.setText("");          
        txtMotor.setText("");
        txtColor.setText(""); 
        txtSerie.setText("");
        txtMarca.setText("");
        txtAnioFab.setText("");    
        txtAnioGar.setText("");  
        txtCosto.setText("");  
        txtCilindraje.setText("");        
    }
    
    private void insertar() {
        String chasis = txtChasis.getText();
        String motor = txtMotor.getText();
        String color = txtColor.getText();
        String serie = txtSerie.getText();
        String marca = txtMarca.getText();
        String anioFab = txtAnioFab.getText();
        String anioGar = txtAnioGar.getText();
        String costo = txtCosto.getText();
        String cilindraje = txtCilindraje.getText();
        
        double dCosto = 0.0;
        int iCilindraje = 0;
        
        if( chasis.isEmpty() || motor.isEmpty() || color.isEmpty() ||  serie.isEmpty() || marca.isEmpty() || anioFab.isEmpty() || anioGar.isEmpty() || costo.isEmpty() || cilindraje.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Insertar Vehiculo - Error", JOptionPane.ERROR_MESSAGE);
            return;
        }     
        
        try {
            dCosto = Double.parseDouble(costo);
        }
        catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El costo debe ser numérico.", "Insertar empleado - Error", JOptionPane.ERROR_MESSAGE);
            return;
        }  
        
         try {
            iCilindraje = Integer.parseInt(cilindraje);
        }
        catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El cilindraje debe ser numérico.", "Insertar empleado - Error", JOptionPane.ERROR_MESSAGE);
            return;
        } 
        
       /* if( controlador.existe(chasis) ) {
            JOptionPane.showMessageDialog(this, "Este chasis ya se encuentra registrado.", "Insertar Vehiculo - Error", JOptionPane.ERROR_MESSAGE);
            return;
        }       
        
        if( controlador.insertar(chasis, motor, color, serie , marca, anioFab, anioGar, dCosto, iCilindraje)) {         
            JOptionPane.showMessageDialog(this, "Se ha almacenado el Vehiculo " + chasis + ".", "Insertar Vehiculo", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            return;
        }*/
       
        JOptionPane.showMessageDialog(this, "La operación ha sido abortada.", "Insertar Vehiculo - Error", JOptionPane.ERROR_MESSAGE);
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
