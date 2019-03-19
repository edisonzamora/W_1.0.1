package com.rexpress.beans;

import java.io.Serializable;
import java.util.Locale;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.rexpress.w_01.ServletPrueba;
import com.rexseguridad.Role;
import com.rexseguridad.UsuaioService;
import com.rexseguridad.Usuario;


//@ManagedBean(name="loginContoller")
//@SessionScoped
@Controller
@Component("loginContollerbean")
@Scope("session")
public class LoginContollerbean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOG=Logger.getLogger(LoginContollerbean.class);
	//@ManagedProperty(value="#{loginBean}")
	@Autowired
	private LoginBean login;
	
	@Autowired
	private UsuaioService usuService;

	public String aceptar(){
		
		String d;
		Usuario usuario=new Usuario();
		Integer i=new Integer(1);
		usuario.setIdusuario(i);
		usuario.setNombre("camilo");
		usuario.setApellido("sexto");
		usuario.setCorreo("camilo@gmail.com");
		usuario.setPassword("camilosexto1234567");
		Integer f=new Integer(1);
		usuario.setActivo(f);
		usuario.setRole(Role.USU);
		
		try {
			usuService.crearUsuService(usuario);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOG.error(e.getMessage());
		
		}
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