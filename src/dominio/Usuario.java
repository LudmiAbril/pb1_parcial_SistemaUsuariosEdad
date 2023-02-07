package dominio;

public class Usuario {
private String usuario;
private String contrasenia;
private String nombre;
private String apellido;
private int dni;
private int edad;

public Usuario(String usuario, String contrasenia, String nombre, String apellido, int dni, int edad) {
	this.usuario = usuario;
	this.contrasenia = contrasenia;
	this.nombre = nombre;
	this.apellido = apellido;
	this.dni = dni;
	this.edad = edad;
}


@Override
public String toString() {
	return "Usuario [usuario=" + usuario + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", edad="
			+ edad + "]";
}


public boolean esMayorDeEdad() {
	if(this.edad>=18) {
		return true;
	} return false;
}

public boolean laContraseniaEsValida(String contrasenia) {
	if(contrasenia.length()>=8 && tieneNum(contrasenia)) {
		return true;
	} return false;
}

public boolean tieneNum(String contra) {
	for(int i=0;i<contra.length();i++) {
		if(Character.isDigit(contra.charAt(i))) {
			return true;
		}
	} return false;
}

public String getUsuario() {
	return usuario;
}



public String getContrasenia() {
	return contrasenia;
}

public void setContrasenia(String contrasenia) {
	this.contrasenia = contrasenia;
}

public int getEdad() {
	return edad;
}


}
