package mx.uv;


import static spark.Spark.*;
import java.util.HashMap;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Hello world!
 *
 */
public class App 
{
    static Gson gson = new Gson();
    static HashMap<String, Usuario> usuarios = new HashMap<>();

    public static void main(String[] args) {
        options("/*", (request, response) -> {

            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });

        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));

        post("/registro", (request, response) -> {
            response.type("application/json");
            String payload = request.body();
            Usuario usuario = gson.fromJson(payload, Usuario.class);
            System.out.println("payload " + payload);
            String respuesta = DAO.crearUsuario(usuario);

            return respuesta;
        });

        post("/validar", (request, response) -> {
            response.type("application/json");
            String payload = request.body();
            String mensaje = "";
            Usuario usuario = gson.fromJson(payload, Usuario.class);
            System.out.println("usuario " + usuario.getCorreo());
            boolean respuesta = DAO.usuarioRegistrado(usuario.getCorreo(), usuario.getContrasena());

            // JsonObject respuesta2 = new JsonObject();
            if (respuesta == true) {
                // respuesta2.addProperty("msj", "Información validada");
                System.out.println("Usuario correcto");
                mensaje = "Usuario correcto";
            } else {
                System.out.println("Usuario incorrecto");
                // respuesta2.addProperty("msj", "Información invalida");
                mensaje = "Usuario incorrecto";
            }
            return mensaje;
            // return null;
        });

        delete("/eliminarPerfil", (request, response) -> {
            response.type("application/json");
            String correo = request.queryParams("correo");
            System.out.println(correo);
            String mensaje = "";
            boolean respuesta = DAO.eliminarPersona(correo);

            if (respuesta == true) {
                mensaje = "Perfil Eliminado";
            } else {
                mensaje = "Error al Eliminar el Perfil";
            }
            return mensaje;
            // return null;
        });

        get("/modificarPerfil", (request, response) -> {
            response.type("application/json");
            String correo = request.queryParams("correo");
            String nombre = request.queryParams("nombre");
            String apellido = request.queryParams("apellidos");
            String telefono = request.queryParams("telefono");
            String tipoDeSangre = request.queryParams("tipoDeSangre");
            String enfermedades = request.queryParams("enfermedades");
            System.out.println(correo + nombre + apellido + telefono + tipoDeSangre + enfermedades);

            String mensaje = "";
            boolean respuesta = DAO.modificarPersona(correo,nombre,apellido,telefono,tipoDeSangre,enfermedades);
            
            if (respuesta == true) {
                mensaje = "Informacion Modificada";
            } else {
                mensaje = "Error al Modificar el Perfil";
            }
            return mensaje;
        });

        get("/donacionesPersonas", (request, response) -> {
            response.type("application/json");
            return gson.toJson(DAO.getDonacionesPersonas());
        });

        get("/donacionesHospitales", (request, response) -> {
            response.type("application/json");
            return gson.toJson(DAO.getDonacionesHospitales());
        });

        get("/donantes", (request, response) -> {
            response.type("application/json");
            return gson.toJson(DAO.getDonantes());
        });       

        get("/miPerfil", (request, response) -> {
            String correo = request.queryParams("correoDonante");
            response.type("application/json");
            return gson.toJson(DAO.getPersona(correo));
        });       

}
}