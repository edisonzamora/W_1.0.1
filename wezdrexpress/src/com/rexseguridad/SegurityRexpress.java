package com.rexseguridad;

import java.io.IOException;
import java.util.Enumeration;

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
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class SegurityRexpress implements Filter {
private  static Logger LOG=Logger.getLogger(SegurityRexpress.class);
	private ServletContext context;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.context= filterConfig.getServletContext();
		this.context.log("SegurityRexpress -->inicializate");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse) response;
	String tipo=	(String) req.getSession().getAttribute("usuario");
		if(tipo!=null) {
			 res.sendRedirect("/wezdrexpress/faces/view/homeView.xhtml");
		}else {
		String uri = req.getRequestURI();
		 LOG.debug("Requested Resource::URI:: " +uri);
		Enumeration<String> headers=req.getHeaderNames();
		 while (headers.hasMoreElements()) {
		      String key = headers.nextElement();
		     LOG.debug( key + "<-- " + req.getHeader(key ));
		    }
		 RequestDispatcher rsdpc=null;
//		 rsdpc = req.getRequestDispatcher("/wezdrexpress/faces/view/loginView.xhtml");  
//		 rsdpc.include(req, res);  
		 res.sendRedirect("/wezdrexpress/faces/view/loginView.xhtml");

//		
//		HttpSession session = req.getSession(false);
//		
//		chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
