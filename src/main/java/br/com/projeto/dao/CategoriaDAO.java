package br.com.projeto.dao;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.Session;

import br.com.projeto.entidades.Categoria;
import br.com.projeto.factory.FactorySession;

public class CategoriaDAO implements Dao<Categoria> {

	//EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("projeto");
	//EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
	
	private final EntityManager entityManager;

	public CategoriaDAO(EntityManager entityManager) {
	        this.entityManager = entityManager;
	    }

	@Override
	public Optional<Categoria> get(long id) {
		return Optional.ofNullable(entityManager.find(Categoria.class, id));
	}

	@Override
	public List<Categoria> getAll() {
		Query query = entityManager.createQuery("SELECT c FROM Categoria c");
		return query.getResultList();
	}

	@Override
	public void save(Categoria categoria) {
		executeInsideTransaction(entityManager -> entityManager.persist(categoria));
	}

	@Override
	public void update(Categoria categoria, String[] params) {
		categoria.setNome(Objects.requireNonNull(params[0], "Name cannot be null"));
		executeInsideTransaction(entityManager -> entityManager.merge(categoria));
	}

	@Override
	public void delete(Categoria categoria) {
		executeInsideTransaction(entityManager -> entityManager.remove(categoria));
	}

	private void executeInsideTransaction(Consumer<EntityManager> action) {
		final EntityTransaction tx = entityManager.getTransaction();
		
		try {
			tx.begin();
			action.accept(entityManager);
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;

		}
	}
}