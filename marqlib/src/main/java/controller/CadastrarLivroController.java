package controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.LivroModel;
import model.PessoaModel;
import repository.LivroRepository;
import repository.PessoaRepository;

@Named(value="cadastrarLivroController")
@RequestScoped
public class CadastrarLivroController {
	
	@Inject
	PessoaModel pessoaModel;
 
	@Inject
	UsuarioController usuarioController;
 
	@Inject
	PessoaRepository pessoaRepository;
	
	@Inject
	LivroModel livroModel;
	
	@Inject
	LivroRepository livroRepository;

	public PessoaModel getPessoaModel() {
		return pessoaModel;
	}

	public void setPessoaModel(PessoaModel pessoaModel) {
		this.pessoaModel = pessoaModel;
	}

	public LivroModel getLivroModel() {
		return livroModel;
	}

	public void setLivroModel(LivroModel livroModel) {
		this.livroModel = livroModel;
	}
	
	public void salvarLivro() {
		
	}

	
	

}
