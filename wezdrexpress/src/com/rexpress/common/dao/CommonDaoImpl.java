package com.rexpress.common.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.rexpress.beans.LoginContollerbean;

@Repository
public  abstract class CommonDaoImpl <ENTITY ,PK> extends CrudDaoImpl<ENTITY ,PK>{

	
	private static final Logger LOG=Logger.getLogger(CommonDaoImpl.class);

	

	private static final EntityManagerFactory emf;
	
//	@PersistenceContext(unitName = "rexpressPU")
	private static final EntityManager em;
	static {
		
		emf=Persistence.createEntityManagerFactory("rexpressPU");
		em=emf.createEntityManager();
		//SET GLOBAL time_zone = '-3:00';//
		
	}
	
	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}

	
}
