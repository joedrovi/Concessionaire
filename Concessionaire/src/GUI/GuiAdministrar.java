/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author claito
 */
public class GuiAdministrar extends JInternalFrame {
    protected Container contenedor;
    protected Border borde;
    protected JButton btnInsertar;
    protected JButton btnModificar;
    protected JButton btnConsultar;
    protected JButton btnEliminar;
    protected JButton btnListar;
    
    protected JComboBox jcbCriterio;
    protected JTextArea txtPalabraClave;
    
    public GuiAdministrar() {
        super("", false, true, false);
        JDialog.setDefaultLookAndFeelDecorated(true);
        
        contenedor = this.getContentPane();
        contenedor.setLayout(new BorderLayout());
        
        setPanelBotones();
        
        setSize(500,500);
    }
    
    private void setPanelBotones() {
        JPanel panel = new JPanel(new BorderLayout());        
        JPanel panelBotones = new JPanel(new GridLayout(1, 4, 10, 10));
        
        btnInsertar = new JButton("Insertar");
        panelBotones.add(btnInsertar);
        
        btnConsultar = new JButton("Consultar");
        panelBotones.add(btnConsultar);
        
        btnModificar = new JButton("Modificar");
        panelBotones.add(btnModificar);
        
        btnEliminar = new JButton("Eliminar");
        panelBotones.add(btnEliminar);
        
        panel.add(panelBotones, BorderLayout.LINE_END);        
        contenedor.add(panel, BorderLayout.PAGE_END);
    }
    
    protected void crearBorde(String title) {
        Border bordeTitulo = BorderFactory.createTitledBorder(title);
        Border bordeVacio  = BorderFactory.createEmptyBorder(20, 20, 20, 20);
        
        borde = BorderFactory.createCompoundBorder(bordeTitulo, bordeVacio); 
    }
    
    protected boolean validarSeleccion(JTable tabla) {      
        int row = tabla.getSelectedRow();
        int col = tabla.getSelectedColumn();
        
        if( row == -1 && col == -1) {   
            JOptionPane.showMessageDialog(this, "Debe seleccionar un registro.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
}
