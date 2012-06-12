/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessObject;

/**
 *
 * @author Chavelo
 */
public class Accesorio {
    private String serial;
    private String tipo;
    private String descripcion;
    private String proveedor;
    private double costo;
    
    public Accesorio() {
        serial = "";
        tipo = "";
        descripcion = "";
        proveedor = "";
        costo = 0.0;
    }

    public Accesorio(String serial, String tipo, String descripcion, String proveedor, double costo) {
        this.serial = serial;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.proveedor = proveedor;
        this.costo = costo;
    }    

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
