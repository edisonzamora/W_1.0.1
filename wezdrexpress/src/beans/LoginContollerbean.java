package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="LoginContollerbean")
@SessionScoped
public class LoginContollerbean {
	@ManagedProperty(value="#{loginBean}")
	private LoginBean login;

	public String loginController(){
		if(login!=null){
			
			if(!login.getCorreo().equals("") ||!login.getPassword().equals("")){
				
				return "homeView";
			}
		}
		
		return "loginView";
		
	}

}
