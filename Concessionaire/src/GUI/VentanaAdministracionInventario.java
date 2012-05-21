package GUI;

import GUI.TablaInventario;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class VentanaAdministracionInventario extends JInternalFrame implements ActionListener {
    private Container contenedor;
    
    private JComboBox jcbCriterioBusqueda;
    private JTextField txtCriterioBusqueda;
    
    private JButton btnBuscar;
    private JButton btnNuevo;
    private JButton btnVer;
    private JButton btnModificar;
    private JButton btnEliminar;
    
    private TablaInventario tablaInventario;
    
    public VentanaAdministracionInventario() {
        super("Administrar Inventario", false, true, false);
        
        contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());
        
        configurarBusqueda();
        configurarTabla();
        configurarBotones();
                
        setSize(400,500);
        setVisible(true);
    }
    
    private void configurarBusqueda() {
        Border bordeTitulo = BorderFactory.createTitledBorder("Búsqueda");
        Border bordeVacio  = BorderFactory.createEmptyBorder(20, 20, 20, 20);
        Border bordeCompuesto = BorderFactory.createCompoundBorder(bordeTitulo, bordeVacio);
        
        BorderLayout layoutBusqueda = new BorderLayout();
        layoutBusqueda.setHgap(20);
        
        JPanel panelBuscar = new JPanel(layoutBusqueda);
        panelBuscar.setBorder(bordeCompuesto);
        
        jcbCriterioBusqueda = new JComboBox(new String[] {"Código", "Nombre", "Tipo"});
        panelBuscar.add(jcbCriterioBusqueda, BorderLayout.WEST);
        
        txtCriterioBusqueda = new JTextField();
        panelBuscar.add(txtCriterioBusqueda, BorderLayout.CENTER);
        
        btnBuscar = new JButton("Buscar");
        panelBuscar.add(btnBuscar, BorderLayout.EAST);
        
        contenedor.add(panelBuscar, BorderLayout.PAGE_START);
    }
    
    private void configurarTabla() {
        tablaInventario = new TablaInventario();
        
        JScrollPane scroll=new JScrollPane(tablaInventario);
	contenedor.add(scroll, BorderLayout.CENTER);
    }
    
    private void configurarBotones() {
        JPanel panel = new JPanel(new BorderLayout());        
        JPanel panelBotones = new JPanel(new GridLayout(1,4,10,10));
        
        btnNuevo = new JButton("Nuevo");
        panelBotones.add(btnNuevo);
        
        btnVer = new JButton("Ver");
        panelBotones.add(btnVer);
        
        btnModificar = new JButton("Modificar");
        panelBotones.add(btnModificar);
        
        btnEliminar = new JButton("Eliminar");
        panelBotones.add(btnEliminar);
        
        panel.add(panelBotones, BorderLayout.LINE_END);
        
        contenedor.add(panel, BorderLayout.PAGE_END);
    }
    
    public void actionPerformed(ActionEvent event) {
        
    }
}
