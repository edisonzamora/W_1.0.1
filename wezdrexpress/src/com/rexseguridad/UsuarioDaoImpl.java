package com.rexseguridad;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.hibernate.JDBCException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.rexpress.beans.LoginContollerbean;
import com.rexpress.common.dao.CommonDaoImpl;



@Repository
public class UsuarioDaoImpl extends CommonDaoImpl<Usuario, Integer>implements UsuarioDao{

	private static final Logger LOG=Logger.getLogger(UsuarioDaoImpl.class);

	@Override
	public Class<Usuario> getDaoTypeClass() {
		// TODO Auto-generated method stub
		return Usuario.class;
	}

	@Override
	public void create(Usuario entity) {
		try {
		getEntityManager().persist(entity);
	} catch (JDBCException err) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Error code: "+err.getErrorCode());
			LOG.debug("SQLState: "+err.getSQLState());
			if (err.getSQLException()!=null) {
				LOG.debug("SQLException: "+err.getSQLException());
			}
			LOG.debug("SQL: "+err.getSQL());
		}
	}
	}

	@Override
	public void Cretaeuser(Usuario usuario) {
		try {
		Session sesion=getSession();
		
		Transaction tran=sesion.beginTransaction();
		sesion.save(usuario);
	    tran.commit();
		sesion.close();
	
		} catch (JDBCException err   ) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("Error code: "+err.getErrorCode());
				LOG.debug("SQLState: "+err.getSQLState());
				if (err.getSQLException()!=null) {
					LOG.debug("SQLException: "+err.getSQLException());
				}
				LOG.debug("SQL: "+err.getSQL());
			}
		}
		
	}

	
/**
 * 
 * **/
}
