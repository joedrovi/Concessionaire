/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessObject;

/**
 *
 * @author Chavelo
 */
public class Empleado {    
    private String id;
    private String password;
    private String nombre;
    private String cargo;
    private double salario;
    private char genero;
    private String direccion;
    private String telefono;
    private String email;   

    public Empleado() {
        id = "";
        password = "";
        nombre = "";
        telefono = "";
        email = "";
        cargo = "";
        direccion = "";
        genero = ' ';
        salario = 0.0;
    }

    public Empleado(String id, String password, String nombre, String telefono, String email, String cargo, String direccion, char genero, double salario) {
        this.id = id;
        this.password = password;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.cargo = cargo;
        this.direccion = direccion;
        this.genero = genero;
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
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

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }    
}
