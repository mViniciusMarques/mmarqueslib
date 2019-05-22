package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_editora database table.
 * 
 */
@Entity
@Table(name="tb_editora")
@NamedQuery(name="EditoraEntity.findAll", query="SELECT t FROM EditoraEntity t")
public class EditoraEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String nome;

	//bi-directional many-to-one association to TbLivro
	@OneToMany(mappedBy="editoraEntity")
	private List<TbLivro> tbLivros;

	public EditoraEntity() {
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

	public TbLivro addTbLivro(TbLivro tbLivro) {
		getTbLivros().add(tbLivro);
		tbLivro.setTbEditora(this);

		return tbLivro;
	}

	public TbLivro removeTbLivro(TbLivro tbLivro) {
		getTbLivros().remove(tbLivro);
		tbLivro.setTbEditora(null);

		return tbLivro;
	}

}