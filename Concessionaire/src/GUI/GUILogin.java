package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUILogin extends JFrame implements ActionListener {   
    private Container contenedor;
    
    private JTextField txtUsuario;
    private JPasswordField txtContrasenia;
    
    private JButton btnAceptar;
    
    public GUILogin() {     
        super("Inicio de Sesión");
        
        contenedor = getContentPane();        
        contenedor.setLayout(new BorderLayout());
        
        JPanel panelDatos = new JPanel(new GridLayout(2, 2, 10, 10));
        panelDatos.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 30));
        
        panelDatos.add(new JLabel("Usuario", SwingConstants.RIGHT));
        
        txtUsuario = new JTextField();
        panelDatos.add(txtUsuario);
        
        panelDatos.add(new JLabel("Contraseña", SwingConstants.RIGHT));
        
        txtContrasenia = new JPasswordField();
        panelDatos.add(txtContrasenia);
        
        contenedor.add(panelDatos, BorderLayout.CENTER);
        
        JPanel panelBtn = new JPanel();
        
        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(this);
        panelBtn.add(btnAceptar);
        
        contenedor.add(panelBtn, BorderLayout.PAGE_END);   
        
        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        setDefaultLookAndFeelDecorated(true);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(280,160);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    
    public boolean validarDatos() {
        String usuario = txtUsuario.getText();
        String contrasenia = txtContrasenia.getPassword().toString();
        
        return false;
    }  
    
    public void actionPerformed(ActionEvent e) {
        validarDatos();
    }
    
    public static void main(String[] args) {
        GUILogin vl = new GUILogin();
    }
}
