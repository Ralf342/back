package mx.uv;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.nimbus.State;

import java.sql.*;

public class DAO {
    private static Conexion c = new Conexion();

    public static String crearUsuario(Usuario u) {
        PreparedStatement stm = null;
        Connection conn = null;
        String msj = "";

        conn = c.getConnection();
        try {
            String sql = "INSERT INTO persona (nombre,apellido,telefono,correo,contrasena) values (?,?,?,?,?)";
            stm = (PreparedStatement) conn.prepareStatement(sql);
            stm.setString(1, u.getNombre());
            stm.setString(2, u.getApellidos());
            stm.setString(3, u.getTelefono());
            stm.setString(4, u.getCorreo());
            stm.setString(5, u.getContrasena());
            if (stm.executeUpdate() > 0)
                msj = "usuario agregado";
            else
                msj = "usuario no agregado";

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
                stm = null;
            }
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return msj;
    }

    public static boolean eliminarPersona(String email) {
        boolean respuesta = false;
        Connection conn = c.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM persona WHERE correo='" + email + "';");
            if (ps.executeUpdate() > 0)
                respuesta = true;
            else
                respuesta = false;
        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return respuesta;
    }

    public static boolean modificarPersona(String email, String nombre, String apellido, String telefono,
            String tipoDeSangre, String enfermedades) {
        boolean respuesta = false;
        Connection conn = c.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE persona set nombre = '" + nombre + "', apellido = '" + apellido + "', telefono = '" + telefono + "', tipo_de_Sangre = '" + tipoDeSangre + "', enfermedades = '" + enfermedades + "' where correo = '" + email + "';");
            if (ps.executeUpdate() > 0)
                respuesta = true;
            else
                respuesta = false;
        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return respuesta;
    }

    public static boolean usuarioRegistrado(String email, String contrasena) {
        boolean respuesta = false;
        Connection conn = c.getConnection();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT Correo, Contrasena FROM persona WHERE Correo='" + email
                    + "' AND Contrasena='" + contrasena + "';");
            if (rs.next()) {
                respuesta = true;
            }
        } catch (Exception ex) {
            System.out.println("Error al iniciar sesion: " + ex.toString());
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return respuesta;
    }

    public static List<Donaciones> getDonacionesPersonas() {
        Connection conn = c.getConnection();
        ArrayList<Donaciones> donaciones = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM donaciones where Categoria = 'Persona';");
            while (rs.next()) {
                Donaciones donacion = new Donaciones(rs.getString("Nombre"), rs.getString("Direccion"),
                        rs.getString("Telefono"),
                        rs.getString("Correo"), rs.getString("Imagen"));
                donaciones.add(donacion);
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return donaciones;
    }

    public static List<Donaciones> getDonacionesHospitales() {
        Connection conn = c.getConnection();
        ArrayList<Donaciones> donaciones = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM donaciones where Categoria = 'Hospital';");
            while (rs.next()) {
                Donaciones donacion = new Donaciones(rs.getString("Nombre"), rs.getString("Direccion"),
                        rs.getString("Telefono"),
                        rs.getString("Correo"), rs.getString("Imagen"));
                donaciones.add(donacion);
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return donaciones;
    }

    public static List<Usuario> getDonantes() {
        Connection conn = c.getConnection();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM persona;");
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellidos(rs.getString("apellido"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setTipoDeSangre(rs.getString("tipo_de_sangre"));
                usuario.setEnfermedades(rs.getString("enfermedades"));
                usuarios.add(usuario);
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return usuarios;
    }

    public static Usuario getPersona(String correo) {
        Usuario persona = new Usuario();
        Connection conn = c.getConnection();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM persona where correo = '" + correo + "';");
            if (rs.next()) {
                persona.setNombre(rs.getString("nombre"));
                persona.setApellidos(rs.getString("apellido"));
                persona.setTelefono(rs.getString("telefono"));
                persona.setTipoDeSangre(rs.getString("tipo_de_sangre"));
                persona.setEnfermedades(rs.getString("enfermedades"));
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return persona;
    }

}
