package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_exemplar database table.
 * 
 */
@Entity
@Table(name="tb_exemplar")
@NamedQuery(name="TbExemplar.findAll", query="SELECT t FROM TbExemplar t")
public class TbExemplar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private byte circular;

	//bi-directional many-to-one association to TbEmprestimo
	@OneToMany(mappedBy="tbExemplar")
	private List<TbEmprestimo> tbEmprestimos;

	//bi-directional many-to-one association to TbLivro
	@ManyToOne
	@JoinColumn(name="idLivro")
	private TbLivro tbLivro;

	//bi-directional many-to-one association to TbReserva
	@OneToMany(mappedBy="tbExemplar")
	private List<TbReserva> tbReservas;

	public TbExemplar() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getCircular() {
		return this.circular;
	}

	public void setCircular(byte circular) {
		this.circular = circular;
	}

	public List<TbEmprestimo> getTbEmprestimos() {
		return this.tbEmprestimos;
	}

	public void setTbEmprestimos(List<TbEmprestimo> tbEmprestimos) {
		this.tbEmprestimos = tbEmprestimos;
	}

	public TbEmprestimo addTbEmprestimo(TbEmprestimo tbEmprestimo) {
		getTbEmprestimos().add(tbEmprestimo);
		tbEmprestimo.setTbExemplar(this);

		return tbEmprestimo;
	}

	public TbEmprestimo removeTbEmprestimo(TbEmprestimo tbEmprestimo) {
		getTbEmprestimos().remove(tbEmprestimo);
		tbEmprestimo.setTbExemplar(null);

		return tbEmprestimo;
	}

	public TbLivro getTbLivro() {
		return this.tbLivro;
	}

	public void setTbLivro(TbLivro tbLivro) {
		this.tbLivro = tbLivro;
	}

	public List<TbReserva> getTbReservas() {
		return this.tbReservas;
	}

	public void setTbReservas(List<TbReserva> tbReservas) {
		this.tbReservas = tbReservas;
	}

	public TbReserva addTbReserva(TbReserva tbReserva) {
		getTbReservas().add(tbReserva);
		tbReserva.setTbExemplar(this);

		return tbReserva;
	}

	public TbReserva removeTbReserva(TbReserva tbReserva) {
		getTbReservas().remove(tbReserva);
		tbReserva.setTbExemplar(null);

		return tbReserva;
	}

}