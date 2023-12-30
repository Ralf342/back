package mx.uv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static String url="jdbc:mysql://db4free.net:3306/sangre_segura";
    // public static String url="jdbc:mysql://localhost:3306/sangresegura";
    public static String Drivername="com.mysql.cj.jdbc.Driver";
    public static String username="rafavape";
    public static String password="12345678";

    private static Connection conexion=null;

    public static Connection getConnection(){
        try {
            Class.forName(Drivername);
            conexion = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println(" SQL:" + e);
        } catch (ClassNotFoundException e){
            System.out.println("Driver:" + e);
        }
        return conexion;
    }
}
