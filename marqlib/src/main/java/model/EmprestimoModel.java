package model;

import java.time.LocalDate;

public class EmprestimoModel {
	
	private Integer id;
	private LocalDate dataEmprestimo;
	private LocalDate dataDevolucao;
	private ExemplarModel exemplarModel;
	private UsuarioModel usuarioModel;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public ExemplarModel getExemplarModel() {
		return exemplarModel;
	}
	public void setExemplarModel(ExemplarModel exemplarModel) {
		this.exemplarModel = exemplarModel;
	}
	public UsuarioModel getUsuarioModel() {
		return usuarioModel;
	}
	public void setUsuarioModel(UsuarioModel usuarioModel) {
		this.usuarioModel = usuarioModel;
	}
	
}
