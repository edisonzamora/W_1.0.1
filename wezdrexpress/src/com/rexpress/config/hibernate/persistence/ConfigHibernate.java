package com.rexpress.config.hibernate.persistence;

import java.io.IOException;

import javax.faces.context.FacesContext;
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
	
	private HttpSession session;

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		
		arg0.getServletContext().setAttribute("servlet", "valor servlet");
		LOG.info(">>>>>>>>>>>>>>>>>>> Inciado Hibernate Persistencia<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		try {
			this.sessionFactory = new Configuration().configure().buildSessionFactory();
		LOG.info(">>>>>>>>>>>>>>>>>>> Concction test correcta Hibernate Persistencia<<<<<<<<<<<<<");
			
//			FacesContext cxt = FacesContext.getCurrentInstance();
//			HttpSession session = (HttpSession) cxt.getExternalContext().getSession(false);
//			session.setAttribute("mensaje", "mensaje desde el contexto");
		
		} catch (HibernateException  he) {
			LOG.error("Ocurrió un error en la inicialización de la SessionFactory: " + he);
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
		try {
			sessionFactory.close();
			LOG.info("SessionFactory hibernate finalizate-->rexpress_d");
		} catch (HibernateException e) {
			// TODO: handle exception
			LOG.error(e.getMessage());
		}
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		HttpServletRequest httpServletRequest=(HttpServletRequest)req;
		this.session = httpServletRequest.getSession();
		session.setAttribute("value", "value");
	}

}
