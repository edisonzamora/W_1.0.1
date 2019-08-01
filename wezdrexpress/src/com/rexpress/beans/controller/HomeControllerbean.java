package com.rexpress.beans.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;

import com.rexpress.beans.bean.UserBean;
import com.rexpress.beans.constants.BeansName;
import com.rexssecurity.services.UsuaioService;

@Controller
@Component(BeansName.BEAN_HOMECONTROLLERBEAN)
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class HomeControllerbean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LogManager.getLogger(HomeControllerbean.class);
    
	@Autowired
	private UsuaioService usuService;
	
	private ArrayList<UserBean>listaUsuariosBean;
	
	private String closeSessio;
	
	private  final String HOMEVIEW = "homeView";
	
	
@PostConstruct
public void init(){
	closeSessio="1";
}
	
	public String getCloseSession() {
		
		return closeSessio;
	}

	public void setCloseSession(String closeSession) {
		this.closeSessio = closeSession;
	}

	
	public String cerrarSesion( HttpServletResponse res){
		
		try {
		res.sendRedirect("loginView");
	} catch (IOException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
		if(closeSessio.equals("1")){
			try{
			FacesContext ctx = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) ctx.getExternalContext().getSession(false);
			session.removeAttribute("usuario");
			return "loginView";
			}catch (Exception e) {
				// TODO: handle exception
				return "security/" + HOMEVIEW + "?faces-redirect=true";
			}
		}else{
			return "security/" + HOMEVIEW + "?faces-redirect=true";
			
		}
		
		
	}
	
	public ArrayList<UserBean> getListaUsuariosBean() {
		return listaUsuariosBean;
	}

	public void setListaUsuariosBean(ArrayList<UserBean> listaUsuariosBean) {
		this.listaUsuariosBean = listaUsuariosBean;
	}

}
