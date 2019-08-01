package com.rexssecurity.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.rexpress.beans.bean.UserBean;
import com.rexpress.common.dao.CrudDao;
import com.rexpress.common.service.CrudServiceImp;
import com.rexssecurity.dao.UsuarioDao;
import com.rexssecurity.entitys.Usuario;

@Service("UsuarioService")
@Configurable
public class UsuarioServiceImp extends CrudServiceImp implements UsuaioService{
	
	@Autowired
	private UsuarioDao usuariodao;

	@Override
	protected CrudDao getCrudDao() {
		// TODO Auto-generated method stub
		return (CrudDao) usuariodao;
	}
	
	

	@Override
	public UserBean usuarioToUserbean(UserBean user, Usuario entity) {
		/*
		 * cambia la entidad a usuarioBean
		 * */
		user.setIdusuario(entity.getIdusuario());
		user.setNombre(entity.getNombre());
		user.setApellido(entity.getApellido());
		user.setCorreo(entity.getCorreo());
		user.setPassword(entity.getPassword());
		user.setActivo(entity.getActivo());
		user.setRole(entity.getRole());
		return user;
	}

	@Override
	public Usuario userBeanToUsuario(Usuario entity, UserBean user) {
		/*
		 * cambia de userBean a Entity
		 * */
		entity.setIdusuario(user.getIdusuario());
		entity.setNombre(user.getNombre());
		entity.setApellido(user.getApellido());
		entity.setCorreo(user.getCorreo());
		entity.setPassword(user.getPassword());
		entity.setActivo(user.getActivo());
		entity.setRole(user.getRole());
		return entity;
	}



	@Override
	public UserBean UsuarioByCorreo(UserBean userBean) {
		List<Usuario>usuriosList=usuariodao.userQueryCorreo(userBean);
		if(!usuriosList.isEmpty()){
			if(usuriosList.size()==1){
				usuarioToUserbean(userBean,usuriosList.get(0));
				return userBean;
				
			}else{
				userBean=null;
				return userBean;
			}
		}
		userBean=null;
		return userBean;
		
	}

	@Override
	public ArrayList<UserBean> usuariosByTipo(String fitro, String valor) {
		// TODO Auto-generated method stub
		ArrayList<Usuario>usuarios=(ArrayList<Usuario>) usuariodao.usersQuery(fitro, valor);
		ArrayList<UserBean>usuariosbean=new ArrayList<>();
	    for (Usuario varia : usuarios) {
	    	UserBean user=new UserBean();
			usuarioToUserbean(user, varia);
			usuariosbean.add(usuarioToUserbean(user, varia));
		}
		return usuariosbean;
	}
}
