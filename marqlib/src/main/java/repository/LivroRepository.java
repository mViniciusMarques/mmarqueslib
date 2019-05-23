package repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import Utils.Uteis;
import entity.TbLivro;
import model.LivroModel;

public class LivroRepository implements Serializable {

	private static final long serialVersionUID = 9150118003962959446L;
	
	@Inject
	TbLivro livroEntity;
	
	EntityManager entityManager;
	
	public LivroRepository() {
		entityManager = Uteis.JpaEntityManager();
	}
	
	public void salvarLivro(LivroModel livroModel) {
		livroEntity.setEdicao(livroModel.getEdicao());
		livroEntity.setIsbn(livroModel.getIsbn());
		livroEntity.setTitulo(livroModel.getTitulo());
		
		livroEntity.setAno(livroModel.getAno());
		//livroEntity.set
		
		entityManager.persist(livroEntity);
	}
	
	public List<LivroModel> obterAcertoGeral() {
		return null;
	}
	
	public LivroModel obterLivroPorId(Integer id) {
		return null;
	}
	
	public List<LivroModel> obterLivroPorAno(Integer ano) {
		return null;
	}
	

}
