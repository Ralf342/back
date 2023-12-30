package mx.uv;
public class Donaciones {
    private String nombre;
    private String direccion;
    private String telefono;
    private String correo;
    private String img;

    
    public Donaciones(String nombre, String direccion, String telefono, String correo, String img) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.img = img;
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }

   
    
}
