package beans;

import java.io.Serializable;


import org.springframework.stereotype.Component;

//@ManagedBean(name="loginBean" , eager=true)
//@SessionScoped

@Component
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String correo;
	
	private String password;
	
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
