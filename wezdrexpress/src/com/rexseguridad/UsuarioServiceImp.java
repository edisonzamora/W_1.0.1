package com.rexseguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rexpress.common.dao.CrudDao;
import com.rexpress.common.service.CrudServiceImp;

@Service
public class UsuarioServiceImp extends CrudServiceImp implements UsuaioService{
	
	@Autowired
	private UsuarioDao usuario;

	@Override
	protected CrudDao getCrudDao() {
		// TODO Auto-generated method stub
		return (CrudDao) usuario;
	}

	@Override
	public void crearUsuService(Usuario usu) {
		// TODO Auto-generated method stub
		usuario.Cretaeuser(usu);
	}

	

}
