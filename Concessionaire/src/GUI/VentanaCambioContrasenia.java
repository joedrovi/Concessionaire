package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaCambioContrasenia extends JInternalFrame implements ActionListener {
    private Container contenedor;
    
    private JLabel labelError;
    
    private JPasswordField txtContraseniaActual;
    private JPasswordField txtNuevaContrasenia;
    private JPasswordField txtConfirmarContrasenia;
    
    private JButton btnAceptar;
    
    public VentanaCambioContrasenia() {
        super("Cambiar Contraseña", false, true, false);
        
        contenedor = getContentPane();        
        contenedor.setLayout(new BorderLayout());
        
        JPanel panelGlobal = new JPanel(new GridLayout(3,1,10,10));
        
        JPanel panel = new JPanel();
        JPanel panelDatos = new JPanel(new GridLayout(3,2,20,20));
        
        panelDatos.add(new JLabel("Contraseña Actual", SwingConstants.RIGHT));
        
        txtContraseniaActual = new JPasswordField();
        panelDatos.add(txtContraseniaActual);
        
        panelDatos.add(new JLabel("Nueva Contraseña", SwingConstants.RIGHT));
        
        txtNuevaContrasenia = new JPasswordField();
        panelDatos.add(txtNuevaContrasenia);
        
        panelDatos.add(new JLabel("Confirmar Nueva Contraseña", SwingConstants.RIGHT));
        
        txtConfirmarContrasenia = new JPasswordField();
        panelDatos.add(txtConfirmarContrasenia);
        
        panel.add(panelDatos);
        panelGlobal.add(panel);
        
        labelError = new JLabel("", SwingConstants.CENTER);       
        panelGlobal.add(labelError);

        JPanel panelBtn = new JPanel();
        
        btnAceptar = new JButton("Aceptar");
        panelBtn.add(btnAceptar);
        
        panelGlobal.add(panelBtn);
        contenedor.add(panelGlobal, BorderLayout.PAGE_END);       
       
        setSize(400,400);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent event) {
        
    }
}
