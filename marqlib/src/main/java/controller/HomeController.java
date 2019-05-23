package controller;

import java.io.Serializable;
import java.util.Hashtable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.PieChartModel;

import entity.UsuarioEntity;
import model.UsuarioModel;
import repository.PessoaRepository;
import repository.UsuarioRepository;

@Named(value="homeController")
@RequestScoped
public class HomeController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	 
	@Inject
	private UsuarioModel usuarioModel;
 
	@Inject
	private UsuarioRepository usuarioRepository;
 
	@Inject
	private UsuarioEntity usuarioEntity;
	
	@Inject
	private PessoaRepository pessoaRepository;
	
	private PieChartModel pieChartModel;
	 
	public PieChartModel getPieChartModel() {
		return pieChartModel;
	}
 
	@PostConstruct
	public  void init(){
 
		this.pieChartModel = new PieChartModel();
 
		this.MontaGrafico();
	}
 
	/***
	 * MONTA O GRÁFICO NA PÁGINA
	 */
	private void MontaGrafico(){
 
		//CONSULTA OS DADOS PARA MONTAR O GRÁFICO
		Hashtable<String, Integer> hashtableRegistros = pessoaRepository.GetOrigemPessoa();
 
 
		//INFORMANDO OS VALORES PARA MONTAR O GRÁFICO
		hashtableRegistros.forEach((chave,valor) -> {
 
 
			pieChartModel.set(chave, valor);
 
		});
 
		pieChartModel.setTitle("Total de Pessoas cadastrado por Tipo");
		pieChartModel.setShowDataLabels(true);
		pieChartModel.setLegendPosition("e");
 
 
	}
	
	

}
