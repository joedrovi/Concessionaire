package GUI;

import GUI.ModeloTabla;
import javax.swing.*;

public class TablaUsuario extends JTable {
    private ModeloTabla modeloTabla;
    
    private Object[][] datos;
    
    public TablaUsuario() {
        datos = new Object[][]{};        
        
        modeloTabla = new ModeloTabla(datos, new String[]{"Identificación", "Nombre", "Cargo"}); 
        setModel(modeloTabla);
        
        getTableHeader().setReorderingAllowed(false);
    }
}
