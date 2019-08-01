package com.rexssecurity.entitys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.rexssecurity.Role;

@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.idusuario = :idusuario"),
		@NamedQuery(name = "Usuario.findByCorreo", query = "SELECT u FROM Usuario u WHERE u.correo = :correo"),
		@NamedQuery(name = "Usuario.findByRole", query = "SELECT u FROM Usuario u WHERE u.role = :role")

})
public class Usuario implements Serializable {

	private static final long serialVersionUID = -4447332669027234645L;

	@Id
	@Column(name = "idusuario" )
	private Integer idusuario;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "correo")
	private String correo;

	@Column(name = "password")
	private String password;

	@Column(name = "activo")
	private Integer activo;

	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private Role role;
	

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

	public Usuario() {
		super();
	}


	

	@Override
	public String toString() {
		return "Usuario [idusuario=" + idusuario + ", nombre=" + nombre + ", apellido=" + apellido + ", correo="
				+ correo + ", activo=" + activo + ", role=" + role + "]";
	}

	public Integer getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	

	
}
