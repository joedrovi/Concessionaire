package GUI;

import GUI.ModeloTabla;
import javax.swing.*;

public class TablaInventario extends JTable {
    private ModeloTabla modeloTabla;
    
    private Object[][] datos;
    
    public TablaInventario() {
        datos = new Object[][]{};
        
        modeloTabla = new ModeloTabla(datos, new String[] {"Código", "Nombre", "Tipo", "Cantidad"});
        setModel(modeloTabla);
        
        getTableHeader().setReorderingAllowed(false);
    }
}
