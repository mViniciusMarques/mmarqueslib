package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_autor database table.
 * 
 */
@Entity
@Table(name="tb_autor")
@NamedQuery(name="TbAutor.findAll", query="SELECT t FROM AutorEntity t")
public class AutorEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String nome;

	//bi-directional many-to-many association to TbLivro
	@ManyToMany(mappedBy="autorEntities")
	private List<TbLivro> tbLivros;

	public AutorEntity() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<TbLivro> getTbLivros() {
		return this.tbLivros;
	}

	public void setTbLivros(List<TbLivro> tbLivros) {
		this.tbLivros = tbLivros;
	}

}