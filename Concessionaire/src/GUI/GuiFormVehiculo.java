/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

//import Controlador.ControladorVehiculo;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author joedrovi
 */
public class GuiFormVehiculo extends JDialog {
    protected Container contenedor;
    
    protected JTextField txtChasis;
    protected JTextField txtMotor;
    protected JTextField txtColor;  
    protected JTextField txtSerie;
    protected JTextField txtMarca;
    protected JTextField txtAnioFab;
    protected JTextField txtAnioGar;
    protected JTextField txtCosto;
    protected JTextField txtCilindraje;
    
    protected JButton btnRestaurar;
    protected JButton btnAceptar;
    
    //protected ControladorVehiculo controlador;
    
    public GuiFormVehiculo() {
        setModal(true);
        
        //controlador = new ControladorVehiculo();
        
        contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());
        
        JPanel panelDatos = new JPanel(new GridLayout(9, 2, 10, 10));
        panelDatos.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 20));
        
        panelDatos.add(new JLabel("# Chasis", SwingConstants.RIGHT));
        
        txtChasis = new JTextField();
        txtChasis.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panelDatos.add(txtChasis);
        
        panelDatos.add(new JLabel("# Motor", SwingConstants.RIGHT));        
        
        txtMotor = new JTextField();
        txtMotor.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panelDatos.add(txtMotor);
        
        panelDatos.add(new JLabel("Color", SwingConstants.RIGHT));
        
        txtColor = new JTextField();
        txtColor.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panelDatos.add(txtColor);
        
        panelDatos.add(new JLabel("Serie", SwingConstants.RIGHT));
        
        txtSerie = new JTextField();
        txtSerie.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panelDatos.add(txtSerie);       
        
        panelDatos.add(new JLabel("Marca", SwingConstants.RIGHT));
        
        txtMarca = new JTextField();
        txtMarca.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panelDatos.add(txtMarca);
        
        panelDatos.add(new JLabel("Año Fabricacion", SwingConstants.RIGHT));
        
        txtAnioFab = new JTextField();
        txtAnioFab.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panelDatos.add(txtAnioFab);
        
        panelDatos.add(new JLabel("Año Garantia", SwingConstants.RIGHT));
        
        txtAnioGar = new JTextField();
        txtAnioGar.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panelDatos.add(txtAnioGar);
        
        panelDatos.add(new JLabel("Costo", SwingConstants.RIGHT));
        
        txtCosto = new JTextField();
        txtCosto.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panelDatos.add(txtCosto);
        
        panelDatos.add(new JLabel("Cilindraje", SwingConstants.RIGHT));
        
        txtCilindraje = new JTextField();
        txtCilindraje.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panelDatos.add(txtCilindraje);
        
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
