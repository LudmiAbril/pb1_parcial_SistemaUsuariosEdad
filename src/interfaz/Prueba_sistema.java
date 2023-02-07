package interfaz;

import java.util.Scanner;

import dominio.Sistema;
import dominio.Usuario;

public class Prueba_sistema {

	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		Sistema actual=new Sistema("sistema",10);
		int opcion;
		
		do {
		System.out.println("seleccione la opcion que desea realizar:"
				+ "\n1 - Registrar usuario"
				+ "\n2 - Obtener estadisticas"
				+ "\n3 - Loguear usuario"
				+ "\n4 - Listar usuarios"
				+ "\n9 - salir");
		
		opcion=teclado.nextInt();
		
		switch(opcion) {
		case 1: registrarUsuario(teclado,actual);
			break;
			
		case 2: estadisticas(actual);
			break;
			
		case 3: loguearUsuario(teclado,actual);
			break;
			
		case 4: listarUsuarios(actual);
			break;
			
		case 9: System.out.println("adios!");
			break;
			
		default: System.out.println("opcion incorrecta");
			break;
		}
		
		
		}while(opcion!=9);
		
	}
	
	private static void listarUsuarios(Sistema actual) {
		Usuario[] users=actual.listarUsuarios();
		for(int i=0;i<users.length;i++){
			if(users[i]!=null) {
				System.out.println(users[i].toString());
			}
		}
	}
	
	private static void loguearUsuario(Scanner teclado, Sistema actual) {
		System.out.println("ingrese el usuario");
		String usuario=teclado.next();
		System.out.println("ingrese la contrasenia");
		String contra=teclado.next();
		if(actual.loguearUsuario(usuario, contra)) {
			System.out.println("se logueo el usuario");
		}else {
			System.out.println("error, usuario o contrasenia incorrecto");
		}
	}
	
	private static void estadisticas(Sistema actual) {
		System.out.println("usuarios mayores de 18: " + actual.calcularCantidadDeUsuariosMayores() +
				"\n usuarios menores de 18: " + actual.calcularCantidadDeUsuariosMenores() +
				"\n edad promedio de los usuarios del sistema: " + actual.calcularEdadPromedio());
	}
	
	private static void registrarUsuario(Scanner teclado,Sistema actual) {
		System.out.println("ingrese el usuario");
		String user=teclado.next();
		System.out.println("ingrese la contraseña, debe tener un minimo de 8 caracteres y almenos un numero");
		String contra=teclado.next();
		System.out.println("ingrese el nombre");
		String nombre=teclado.next();
		System.out.println("ingrese el apellido");
		String apellido=teclado.next();
		System.out.println("ingrese la edad");
		int edad=teclado.nextInt();
		System.out.println("ingrese el dni");
		int dni=teclado.nextInt();
		
		Usuario usuario=new Usuario(user,contra,nombre,apellido,dni,edad);
		while(!usuario.laContraseniaEsValida(contra)) {
			System.out.println("la contrasenia no es valida, recuerde que debe tener como minimo 8 caracteres y almenos un numero");
			usuario.setContrasenia(teclado.next());
		}
		if(actual.ingresarUusario(usuario)) {
			System.out.println("se registro el usuario");
		}else {
			System.out.println("no se pudo registrar el usuario");
		}
	}

}
