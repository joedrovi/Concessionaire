package GUI;

import GUI.VentanaInforme;
import GUI.VentanaFormularioUsuario;
import GUI.VentanaCambioContrasenia;
import GUI.VentanaAdministracionUsuarios;
import GUI.VentanaAdministracionInventario;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaPrincipal extends JFrame implements ActionListener {
    private Container contenedor;
    
    private JMenuBar barraMenu;
    
    private JMenu menuUsuario;
    private JMenu menuAcciones;
    private JMenu menuAyuda;
    
    private JMenuItem itemCambiarUsuario;
    private JMenuItem itemCambiarContrasenia;
    private JMenuItem itemSalir;
    
    private JMenuItem itemAdministrarUsuario;    
    private JMenu menuGenerarInforme;
    private JMenuItem itemInformeSucursal;
    private JMenuItem itemInformeInventario;    
    private JMenuItem itemAdministrarInventario;
    
    private JMenuItem itemAdministrarOrdenTrabajo;
    private JMenuItem itemInformeTaller;
    
    private JMenuItem itemRealizarVenta;
    private JMenuItem itemRealizarCotizacion;
    private JMenuItem itemInformeVentas;
    
    private JMenuItem itemManual;
    private JMenuItem itemAcercaDe;
    
    public VentanaPrincipal(int idTipoUsuario, String nombreUsuario, String cargoUsuario) {
       super("DEF Enterprise Factory");
       
       contenedor = getContentPane();       
       contenedor.setLayout(new BorderLayout());
       
       barraMenu = new JMenuBar(); 
       configurarMenuUsuario();
       
       menuAcciones = new JMenu("Acciones");
       
       switch(idTipoUsuario) {
           case 0:
               configurarAccionesGerente();
               break;
               
           case 1:
               configurarAccionesJefeTaller();
               break;
               
           case 2:
               configurarAccionesVendedor();
               break;
       }
       
       barraMenu.add(menuAcciones);
       
       configurarMenuAyuda();
       setJMenuBar(barraMenu);
       
       mostarInformacionUsuario(nombreUsuario,cargoUsuario);
       
       VentanaCambioContrasenia vcc = new VentanaCambioContrasenia();
       VentanaFormularioUsuario vfu = new VentanaFormularioUsuario();
       VentanaInforme vi = new VentanaInforme();
       VentanaAdministracionInventario vai = new VentanaAdministracionInventario(); 
       VentanaAdministracionUsuarios vau = new VentanaAdministracionUsuarios();       
       contenedor.add(vai, BorderLayout.CENTER);

       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setSize(800,600);
       setLocationRelativeTo(null);
       setResizable(false);
       setVisible(true);      
    }
    
    private void configurarMenuUsuario() {
       menuUsuario = new JMenu("Usuario");
       
       itemCambiarUsuario = new JMenuItem("Cambiar Usuario");
       menuUsuario.add(itemCambiarUsuario);
       
       itemCambiarContrasenia = new JMenuItem("Cambiar Contraseña");
       menuUsuario.add(itemCambiarContrasenia);
       
       menuUsuario.addSeparator();
       
       itemSalir = new JMenuItem("Salir");
       menuUsuario.add(itemSalir);
       
       barraMenu.add(menuUsuario);
    }
    
    private void configurarAccionesGerente() {
       itemAdministrarUsuario = new JMenuItem("Administrar Usuarios");
       menuAcciones.add(itemAdministrarUsuario);
       
       menuGenerarInforme = new JMenu("Generar Informe");
       
       itemInformeSucursal = new JMenuItem("Informe de Sucursal");
       menuGenerarInforme.add(itemInformeSucursal);
       
       itemInformeInventario = new JMenuItem("Informe de Inventario");
       menuGenerarInforme.add(itemInformeInventario);
       
       menuAcciones.add(menuGenerarInforme);
       
       itemAdministrarInventario = new JMenuItem("Administrar Inventario");
       
       menuAcciones.add(itemAdministrarInventario);
    }
    
    private void configurarAccionesJefeTaller() {
       itemAdministrarOrdenTrabajo = new JMenuItem("Administrar Órdenes de Trabajo");
       menuAcciones.add(itemAdministrarOrdenTrabajo);
       
       itemInformeTaller = new JMenuItem("Informe de Taller");
       menuAcciones.add(itemInformeTaller);
    }
    
    private void configurarAccionesVendedor() {
       itemRealizarVenta = new JMenuItem("Realizar Venta");
       menuAcciones.add(itemRealizarVenta);
       
       itemRealizarCotizacion = new JMenuItem("Realizar Cotizacion");
       menuAcciones.add(itemRealizarCotizacion);
       
       itemInformeVentas = new JMenuItem("Informe de Ventas");
       menuAcciones.add(itemInformeVentas);
    }
    
    private void configurarMenuAyuda() {
       menuAyuda = new JMenu("Ayuda");
       
       itemManual = new JMenuItem("Manual");
       menuAyuda.add(itemManual);
       
       itemAcercaDe = new JMenuItem("Acerca de");
       menuAyuda.add(itemAcercaDe);
       
       barraMenu.add(menuAyuda);
    }
    
    private void mostarInformacionUsuario(String nombre, String cargo) {
        JPanel panel = new JPanel(new GridLayout(2,1));
        
        JLabel labelNombre = new JLabel(nombre, SwingConstants.RIGHT);
        panel.add(labelNombre);
        
        JLabel labelCargo = new JLabel(cargo, SwingConstants.RIGHT);
        panel.add(labelCargo);
        
        contenedor.add(panel, BorderLayout.PAGE_START);
    }
    
    public void actionPerformed(ActionEvent event) {
        
    }
    
    public static void main( String[] args ) {
        VentanaPrincipal vp = new VentanaPrincipal(2, "Pepe Perez", "Gerente");
    }
}
