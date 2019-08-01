package com.rexssecurity.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.rexpress.beans.bean.UserBean;
import com.rexpress.common.dao.CommonDaoImpl;
import com.rexssecurity.Role;
import com.rexssecurity.entitys.Usuario;

@Repository
public class UsuarioDaoImpl extends CommonDaoImpl<Usuario, Integer> implements UsuarioDao {

	private static final Logger logger = LogManager.getLogger(UsuarioDaoImpl.class);

	@Override
	public Class<Usuario> getDaoTypeClass() {
		// TODO Auto-generated method stub
		return Usuario.class;
	}

	@Override
	public void create(Usuario entity) {
		try {
		EntityManager ent = getEntityManager();
			ent.getTransaction().begin();
			ent.persist(entity);
			ent.getTransaction().commit();
			ent.close();
		} catch (Exception err) {
//			// if (logger.isDebugEnabled()) {
//			// logger.debug("Error code: "+err.getErrorCode());
//			// logger.debug("SQLState: "+err.getSQLState());
//			// if (err.getSQLException()!=null) {
//			// logger.debug("SQLException: "+err.getSQLException());
//			// }
//			// logger.debug("SQL: "+err.getSQL());
//			// }
		}

	}

	@Override
	public void crearUsuari(Usuario usuario) {
		try {
			Session sesion = getSession();

			Transaction tran = sesion.beginTransaction();
			sesion.save(usuario);
			tran.commit();
			sesion.close();

		} catch (Exception err) {

		}

	}

	@Override
	public List userQueryCorreo(UserBean usuariobean) {
		
	    List listaUsuarios=createNamedQuery("Usuario.findByCorreo").setParameter("correo", usuariobean.getCorreo()).getResultList();
		
	    return listaUsuarios;
	}

	@Override
	public List<Usuario> usersQuery(String fitro, String valor) {
		// TODO Auto-generated method stub
		List listaUsuarios=null;
		try{
	     listaUsuarios=createNamedQuery("Usuario.findByRole").setParameter("role",Role.USU).getResultList();
		}catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage().toString());
			return listaUsuarios=null;
		}
	    //List listaUsuarios=(List) createHQLQuery("SELECT * FROM test.usuario WHERE tipo=USU");

		return listaUsuarios;
	}

	
}
