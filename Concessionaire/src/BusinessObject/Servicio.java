/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessObject;

/**
 *
 * @author claito
 */
public class Servicio {
    private String id;
    private String descripcion;
    private int duracion;
    private double costo;

    public Servicio() {
        id = "";
        descripcion = "";
        duracion = 0;
        costo = 0.0;
    }

    public Servicio(String id, String descripcion, int duracion, double costo) {
        this.id = id;
        this.descripcion = descripcion;
        this.duracion = duracion;
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

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }    
}
