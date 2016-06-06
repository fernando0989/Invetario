package proyecto;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConexionBD {

    static String nombreDB="tienda";
    static String login ="root";
    static String password ="1234";
    static String url = "jdbc:mysql://localhost/" + nombreDB;
    Connection conexion = null;

    public ConexionBD() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            conexion=DriverManager.getConnection(url, login, password);
            if(conexion!=null){
                System.out.println("conexió exitosa");
            }
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Error en el driver"+ex.getMessage());
        } catch (Exception e) {
            System.out.println("Error "+e.getMessage());
        }

    }
     public Connection getConnection() {
        return conexion;
    }
     public void desconectar() {
        conexion = null;
    }
}
    

