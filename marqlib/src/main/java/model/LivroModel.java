package model;

public class LivroModel {
	
	private Integer id;
	
	private String titulo;
	
	private String isbn;
	
	private Integer edicao;
	
	private Integer ano;
	
	private EditoraModel editoraModel;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getEdicao() {
		return edicao;
	}

	public void setEdicao(Integer edicao) {
		this.edicao = edicao;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public EditoraModel getEditoraModel() {
		return editoraModel;
	}

	public void setEditoraModel(EditoraModel editoraModel) {
		this.editoraModel = editoraModel;
	}
	
	
}
