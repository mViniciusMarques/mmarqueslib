package model;

import java.time.LocalDate;

public class ReservaModel {
	
	private Integer id;
	private LocalDate dataReserva;
	private ExemplarModel exemplarModel;
	private UsuarioModel usuarioModel;
	private EmprestimoModel emprestimoModel;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getDataReserva() {
		return dataReserva;
	}
	public void setDataReserva(LocalDate dataReserva) {
		this.dataReserva = dataReserva;
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
	public EmprestimoModel getEmprestimoModel() {
		return emprestimoModel;
	}
	public void setEmprestimoModel(EmprestimoModel emprestimoModel) {
		this.emprestimoModel = emprestimoModel;
	}
	
	
}
