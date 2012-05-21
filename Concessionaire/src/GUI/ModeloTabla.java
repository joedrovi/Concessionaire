package GUI;

import java.util.*;
import javax.swing.table.*;

public class ModeloTabla extends DefaultTableModel {
    private boolean[] canEdit;
    
    public ModeloTabla(Object datos[][], String[] tituloColumnas) {
        super(datos, tituloColumnas);
        
        canEdit = new boolean[tituloColumnas.length];
        Arrays.fill(canEdit, false);
    }
    
    public boolean isCellEditable(int fila,int columna) {
	return canEdit[columna];
    }    
}
