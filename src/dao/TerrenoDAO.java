package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Terreno;

public class TerrenoDAO {
	private EntityManager entityManager;

	public TerrenoDAO() {
		entityManager = getEntityManager();
	}	
	
	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("exemploBanco");
		
		if (entityManager ==  null) {
			entityManager = factory.createEntityManager();
		}
		
		return entityManager;
	}
	
	public void persist(Terreno terreno){
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(terreno);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
	}
	
	public void update(Terreno terreno){
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(terreno);
			entityManager.getTransaction().commit();			
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
	}
	
	public void remove(int id){
		try {
			entityManager.getTransaction().begin();
			Terreno terreno = entityManager.find(Terreno.class, id);
			entityManager.remove(terreno);
			entityManager.getTransaction().commit();			
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
	}
	
	public List<Terreno> findAll(){
		//return entityManager.createQuery("select p from Terreno p").getResultList();
		return entityManager.createQuery("from Terreno", Terreno.class).getResultList();
	}
	
	public Terreno findById(Integer id){
		return (Terreno) entityManager.createQuery("from Terreno where id = :id")
				.setParameter("id", id)
				.getSingleResult();
	}
}
