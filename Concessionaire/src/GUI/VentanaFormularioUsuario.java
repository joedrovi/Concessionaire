package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class VentanaFormularioUsuario extends JInternalFrame implements ActionListener {
    private Container contenedor;
    
    private JTextField txtIdentificacion;
    private JTextField txtNombre;
    private JTextField txtFechaNacimiento;
    private JTextField txtCiudad;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    
    private JComboBox jcbCargo;
    private JComboBox jcbEstadoCivil;
    
    private JButton btnAceptar;    
    
    public VentanaFormularioUsuario() {
        super("Usuario", false, true, false);
        
        contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());
        
        JPanel panelGlobal = new JPanel(new GridLayout(3,1,10,10));
        
        JPanel panel = new JPanel();   
        
        Border bordeTitulo = BorderFactory.createTitledBorder("Formulario de Usuario");
        Border bordeVacio  = BorderFactory.createEmptyBorder(20, 20, 20, 20);
        Border bordeCompuesto = BorderFactory.createCompoundBorder(bordeTitulo, bordeVacio);
        
        JPanel panelDatos = new JPanel(new GridLayout(8,1,10,10));
        panelDatos.setBorder(bordeCompuesto);
        
        panelDatos.add(new JLabel("Identificación", SwingConstants.RIGHT));
        
        txtIdentificacion = new JTextField();
        panelDatos.add(txtIdentificacion);
        
        panelDatos.add(new JLabel("Nombre", SwingConstants.RIGHT));
        
        txtNombre = new JTextField();
        panelDatos.add(txtNombre);
        
        panelDatos.add(new JLabel("Fecha de Nacimiento", SwingConstants.RIGHT));
        
        txtFechaNacimiento = new JTextField();
        panelDatos.add(txtFechaNacimiento);
        
        panelDatos.add(new JLabel("Estado Civil", SwingConstants.RIGHT));  
    
        jcbEstadoCivil = new JComboBox(new String[] {"Soltero", "Casado", "Viudo", "Unión Libre"});
        panelDatos.add(jcbEstadoCivil);
        
        panelDatos.add(new JLabel("Cargo", SwingConstants.RIGHT));        

        jcbCargo = new JComboBox(new String[] {"Gerente", "Jefe de Taller", "Vendedor"});
        panelDatos.add(jcbCargo);
        
        panelDatos.add(new JLabel("Ciudad", SwingConstants.RIGHT)); 
        
        txtCiudad = new JTextField();
        panelDatos.add(txtCiudad);
        
        panelDatos.add(new JLabel("Dirección", SwingConstants.RIGHT));  
        
        txtDireccion = new JTextField();
        panelDatos.add(txtDireccion);
        
        panelDatos.add(new JLabel("Teléfono", SwingConstants.RIGHT));  
        
        txtTelefono = new JTextField();
        panelDatos.add(txtTelefono);
        
        panel.add(panelDatos);
        panelGlobal.add(panel);
        
        JPanel panelBtn = new JPanel();
        
        btnAceptar = new JButton("Aceptar");
        panelBtn.add(btnAceptar);
        
        panelGlobal.add(panelBtn);        
        contenedor.add(panelGlobal, BorderLayout.PAGE_START);       
       
        setSize(400,500);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent event) {
        
    }
}
