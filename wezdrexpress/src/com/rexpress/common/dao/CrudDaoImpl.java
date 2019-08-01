package com.rexpress.common.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public abstract class CrudDaoImpl<ENTITY, PK> implements CrudDao<ENTITY, PK>  {

	protected abstract EntityManager getEntityManager() ;
	
	public abstract Class<ENTITY> getDaoTypeClass();
	
	protected Session getSession() {
		return (Session) getEntityManager().getDelegate();
	}
	
	protected Query createNamedQuery(String name) {
		return getEntityManager().createNamedQuery(name);
	}

	protected Query createHQLQuery(String query) {
		return getEntityManager().createQuery(query);
	}

	protected Query createNativeQuery(String query) {
		return getEntityManager().createNativeQuery(query);
	}

}
