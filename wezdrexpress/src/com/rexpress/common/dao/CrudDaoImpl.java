package com.rexpress.common.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;

public abstract class CrudDaoImpl<ENTITY> {

	public abstract EntityManager getEntityManager();
	
	protected Session getSession() {
		
		return (Session) getEntityManager().getDelegate();
	}

	public abstract Class<ENTITY> getDaoTypeClass();
	
}
