package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 
@Table(name="tb_usuario")
@Entity	
@NamedQuery(name = "UsuarioEntity.findUser", 
		    query= "SELECT u FROM UsuarioEntity u WHERE u.usuario = :usuario AND u.senha = :senha")
public class UsuarioEntity implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_usuario")
	private String codigo;
 
	@Column(name="ds_login")
	private String usuario;
 
	@Column(name="ds_senha")
	private String senha;
	
	//bi-directional many-to-one association to TbEmprestimo
	@OneToMany(mappedBy="tbUsuario")
	private List<TbEmprestimo> tbEmprestimos;

	//bi-directional many-to-one association to TbPessoa
	@OneToMany(mappedBy="usuarioEntity")
	private List<PessoaEntity> tbPessoas;

	//bi-directional many-to-one association to TbReserva
	@OneToMany(mappedBy="tbUsuario")
	private List<TbReserva> tbReservas;
 
	public UsuarioEntity() {
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<TbEmprestimo> getTbEmprestimos() {
		return this.tbEmprestimos;
	}

	public void setTbEmprestimos(List<TbEmprestimo> tbEmprestimos) {
		this.tbEmprestimos = tbEmprestimos;
	}

	public TbEmprestimo addTbEmprestimo(TbEmprestimo tbEmprestimo) {
		getTbEmprestimos().add(tbEmprestimo);
		tbEmprestimo.setTbUsuario(this);

		return tbEmprestimo;
	}

	public TbEmprestimo removeTbEmprestimo(TbEmprestimo tbEmprestimo) {
		getTbEmprestimos().remove(tbEmprestimo);
		tbEmprestimo.setTbUsuario(null);

		return tbEmprestimo;
	}

	public List<PessoaEntity> getTbPessoas() {
		return tbPessoas;
	}

	public void setTbPessoas(List<PessoaEntity> tbPessoas) {
		this.tbPessoas = tbPessoas;
	}

	public List<TbReserva> getTbReservas() {
		return this.tbReservas;
	}

	public void setTbReservas(List<TbReserva> tbReservas) {
		this.tbReservas = tbReservas;
	}

	public TbReserva addTbReserva(TbReserva tbReserva) {
		getTbReservas().add(tbReserva);
		tbReserva.setTbUsuario(this);

		return tbReserva;
	}

	public TbReserva removeTbReserva(TbReserva tbReserva) {
		getTbReservas().remove(tbReserva);
		tbReserva.setTbUsuario(null);

		return tbReserva;
	}
	
}