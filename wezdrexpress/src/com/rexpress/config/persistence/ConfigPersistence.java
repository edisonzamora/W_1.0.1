package com.rexpress.config.persistence;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConfigPersistence implements Servlet {
	private static final Logger logger = LogManager.getLogger(ConfigPersistence.class);
	// @PersistenceUnit(unitName="peristence-rex")
	// private static EntityManagerFactory emf;
	// @PersistenceContext(unitName="peristence-rex")
	// private static EntityManager ent;

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		String s = new String();

		try {
			// Object o= ent.getDelegate();
			// //EntityManager em=emf.createEntityManager();
			// EntityManagerFactory
			// emf=Persistence.createEntityManagerFactory("peristence-rex");
			// EntityManager em=emf.createEntityManager();
			// LOG.info(">> Concction test correcta Persistencia");
		} catch (Exception he) {
			logger.error(">>Ocurrió un error en la inicialización de la Persistence: " + he);
		}
	}

	@Override
	public ServletConfig getServletConfig() {
		return getServletConfig();
	}

	@Override
	public String getServletInfo() {
		return getServletInfo();
	}

	@Override
	public void destroy() {
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	}

}
