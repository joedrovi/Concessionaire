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
public class GuiModificarAccesorio extends GuiFormAccesorio implements ActionListener {
    private String[] datos;
    
    public GuiModificarAccesorio(String[] datos) {
        super();
        setTitle("Modificar Accesorio");   
        
        this.datos = datos;
        restaurar();
        
        txtSerial.setEditable(false);
        
        btnRestaurar.addActionListener(this);
        btnAceptar.addActionListener(this);       
      
        setVisible(true);
    }
    
    private void restaurar() {
        txtSerial.setText(datos[0]);
        txtTipo.setText(datos[1]);   
        txtDescripcion.setText(datos[3]);
        txtProveedor.setText(datos[4]);
        txtCosto.setText(datos[5]);
    }
    
    private void modificar() {
        String serial = txtSerial.getText();
        String tipo = txtTipo.getText();;
        String descripcion = txtDescripcion.getText();
        String proveedor = txtProveedor.getText();
        String costo = txtCosto.getText();
        double dcosto = 0.0;
        
        if( serial.isEmpty() || tipo.isEmpty() || descripcion.isEmpty() || proveedor.isEmpty() || costo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Insertar Accesorio - Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            dcosto = Integer.parseInt(costo);
        }
        catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El costo debe ser numérico.", "Insertar Accesorio - Error", JOptionPane.ERROR_MESSAGE);
            return;
        }              
        
        /*if( controlador.existe(serial) ) {
            JOptionPane.showMessageDialog(this, "Este serial ya se encuentra registrado.", "Insertar Accesorio - Error", JOptionPane.ERROR_MESSAGE);
            return;
        }       
        
        if( controlador.insertar(serial, tipo, descripcion, proveedor, costo) ) {         
            JOptionPane.showMessageDialog(this, "Se ha almacenado el Accesorio " + id + ".", "Insertar Accesorio", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            return;
        }*/
       
        JOptionPane.showMessageDialog(this, "La operación ha sido abortada.", "Modificar Accesorio - Error", JOptionPane.ERROR_MESSAGE);
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
