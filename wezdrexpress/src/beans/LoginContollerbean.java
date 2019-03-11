package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="loginContoller")
@SessionScoped
public class LoginContollerbean {
	
	@ManagedProperty(value="#{loginBean}")
	private LoginBean login;

	public String aceptar(){
		if(login!=null){
			
			if(!login.getCorreo().equals("") ||!login.getPassword().equals("")){
				
				return "homeView?faces-redirect=true";
			}
		}
		
		return "loginView";
		
	}

	public LoginBean getLogin() {
		return login;
	}

	public void setLogin(LoginBean login) {
		this.login = login;
	}
}