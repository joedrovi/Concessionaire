/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

/**
 *
 * @author Joedrovi
 */
import BusinessObject.Empleado;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoEmpleado extends Dao {    
    public DaoEmpleado() {
        super();
    }
    
    public boolean insertar(Empleado e) {
        abrirConexion();
        
        String query = "INSERT INTO empleado VALUES('" +
                        e.getId() + "', '" +
                        e.getPassword() +  "', '" +
                        e.getNombre() + "', '"  +
                        e.getCargo()  + "', "  +
                        e.getSalario()  + ", '"  +
                        e.getGenero() + "', '"  +
                        e.getDireccion() + "', "  +
                        e.getTelefono() + ", '"  +
                        e.getEmail() + ")";
        
        try {
            instruccion.executeUpdate(query);
            cerrarConexion();
            return true;
        } 
        catch (SQLException ex) {
            System.out.println(ex);
        }

        cerrarConexion();   
        return false;
    }
    
    public boolean modificar(Empleado e) {
        abrirConexion();
        
        String query = "UPDATE empleado SET " +
                        "nombre_emp='" + e.getNombre() + "', " +
                        "cargo_emp='" + e.getCargo()  + "', "  +
                        "salario_emp=" + e.getSalario() + ", " +
                        "genero_emp='" + e.getGenero() + "', " +
                        "dir_emp='" + e.getDireccion() + "', " +
                        "tel_emp='" + e.getTelefono() + "', " +
                        "email_emp='" + e.getEmail() + "' WHERE id_emp LIKE " + e.getId();
        
        try {
            instruccion.executeUpdate(query);
            cerrarConexion();
            return true;
        } 
        catch (SQLException ex) {
            System.out.println(ex);
        }

        cerrarConexion();   
        return false;
    }
    public ArrayList<Empleado> listar() {
        abrirConexion();
        
        String query = "SELECT id_emp, nombre_emp, genero_emp, cargo_emp, salario_emp, dir_emp, tel_emp, email_emp FROM empleado";
        ArrayList<Empleado> resultado = new ArrayList<Empleado>();
        
        try {
            ResultSet tabla = instruccion.executeQuery(query);

            while(tabla.next()) {
                Empleado e = new Empleado();

                e.setId(tabla.getString("id_emp"));
                e.setNombre(tabla.getString("nombre_emp"));
                e.setCargo(tabla.getString("cargo_emp"));
                e.setSalario(tabla.getDouble("salario_emp"));
                e.setGenero(tabla.getString("genero_emp").charAt(0));
                e.setDireccion(tabla.getString("dir_emp"));
                e.setTelefono(tabla.getString("tel_emp"));
                e.setEmail(tabla.getString("email_emp"));

                resultado.add(e);
            }
        }
        catch (SQLException ex) {
            System.out.println(ex);
        }

        cerrarConexion();         
        return resultado;
    }
    
    public ArrayList<Empleado> filtrar(int criterio, String palabraClave) {
        abrirConexion();
        
        String query = "SELECT id_emp, nombre_emp, genero_emp, cargo_emp, salario_emp, dir_emp, tel_emp, email_emp FROM empleado WHERE ";
        
        switch(criterio) {
            case 0:
                query += "id_emp LIKE '" + palabraClave + "'";
                break;
            
            case 1:
                query += "nom_emp LIKE '%" + palabraClave + "%'";
                break;
                
            case 2:
                query += "genero_emp LIKE '" + palabraClave + "%'";
                break;
                
            case 3:
                query += "cargo_emp LIKE %'" + palabraClave + "%'";
                break;
                
        }
        
        ArrayList<Empleado> resultado = new ArrayList<Empleado>();
        
        try {
            ResultSet tabla = instruccion.executeQuery(query);

            while(tabla.next()) {
                Empleado e = new Empleado();

                e.setId(tabla.getString("id_emp"));
                e.setNombre(tabla.getString("nombre_emp"));
                e.setCargo(tabla.getString("cargo_emp"));
                e.setSalario(tabla.getDouble("salario_emp"));
                e.setGenero(tabla.getString("genero_emp").charAt(0));
                e.setDireccion(tabla.getString("dir_emp"));
                e.setTelefono(tabla.getString("tel_emp"));
                e.setEmail(tabla.getString("email_emp"));

                resultado.add(e);
            }
        }
        catch (SQLException ex) {
            System.out.println(ex);
        }

        cerrarConexion();        
        return resultado;
    }
    
    public boolean eliminar(Empleado e) {
        abrirConexion();
        
        String query = "DELETE FROM empleado WHERE id_emp LIKE '" + e.getId() + "'";
      
        try {
            instruccion.executeUpdate(query);
            cerrarConexion();
            return true;
        }
        catch(SQLException ex) {
            System.out.println(ex);
        }

        cerrarConexion();
        return false;
    }
    
    public boolean existe(Empleado e) {
        abrirConexion();
        
        String query = "SELECT * FROM empleado WHERE id_serv LIKE '" + e.getId() + "'";
        
        try {
            ResultSet resultado = instruccion.executeQuery(query);
            
            if( resultado.next() ) {
                cerrarConexion();
                return true;
            }
        }
        catch(SQLException ex) {
            System.out.println(ex);
        }

        cerrarConexion();
        return false;
    }
}
