package com.rexpress.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {

@Id
@Column(name="idusuario")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

@Column(name="nombre")
private String nombre;

@Column(name="apellido")
private String apellido;

@Column(name="correo")
private String correo;

@Column(name="password")
private String password;

@Column(name="activo")
private int activo;

@Column(name="tipo")
private String tipo;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
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

public int getActivo() {
	return activo;
}

public void setActivo(int activo) {
	this.activo = activo;
}

public String getTipo() {
	return tipo;
}

public void setTipo(String tipo) {
	this.tipo = tipo;
}
}
