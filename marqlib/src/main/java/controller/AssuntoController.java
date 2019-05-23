package controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;

import Utils.Uteis;
import model.AssuntoModel;
import model.PessoaModel;
import repository.AssuntoRepository;

@Named(value="assuntoController")
@RequestScoped
public class AssuntoController implements Serializable {

	private static final long serialVersionUID = 4240398861854579273L;
	
	private final static Logger logger = Logger.getLogger(Uteis.class);
	
	@Inject
	UsuarioController usuarioController;
	
	@Inject
	AssuntoRepository assuntoRepository;

	@Inject
	AssuntoModel assuntoModel;
	
	@Produces 
	private List<AssuntoModel> assuntos;
	
	public List<AssuntoModel> getAssuntos() {
		return assuntos;
	}

	public void setAssuntos(List<AssuntoModel> assuntos) {
		this.assuntos = assuntos;
	}

	public AssuntoModel getAssuntoModel() {
		return assuntoModel;
	}

	public void setAssuntoModel(AssuntoModel assuntoModel) {
		this.assuntoModel = assuntoModel;
	}
	
	public void salvarAssunto() {
		
		this.assuntoRepository.salvarAssunto(this.assuntoModel);
		logger.info("Registro cadastrado por " + this.usuarioController.GetUsuarioSession());
		Uteis.MensagemInfo("Registro cadastrado com sucesso");
	}
	
	@PostConstruct
	public void init() {
		this.assuntos = this.assuntoRepository.recuperarAssuntos();
	}
	
	public void editarAssunto(AssuntoModel assuntoModel) {
		this.editarAssunto(assuntoModel);
	}
	
	public void excluirAssunto(AssuntoModel assuntoModel) {
		this.assuntoRepository.removerAssunto(assuntoModel);
		this.assuntos.remove(assuntoModel);
	}
	
	
	
}
