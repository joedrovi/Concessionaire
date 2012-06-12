/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

//import Controlador.ControladorAccesorio;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author claito
 */
public class GuiFormAccesorio extends JDialog {
    protected Container contenedor;
    
    protected JTextField txtSerial;
    protected JTextField txtTipo;    
    protected JTextField txtDescripcion;
    protected JTextField txtProveedor;
    protected JTextField txtCosto;
    
    protected JButton btnRestaurar;
    protected JButton btnAceptar;
    
    //protected ControladorAccesorio controlador;
    
    public GuiFormAccesorio() {
        setModal(true);
        
        //controlador = new ControladorAccesorio();
        
        contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());
        
        JPanel panelDatos = new JPanel(new GridLayout(5, 2, 10, 10));
        panelDatos.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 20));
        
        panelDatos.add(new JLabel("Serial", SwingConstants.RIGHT));
        
        txtSerial = new JTextField();
        txtSerial.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panelDatos.add(txtSerial);
        
        panelDatos.add(new JLabel("Tipo", SwingConstants.RIGHT));
        
        txtTipo = new JTextField();
        txtTipo.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panelDatos.add(txtTipo);
                
        panelDatos.add(new JLabel("Descripcion", SwingConstants.RIGHT));        
        
        txtDescripcion = new JTextField();
        txtDescripcion.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panelDatos.add(txtDescripcion);
        
        panelDatos.add(new JLabel("Proveedor", SwingConstants.RIGHT));
        
        txtProveedor = new JTextField();
        txtProveedor.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panelDatos.add(txtProveedor);
        
        panelDatos.add(new JLabel("Costo", SwingConstants.RIGHT));
        
        txtCosto = new JTextField();
        txtCosto.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panelDatos.add(txtCosto);
                
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
