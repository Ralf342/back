package mx.uv;

public class Usuario {
private String nombre;
private String apellidos;
private String telefono;
private String tipoDeSangre;
private String enfermedades;
private String correo;
private String contrasena;

public Usuario(String nombre, String apellidos, String telefono, String correo, String contrasena){
this.nombre=nombre;
this.apellidos=apellidos;
this.telefono=telefono;
this.correo=correo;
this.contrasena=contrasena;
}

public Usuario() {
}

//SETTERS
public void setNombre(String nombre){
    this.nombre=nombre;
}
public void setApellidos(String apellidos){
    this.apellidos=apellidos;
}
public void setCorreo(String correo){
    this.correo=correo;
}

public void setTelefono(String telefono) {
    this.telefono = telefono;
}

public void setContrasena(String contrasena){
    this.contrasena=contrasena;
}

//GETTERS
public String getNombre(){
    return nombre;
}
public String getApellidos(){
    return apellidos;
}
public String getCorreo(){
    return correo;
}

public String getContrasena(){
    return contrasena;
}

public String getTelefono() {
    return telefono;
}



public String getTipoDeSangre() {
    return tipoDeSangre;
}



public void setTipoDeSangre(String tipoDeSangre) {
    this.tipoDeSangre = tipoDeSangre;
}



public String getEnfermedades() {
    return enfermedades;
}



public void setEnfermedades(String enfermedades) {
    this.enfermedades = enfermedades;
}

@Override
public String toString() {
    return "Usuario [nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono + ", tipoDeSangre="
            + tipoDeSangre + ", enfermedades=" + enfermedades + ", correo=" + correo + ", contrasena=" + contrasena
            + "]";
}



}
