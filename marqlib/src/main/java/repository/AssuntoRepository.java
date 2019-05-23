package repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import Utils.Uteis;
import builder.QueryBuilder;
import entity.AssuntoEntity;
import entity.PessoaEntity;
import model.AssuntoModel;
import model.PessoaModel;

public class AssuntoRepository implements Serializable {

	static final long serialVersionUID = 3415630528254824885L;
	
	private final String TABELA = "tb_assunto";

	@Inject
	AssuntoEntity assuntoEntity;
	
	EntityManager entityManager;
	
	public AssuntoRepository() {
		entityManager =  Uteis.JpaEntityManager();
	}
	
	
	public void salvarAssunto(AssuntoModel assuntoModel) {
		assuntoEntity.setAssunto(assuntoModel.getAssunto());
		this.entityManager.persist(assuntoEntity);
	}
	
	@SuppressWarnings("unchecked")
	public List<AssuntoModel> recuperarAssuntos() {
		String hql = " SELECT * FROM tb_assunto ";
		
		List<AssuntoModel> assuntos = new ArrayList<AssuntoModel>();
		Collection<AssuntoEntity> assuntosEntity =  this.entityManager.createNativeQuery(hql, AssuntoEntity.class).getResultList();
 
		AssuntoModel assuntoModel = null;
 
		for (AssuntoEntity assuntoEntity : assuntosEntity) { 
			assuntoModel = new AssuntoModel();
			assuntoModel.setAssunto(assuntoEntity.getAssunto());
			assuntoModel.setId(assuntoEntity.getId());
			assuntos.add(assuntoModel);
		}
			return assuntos;
	}
	
	
	private AssuntoEntity obterAssuntoPorId(int codigo){
		 
		entityManager =  Uteis.JpaEntityManager();
 
		return entityManager.find(AssuntoEntity.class, codigo);
	}
	
	public void removerAssunto(AssuntoModel assuntoModel) {
		this.entityManager.remove(obterAssuntoPorId(assuntoModel.getId()));
	}
	
	public void editarAssunto(AssuntoModel assuntoModel){
		entityManager =  Uteis.JpaEntityManager();
		AssuntoEntity assuntoEntity = this.obterAssuntoPorId(assuntoModel.getId());
		assuntoEntity.setAssunto(assuntoModel.getAssunto());
		entityManager.merge(assuntoEntity);
	}
}
