package beans;

import java.io.Serializable;
import java.util.Locale;

import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


//@ManagedBean(name="loginContoller")
//@SessionScoped
@Component("loginContollerbean")
@Scope("session")
public class LoginContollerbean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	//@ManagedProperty(value="#{loginBean}")
	@Autowired
	private LoginBean login;

	public String aceptar(){
		if(login!=null){
		FacesContext ctx=FacesContext.getCurrentInstance();
		Locale locale=ctx.getExternalContext().getRequestLocale();
		
			if(!login.getCorreo().equals("") && !login.getPassword().equals("")){
				
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