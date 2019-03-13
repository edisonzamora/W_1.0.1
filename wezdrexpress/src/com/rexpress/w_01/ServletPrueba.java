package com.rexpress.w_01;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ServletPrueba implements Servlet {
	
	private static final Logger LOG=Logger.getLogger(ServletPrueba.class);
		
	@Override
	public void init(ServletConfig config) throws ServletException {
	try{
		
		EntityManagerFactory enf=Persistence.createEntityManagerFactory("Persistence-rexpres");
		EntityManager  em=enf.createEntityManager();
		
		}catch (PersistenceException e) {
			LOG.error(e.getMessage());		
		}
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return getServletConfig();
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
