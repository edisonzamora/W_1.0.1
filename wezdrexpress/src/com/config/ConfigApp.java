package com.config;

import java.util.Locale;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.rexpress.beans.constants.BeansName;

@Component(BeansName.BEAN_CONFIGAPP)
@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class ConfigApp {
	private final String ES="es";
	private  final String EN="en";

	//private String idiomaApp = getIdiomaNav();
	//private String idiomaApp;
	private Locale idioma;

	public Locale getIdioma() {
		FacesContext fc = FacesContext.getCurrentInstance();
//		if(this.getIdiomaApp().equals("")){
//			
//		}
//		String idioma_Application_Defaul=null;
//		if (getIdiomaNav(fc) == null) {
//		
//		}
//		if (getIdiomaDefault(fc) == null) {
//			
//		}
//		
//		String idioma_ExternalContext = fc.getExternalContext().getRequestLocale().getLanguage();
//		String idioma_ELContext = fc.getELContext().getLocale().getLanguage();
//		
//		switch (idiomaApp) {
//		case "es":
//			idioma = new Locale(idiomaApp, "ES");
//			break;
//		case "en":
//			idioma = new Locale(idiomaApp, "EN");
//			break;
//		}
		String idm=getIdiomaNav(fc);
		idioma=new Locale(idm);
		return idioma;
	}

//	public String getIdiomaApp() {
//		return idiomaApp;
//	}
//
//	public void setIdiomaApp(String idiomaApp) {
//		this.idiomaApp = idiomaApp;
//	}

	private String getIdiomaNav(FacesContext fct) {
		// TODO Auto-generated method stub
		String navIdiona = ((HttpServletRequest) fct.getExternalContext().getRequest()).getHeader("Accept-Language");
		String a=ES;
		String b="es-ES";
		String c="en-EN";
		String d=EN;
		int intIndex = navIdiona.indexOf(a);
		int intIndex2 = navIdiona.indexOf(b);
		int intIndex3 = navIdiona.indexOf(c);
		int intIndex4 = navIdiona.indexOf(d);
		if(intIndex==0 ||intIndex2==0 ){
		navIdiona=ES;
		}
		if(intIndex3==0 ||intIndex4==0 ){
			navIdiona=EN;
			}
		return navIdiona;
	}
	
	 private String getIdiomaDefault(FacesContext fct) {
		String idioma_Application_Defaul = fct.getApplication().getDefaultLocale().getLanguage();
		return idioma_Application_Defaul;
	}

	public void setIdioma(Locale idioma) {
		this.idioma = idioma;
	}
//	private ArrayList<String> getListIdiomas(String cadena){
//		
//	}

}
