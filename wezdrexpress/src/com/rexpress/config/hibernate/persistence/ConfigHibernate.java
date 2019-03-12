package com.rexpress.config.hibernate.persistence;

import java.io.IOException;

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

public class ConfigHibernate implements Servlet {
	private static final Logger LOG = Logger.getLogger(ConfigHibernate.class);
	private SessionFactory sessionFactory;
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		LOG.info(">>Inciado Hibernate Persistencia--> getSessionFactory()");
		try {
			this.sessionFactory = new Configuration().configure().buildSessionFactory();
			LOG.info(">> Inicializacion correcta Hibernate Persistencia--> getSessionFactory()");
		} catch (HibernateException he) {
			LOG.error("Ocurrió un error en la inicialización de la SessionFactory: " + he);
			throw new ExceptionInInitializerError(he);
		}
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return getServletConfig();
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return getServletInfo();
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		HttpSession session = ((HttpServletRequest) req).getSession();
		session.setAttribute("value", "value");

	}

}
