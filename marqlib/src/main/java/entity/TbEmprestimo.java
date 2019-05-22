package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tb_emprestimo database table.
 * 
 */
@Entity
@Table(name="tb_emprestimo")
@NamedQuery(name="TbEmprestimo.findAll", query="SELECT t FROM TbEmprestimo t")
public class TbEmprestimo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.DATE)
	private Date dataDevolucao;

	@Temporal(TemporalType.DATE)
	private Date dataEmprestimo;

	//bi-directional many-to-one association to TbExemplar
	@ManyToOne
	@JoinColumn(name="idExemplar")
	private TbExemplar tbExemplar;

	//bi-directional many-to-one association to TbUsuario
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private UsuarioEntity tbUsuario;

	//bi-directional many-to-one association to TbReserva
	@OneToMany(mappedBy="tbEmprestimo")
	private List<TbReserva> tbReservas;

	public TbEmprestimo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataDevolucao() {
		return this.dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public Date getDataEmprestimo() {
		return this.dataEmprestimo;
	}

	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public TbExemplar getTbExemplar() {
		return this.tbExemplar;
	}

	public void setTbExemplar(TbExemplar tbExemplar) {
		this.tbExemplar = tbExemplar;
	}

	public UsuarioEntity getTbUsuario() {
		return this.tbUsuario;
	}

	public void setTbUsuario(UsuarioEntity tbUsuario) {
		this.tbUsuario = tbUsuario;
	}

	public List<TbReserva> getTbReservas() {
		return this.tbReservas;
	}

	public void setTbReservas(List<TbReserva> tbReservas) {
		this.tbReservas = tbReservas;
	}

	public TbReserva addTbReserva(TbReserva tbReserva) {
		getTbReservas().add(tbReserva);
		tbReserva.setTbEmprestimo(this);

		return tbReserva;
	}

	public TbReserva removeTbReserva(TbReserva tbReserva) {
		getTbReservas().remove(tbReserva);
		tbReserva.setTbEmprestimo(null);

		return tbReserva;
	}

}