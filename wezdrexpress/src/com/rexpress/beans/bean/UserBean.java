package com.rexpress.beans.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.rexpress.beans.constants.BeansName;
import com.rexssecurity.Role;


@Component("userbean")
@Scope(value = WebApplicationContext.SCOPE_APPLICATION)
public class UserBean {
	
	public UserBean(){}
	
	public UserBean(Integer idusuario, String nombre, String apellido, String correo, String password, Integer activo,
			Role role, String idioma) {
		this.idusuario = idusuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.password = password;
		this.activo = activo;
		this.role = role;
		this.idioma = idioma;
	}

	private Integer idusuario;

	private String nombre;

	private String apellido;

	private String correo;

	private String password;

	private Integer activo;

	private Role role;
	
	private String idioma;

	public Integer getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

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

	public Integer getActivo() {
		return activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
}
