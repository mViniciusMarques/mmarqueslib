package model;

public class ExemplarModel {

	private Integer id;
	
	private Integer circular;
	
	private LivroModel livroModel;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCircular() {
		return circular;
	}

	public void setCircular(Integer circular) {
		this.circular = circular;
	}

	public LivroModel getLivroModel() {
		return livroModel;
	}

	public void setLivroModel(LivroModel livroModel) {
		this.livroModel = livroModel;
	}
	
	
}
