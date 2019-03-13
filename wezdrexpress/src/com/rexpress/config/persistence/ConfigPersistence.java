package com.rexpress.config.persistence;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConfigPersistence implements Servlet {
	private static final Logger LOG = Logger.getLogger(ConfigPersistence.class);
	
	@PersistenceUnit(unitName="peristence-rex")
	private static  EntityManagerFactory emf;

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		
		try {
			emf.createEntityManager();
			EntityManager em=emf.createEntityManager();
			LOG.info(">> Concction test correcta Persistencia");
		} catch (Exception he) {
			LOG.error(">>Ocurrió un error en la inicialización de la Persistence: " + he);
			throw new ExceptionInInitializerError(he);
		}
	}

	@Override
	public ServletConfig getServletConfig() { return getServletConfig(); }

	@Override
	public String getServletInfo() { return getServletInfo(); }

	@Override
	public void destroy() { }

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {	}

}
