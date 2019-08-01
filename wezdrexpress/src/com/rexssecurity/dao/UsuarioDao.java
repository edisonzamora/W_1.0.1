package com.rexssecurity.dao;

import java.util.List;

import com.rexpress.beans.bean.UserBean;
import com.rexssecurity.entitys.Usuario;

//public interface UsuarioDao extends CrudDao{
public interface UsuarioDao{
	
public void crearUsuari(Usuario usuario) throws Exception;
public List<Usuario> userQueryCorreo(UserBean usuario);

public List<Usuario> usersQuery(String fitro ,String valor);

   

}
