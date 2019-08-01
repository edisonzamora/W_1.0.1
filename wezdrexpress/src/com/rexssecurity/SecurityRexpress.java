package com.rexssecurity;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.rexpress.beans.bean.LoginBean;
import com.rexpress.beans.bean.UserBean;
import com.rexpress.common.dao.CommonDaoImpl;

public class SecurityRexpress implements Filter {

	
	private static final Logger logger = LogManager.getLogger(SecurityRexpress.class);
	
	private ServletContext context;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.context = filterConfig.getServletContext();
		this.context.getContext("http://localhost:9090/wezdrexpress/");

		logger.debug("---------init Filter--------------");
		//logger.debug(this.context.getContext("http://localhost:9090/wezdrexpress/"));
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		UserBean user = (UserBean) req.getSession().getAttribute("usuario");
		if (user != null) {
			RequestDispatcher rsdpc = null;
			rsdpc = req.getRequestDispatcher("homeView.xhtml");
			rsdpc.forward(req, res);
		} else {
			String uri = req.getRequestURI();
			logger.debug("Requested Resource::URI:: " + uri);
			// Enumeration<String> headers = req.getHeaderNames();
			// while (headers.hasMoreElements()) {
			// String key = headers.nextElement();
			// LOG.debug(key + "<-- " + req.getHeader(key));
			// }
			res.sendRedirect("/wezdrexpress/faces/view/loginView.xhtml");
			// RequestDispatcher rsdpc = null;
			// rsdpc = req.getRequestDispatcher("homeView.xhtml");
			// rsdpc.forward(req, res);
		}
	}

	@Override
	public void destroy() {
		logger.debug("---------destroy Filter--------------");

	}

}
