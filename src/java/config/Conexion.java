package config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexion {
     private static Connection con = null;
    private static String url = "jdbc:mysql://localhost:3306/bd_ventas";
    private static String usr = "root";
    private static String psw = "";

    public static Connection Conexion() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, usr, psw);
            System.out.println("Hay conexión!");
        } catch (ClassNotFoundException ex) {
            System.out.println("No hay Driver!!");
        } catch (SQLException ex) {
            System.out.println("Error con la BD ");
        }
        return con;
    }
}

