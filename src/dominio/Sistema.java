package dominio;

public class Sistema {
	private String nombreDelSistema;
	private Usuario usuarios[];
	
	public Sistema(String nombreDelSistema, int cantidadDeUsuarios) {
		this.nombreDelSistema = nombreDelSistema;
		this.usuarios = new Usuario[cantidadDeUsuarios];
	}
	
	public boolean loguearUsuario (String usuario, String contraseña) {
		for(int i=0;i<usuarios.length;i++) {
			if(usuarios[i]!=null && usuarios[i].getUsuario().equals(usuario) && usuarios[i].getContrasenia().equals(contraseña)) {
				return true;
			}
		} return false;
	}

	public Usuario[] listarUsuarios() {
		Usuario aux;
		for(int i=1;i<usuarios.length;i++) {
			for(int j=0;j<usuarios.length-1;j++) {
				if(usuarios[j]!=null && usuarios[j+1]!=null && usuarios[j].getUsuario().compareTo(usuarios[j+1].getUsuario())>0) {
					aux=usuarios[j];
					usuarios[j]=usuarios[j+1];
					usuarios[j+1]=aux;
				}
			}
		}
		return usuarios;
	}
	
	public int calcularEdadPromedio() {
		int cant=0;
		int total=0;
		for(int i=0;i<usuarios.length;i++) {
			if(usuarios[i]!=null) {
				cant++;
				total+=usuarios[i].getEdad();
			}
		} 
		if(cant==0) {
			return 0;
		}
		int promedio=total/cant;
		return promedio;
	}
	
	
	public int calcularCantidadDeUsuariosMayores() {
		int cant=0;
		for(int i=0;i<usuarios.length;i++) {
			if(usuarios[i]!=null && usuarios[i].getEdad()>=18) {
				cant++;
			}
		} return cant;
	}
	
	
	public int calcularCantidadDeUsuariosMenores() {
		int cant=0;
		for(int i=0;i<usuarios.length;i++) {
			if(usuarios[i]!=null && usuarios[i].getEdad()<18) {
				cant++;
			}
		} return cant;
	}
	
	public boolean ingresarUusario(Usuario usuario) {
		for(int i=0;i<usuarios.length;i++) {
			if(usuarios[i]==null && !userRepetido(usuario.getUsuario())) {
				usuarios[i]=usuario;
				return true;
			}
		} return false;
	}
	
	public boolean userRepetido(String user) {
		for(int i=0;i<usuarios.length;i++) {
			if(usuarios[i]!=null && usuarios[i].getUsuario().equals(user)) {
				return true;
			}
		} return false;
	}

}
