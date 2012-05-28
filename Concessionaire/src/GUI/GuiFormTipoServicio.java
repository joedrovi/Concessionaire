/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controlador.ControladorTipoServicio;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author claito
 */
public class GuiFormTipoServicio extends JDialog implements ActionListener {
    private Container contenedor;
    
    private JTextField txtId;
    private JTextField txtDescripcion;
    private JTextField txtDuracion;
    private JTextField txtCosto;
    
    private JButton btnAceptar;
    private JButton btnRestaurar;
    
    private ControladorTipoServicio controlador;
    
    public GuiFormTipoServicio() {
        setTitle("Servicio");
        setModal(true);
        
        controlador = new ControladorTipoServicio();
        
        contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());
        
        JPanel panelDatos = new JPanel(new GridLayout(4, 2, 10, 10));
        panelDatos.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 20));
        
        panelDatos.add(new JLabel("ID", SwingConstants.RIGHT));
        
        txtId = new JTextField();
        txtId.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panelDatos.add(txtId);
        
        panelDatos.add(new JLabel("Descripción", SwingConstants.RIGHT));
        
        txtDescripcion = new JTextField();
        txtDescripcion.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panelDatos.add(txtDescripcion);
        
        panelDatos.add(new JLabel("Duración", SwingConstants.RIGHT));        
        
        txtDuracion = new JTextField();
        txtDuracion.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panelDatos.add(txtDuracion);
        
        panelDatos.add(new JLabel("Costo", SwingConstants.RIGHT));        
        
        txtCosto = new JTextField();
        txtCosto.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panelDatos.add(txtCosto);
        
        contenedor.add(panelDatos, BorderLayout.CENTER);
        
        JPanel panelIntermedio = new JPanel();
        panelIntermedio.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        
        JPanel panelBtn = new JPanel(new GridLayout(1, 2, 10, 10));
        
        btnRestaurar = new JButton("Restaurar");
        btnRestaurar.addActionListener(this);
        panelBtn.add(btnRestaurar);
        
        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(this);
        panelBtn.add(btnAceptar);
        
        panelIntermedio.add(panelBtn);        
        contenedor.add(panelIntermedio, BorderLayout.PAGE_END);
        
        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        setDefaultLookAndFeelDecorated(true);
        
        setSize(350,280);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    
    private void restaurar() {
        txtId.setText("");
        txtDescripcion.setText("");
        txtDuracion.setText("");
        txtCosto.setText("");
    }
    
    private boolean insertar() {
        String id = txtId.getText();
        String descripcion = txtDescripcion.getText();
        String cDuracion = txtDuracion.getText();
        String cCosto = txtCosto.getText();
        
        int duracion;
        double costo;
        
        if( id.isEmpty() || descripcion.isEmpty() || cDuracion.isEmpty() || cCosto.isEmpty() ) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Insertar servicio - Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        try {
            duracion = Integer.parseInt(cDuracion);
            costo = Double.parseDouble(cCosto);
        }
        catch(NumberFormatException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "Los campos duracion y costo son numéricos.", "Insertar servicio - Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }              
        
        if( controlador.existe(id) ) {
            JOptionPane.showMessageDialog(this, "Este id ya se encuentra registrado.", "Insertar servicio - Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }       
        
        controlador.insertar(id, descripcion, duracion, costo);
            
        JOptionPane.showMessageDialog(this, "Se ha almacenado un nuevo servicio.", "Insertar servicio", JOptionPane.INFORMATION_MESSAGE);
        return true;                
    }
    
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
