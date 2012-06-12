/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

//import Controlador.ControladorCliente;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author joedrovi
 */
public class GuiFormCliente extends JDialog {
    protected Container contenedor;
    
    protected JTextField txtId;
    protected JTextField txtTipoId;
    protected JTextField txtNombre;  
    protected JTextField txtDireccion;
    protected JTextField txtTelefono;
    protected JTextField txtEmail;
    
    protected JComboBox jcbGenero;
    
    protected JButton btnRestaurar;
    protected JButton btnAceptar;
    
    //protected ControladorCliente controlador;
    
    public GuiFormCliente() {
        setModal(true);
        
        //controlador = new ControladorCliente();
        
        contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());
        
        JPanel panelDatos = new JPanel(new GridLayout(7, 2, 10, 10));
        panelDatos.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 20));
        
        panelDatos.add(new JLabel("ID", SwingConstants.RIGHT));
        
        txtId = new JTextField();
        txtId.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panelDatos.add(txtId);
        
        panelDatos.add(new JLabel("Tipo ID", SwingConstants.RIGHT));        
        
        txtTipoId = new JTextField();
        txtTipoId.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panelDatos.add(txtTipoId);
        
        panelDatos.add(new JLabel("Nombre", SwingConstants.RIGHT));
        
        txtNombre = new JTextField();
        txtNombre.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panelDatos.add(txtNombre);
        
        panelDatos.add(new JLabel("Género", SwingConstants.RIGHT));
        
        jcbGenero = new JComboBox(new String[]{"M", "F"});
        panelDatos.add(jcbGenero);      
        
        
        panelDatos.add(new JLabel("Dirección", SwingConstants.RIGHT));
        
        txtDireccion = new JTextField();
        txtDireccion.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panelDatos.add(txtDireccion);
        
        panelDatos.add(new JLabel("Teléfono", SwingConstants.RIGHT));
        
        txtTelefono = new JTextField();
        txtTelefono.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panelDatos.add(txtTelefono);
        
        panelDatos.add(new JLabel("E-mail", SwingConstants.RIGHT));
        
        txtEmail = new JTextField();
        txtEmail.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panelDatos.add(txtEmail);
        
        contenedor.add(panelDatos, BorderLayout.CENTER);
        
        JPanel panelIntermedio = new JPanel();
        panelIntermedio.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        
        JPanel panelBtn = new JPanel(new GridLayout(1, 2, 10, 10));
        
        btnRestaurar = new JButton("Restaurar");
        panelBtn.add(btnRestaurar);
        
        btnAceptar = new JButton("Aceptar");
        panelBtn.add(btnAceptar);
        
        panelIntermedio.add(panelBtn);        
        contenedor.add(panelIntermedio, BorderLayout.PAGE_END);
        
        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        setDefaultLookAndFeelDecorated(true);
        
        setSize(350,400);
        setLocationRelativeTo(null);
        setResizable(false);
    }
}
