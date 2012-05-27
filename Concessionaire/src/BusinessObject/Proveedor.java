/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessObject;

/**
 *
 * @author Chavelo
 */
public class Proveedor {
    private String nit;
    private String razonSocial;
    private String telefono;
    private String direccion;
    private String email;
    
    public Proveedor() {
        nit = "";
        razonSocial = "";
        telefono = "";
        direccion = "";
        email = "";
    }

    public Proveedor(String nit, String razonSocial, String telefono, String direccion, String email) {
        this.nit = nit;
        this.razonSocial = razonSocial;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
