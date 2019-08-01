package com.rexssecurity.services;


import java.util.ArrayList;

import com.rexpress.beans.bean.UserBean;
import com.rexpress.common.service.CrudService;
import com.rexssecurity.entitys.Usuario;

public interface UsuaioService extends CrudService {
	public UserBean usuarioToUserbean ( UserBean user , Usuario entity );
	public Usuario userBeanToUsuario ( Usuario entity , UserBean user );
	public UserBean UsuarioByCorreo ( UserBean userBean );
	public ArrayList<UserBean> usuariosByTipo ( String fitro, String valor );
	
	
}
