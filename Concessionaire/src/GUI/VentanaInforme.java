package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.icepdf.ri.common.*;

public class VentanaInforme extends JInternalFrame implements ActionListener {
    private Container contenedor;
    
    public VentanaInforme() {
        super("Informe", false, true, false);
        
        
        String filePath="C:/Users/Chavelo/Desktop/BD-DISENO2012.pdf";
        
        SwingController controlador=new SwingController();
        SwingViewBuilder construye=new SwingViewBuilder(controlador);
        JPanel ContieneVisualizador=construye.buildViewerPanel();
        
        this.getContentPane().add(ContieneVisualizador);
        
        controlador.openDocument(filePath);
        
        /*
        contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());
        
        JPanel mipanel = new JPanel(new BorderLayout());
        JPanel panelIcons = new JPanel(new GridLayout(1,2,10,10));
        
        panelIcons.add(new JLabel(new ImageIcon("Save.png"), SwingConstants.RIGHT));
        panelIcons.add(new JLabel(new ImageIcon("Print.png"), SwingConstants.RIGHT));
        
        mipanel.add(panelIcons, BorderLayout.AFTER_LINE_ENDS);
        contenedor.add(mipanel, BorderLayout.PAGE_START);
        
        JPanel panelPrueba = new JPanel();
        panelPrueba.add(new JLabel(new ImageIcon("Imagen1.png")));
        contenedor.add(panelPrueba, BorderLayout.CENTER);
        * 
        */
        
        setSize(400,500);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent event) {
        
    }
}