package com.rexpress.beans.bean;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.rexpress.beans.constants.BeansName;

//@ManagedBean(name="loginBean" , eager=true)
//@SessionScoped

@Component(BeansName.BEAN_LOGINBEAN)
@Scope(value = WebApplicationContext.SCOPE_SESSION)
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
