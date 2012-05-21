package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaLogin extends JFrame implements ActionListener {   
    private Container contenedor;
    
    private JTextField txtNombre;
    private JPasswordField txtContrasenia;
    
    private JButton btnAceptar;
    
    public VentanaLogin() {     
        super("Inicio de Sesión");
        
        contenedor = getContentPane();        
        contenedor.setLayout(new BorderLayout());
        
        JPanel panelDatos = new JPanel(new GridLayout(2,2,10,10));
        
        panelDatos.add(new JLabel("Nombre de Usuario", SwingConstants.RIGHT));
        
        txtNombre = new JTextField();
        panelDatos.add(txtNombre);
        
        panelDatos.add(new JLabel("Contraseña", SwingConstants.RIGHT));
        
        txtContrasenia = new JPasswordField();
        panelDatos.add(txtContrasenia);
        
        contenedor.add(panelDatos, BorderLayout.PAGE_START);
        
        JPanel panelBtn = new JPanel();
        
        btnAceptar = new JButton("Aceptar");
        panelBtn.add(btnAceptar);
        
        contenedor.add(panelBtn, BorderLayout.CENTER);        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,115);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent event) {
        
    }
    
    public static void main( String[] args ) {
        VentanaLogin vl = new VentanaLogin();
    }
}
