package controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import Utils.Uteis;
import model.PessoaModel;
import repository.PessoaRepository;
 
@Named(value="cadastrarPessoaController")
@RequestScoped
public class CadastrarPessoaController {
 
	@Inject
	PessoaModel pessoaModel;
 
	@Inject
	UsuarioController usuarioController;
 
	@Inject
	PessoaRepository pessoaRepository;
 
 
	public PessoaModel getPessoaModel() {
		return pessoaModel;
	}
 
	public void setPessoaModel(PessoaModel pessoaModel) {
		this.pessoaModel = pessoaModel;
	}
 
	/**
	 *SALVA UM NOVO REGISTRO VIA INPUT 
	 */
	public void SalvarNovaPessoa(){
 
		pessoaModel.setUsuarioModel(this.usuarioController.GetUsuarioSession());
 
		//INFORMANDO QUE O CADASTRO FOI VIA INPUT
		pessoaModel.setOrigemCadastro("I");
 
		pessoaRepository.SalvarNovoRegistro(this.pessoaModel);
 
		this.pessoaModel = null;
 
		Uteis.MensagemInfo("Registro cadastrado com sucesso");
 
	}
 
}
