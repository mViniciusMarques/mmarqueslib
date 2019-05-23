package Utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class Uteis {
	
	final static Logger logger = Logger.getLogger(Uteis.class);
		
	public static EntityManager JpaEntityManager(){
		 
		FacesContext facesContext = FacesContext.getCurrentInstance();
 
		ExternalContext externalContext = facesContext.getExternalContext();
 
		HttpServletRequest request  = (HttpServletRequest)externalContext.getRequest();
 
		return (EntityManager)request.getAttribute("entityManager");
	} 

	//MOSTRAR MENSAGEM
	public static void Mensagem(String mensagem){
 
		FacesContext facesContext = FacesContext.getCurrentInstance();
		
		facesContext.addMessage(null, new FacesMessage("Alerta",mensagem));
	}
 
	//MOSTRAR MENSAGEM
	public static void MensagemAtencao(String mensagem){
 
		FacesContext facesContext = FacesContext.getCurrentInstance();
		
		logger.warn("Alerta : " + mensagem);
 
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção:", mensagem));
	}
 
	//MOSTRAR MENSAGEM
	public static void MensagemInfo(String mensagem){
 
		FacesContext facesContext = FacesContext.getCurrentInstance();
		
		logger.warn("Informativo : " + mensagem);
		
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", mensagem));
	}
	
	//MOSTRAR MENSAGEM
	public static void MensagemErro(String mensagem){
 
		FacesContext facesContext = FacesContext.getCurrentInstance();
		
		logger.warn("Erro : " + mensagem);
		
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", mensagem));
	}
}
