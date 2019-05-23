package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_livro database table.
 * 
 */
@Entity
@Table(name="tb_livro")
@NamedQuery(name="TbLivro.findAll", query="SELECT t FROM TbLivro t")
public class TbLivro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int ano;

	private int edicao;

	private String isbn;

	private String titulo;

	//bi-directional many-to-many association to TbAutor
	@ManyToMany
	@JoinTable(
		name="tb_autorlivro"
		, joinColumns={
			@JoinColumn(name="idLivro")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idAutor")
			}
		)
	private List<AutorEntity> autorEntities;

	//bi-directional many-to-one association to TbExemplar
	@OneToMany(mappedBy="tbLivro")
	private List<TbExemplar> tbExemplars;

	//bi-directional many-to-one association to EditoraEntity
	@ManyToOne
	@JoinColumn(name="idEditora")
	private EditoraEntity editoraEntity;

	//bi-directional many-to-many association to TbAssunto
	@ManyToMany
	@JoinTable(
		name="tb_livroassunto"
		, joinColumns={
			@JoinColumn(name="idLivro")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idAssunto")
			}
		)
	private List<AssuntoEntity> tbAssuntos;

	public TbLivro() {
	}

	public int getId() {
		return this.id;
	}

	public int getAno() {
		return this.ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getEdicao() {
		return this.edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<AutorEntity> getTbAutors() {
		return this.autorEntities;
	}

	public void setTbAutors(List<AutorEntity> autorEntities) {
		this.autorEntities = autorEntities;
	}

	public List<TbExemplar> getTbExemplars() {
		return this.tbExemplars;
	}

	public void setTbExemplars(List<TbExemplar> tbExemplars) {
		this.tbExemplars = tbExemplars;
	}

	public TbExemplar addTbExemplar(TbExemplar tbExemplar) {
		getTbExemplars().add(tbExemplar);
		tbExemplar.setTbLivro(this);

		return tbExemplar;
	}

	public TbExemplar removeTbExemplar(TbExemplar tbExemplar) {
		getTbExemplars().remove(tbExemplar);
		tbExemplar.setTbLivro(null);

		return tbExemplar;
	}

	public EditoraEntity getTbEditora() {
		return this.editoraEntity;
	}

	public void setTbEditora(EditoraEntity editoraEntity) {
		this.editoraEntity = editoraEntity;
	}

	public List<AssuntoEntity> getTbAssuntos() {
		return this.tbAssuntos;
	}

	public void setTbAssuntos(List<AssuntoEntity> tbAssuntos) {
		this.tbAssuntos = tbAssuntos;
	}

}