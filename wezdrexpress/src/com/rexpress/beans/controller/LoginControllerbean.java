package com.rexpress.beans.controller;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import com.rexpress.beans.bean.LoginBean;
import com.rexpress.beans.bean.UserBean;
import com.rexpress.beans.constants.BeansName;
import com.rexssecurity.services.UsuaioService;

@Controller
@Component(BeansName.BEAN_LOGINCONTROLLERBEAN)
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class LoginControllerbean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private LoginBean login;

	@Autowired
	private UserBean userbean;

	@Autowired
	private UsuaioService usuService;
	
	private boolean allMesseng=false;

	public boolean isAllMesseng() {
		return allMesseng;
	}

	public void setAllMesseng(boolean allMesseng) {
		this.allMesseng = allMesseng;
	}

	private static final Logger logger = LogManager.getLogger(LoginControllerbean.class);

	private static final String LOGINVIEW = "loginView";

	private static final String HOMEVIEW = "homeView";

	public String aceptar() {

		logger.debug(">>>>>>>>loginContollerbean.aceptar()<<<<<<<<<<<");
		FacesContext ctx = FacesContext.getCurrentInstance();
		// comprovamos que no tenga espacio vacios o sin valor
		if (!isEnty(login)) {
			logger.debug(">>>>>>>>isEnty(login)==false<<<<<<<<<<<");
			userbean.setCorreo(remplazaEspacio(login.getCorreo()));
			userbean.setPassword(remplazaEspacio(login.getPassword()));
			logger.debug("----Correo= " + userbean.getCorreo());
			logger.debug("----Password= " + userbean.getPassword());
			// buscamos si el correo existe, sino existe informamos con un
			// warnig
			if (null != usuService.UsuarioByCorreo(userbean)) {
				// validamo si el pass del correo coinside con el ingresado
				if (login.getPassword().equals(userbean.getPassword())) {
					HttpSession session = (HttpSession) ctx.getExternalContext().getSession(false);
					session.setAttribute("usuario", userbean);
					// Connection con=bs.getConnection();
					return "security/" + HOMEVIEW + "?faces-redirect=true";
				} else {
					logger.debug("El password no corresponde a este correo");
					String msg = ctx.getApplication().getResourceBundle(ctx, "msg").getString("msg_err_usu_pass_no_coinside");
					ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "info",msg ));
					login.setCorreo("");
					login.setPassword("");
					return LOGINVIEW;
				}

			} else {
				logger.debug("Correo de usuario no encontrado");
				String msg = ctx.getApplication().getResourceBundle(ctx, "msg").getString("msg_err_usu_no_encontrado");
				ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "info", msg));
				login.setCorreo("");
				login.setPassword("");
				return LOGINVIEW;

			}
		} else {
			logger.debug("caracteres con espacio");
			String msg = ctx.getApplication().getResourceBundle(ctx, "msg").getString("msg_err_caracter");
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "error", msg));
			login.setCorreo("");
			login.setPassword("");
			return LOGINVIEW;
		}
	}

	public LoginBean getLogin() {
		return login;
	}

	public void setLogin(LoginBean login) {
		this.login = login;
	}

	private String remplazaEspacio(String valor) {
		String sinEspacio = valor.replace(" ", "");
		sinEspacio = sinEspacio.trim();
		return sinEspacio;
	}

	private boolean isEnty(LoginBean loginBean) {
		if (loginBean.getCorreo().equals("") || loginBean.getCorreo().equals(" ")) {
			return true;

		}
		if (loginBean.getPassword().equals("") || loginBean.getCorreo().equals(" ")) {
			return true;
		}

		return false;

	}
}