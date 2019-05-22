package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tb_reserva database table.
 * 
 */
@Entity
@Table(name="tb_reserva")
@NamedQuery(name="TbReserva.findAll", query="SELECT t FROM TbReserva t")
public class TbReserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.DATE)
	private Date dataReserva;

	//bi-directional many-to-one association to TbEmprestimo
	@ManyToOne
	@JoinColumn(name="idEmprestimo")
	private TbEmprestimo tbEmprestimo;

	//bi-directional many-to-one association to TbExemplar
	@ManyToOne
	@JoinColumn(name="idExemplar")
	private TbExemplar tbExemplar;

	//bi-directional many-to-one association to TbUsuario
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private UsuarioEntity tbUsuario;

	public TbReserva() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataReserva() {
		return this.dataReserva;
	}

	public void setDataReserva(Date dataReserva) {
		this.dataReserva = dataReserva;
	}

	public TbEmprestimo getTbEmprestimo() {
		return this.tbEmprestimo;
	}

	public void setTbEmprestimo(TbEmprestimo tbEmprestimo) {
		this.tbEmprestimo = tbEmprestimo;
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

}