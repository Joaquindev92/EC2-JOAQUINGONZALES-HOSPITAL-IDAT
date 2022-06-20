package EC2.JOAQUINGONZALES.HOSPITALIDAT.dto;

public class UsuarioDTORequest {
	
	private String usuario;
	private String contraseña;
	
	
	
	public UsuarioDTORequest(String usuario, String contraseña) {
		super();
		this.usuario = usuario;
		this.contraseña = contraseña;
	}
	public UsuarioDTORequest() {
		super();
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	

}
