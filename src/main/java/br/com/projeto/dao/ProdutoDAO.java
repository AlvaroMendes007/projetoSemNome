package br.com.projeto.dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.projeto.entidades.Produto;

public class ProdutoDAO implements Dao<Produto>{

  private final EntityManager entityManager;

  public ProdutoDAO(EntityManager entityManager) {
          this.entityManager = entityManager;
      }
  
  @Override
  public Optional<Produto> get(long id) {
      return Optional.ofNullable(entityManager.find(Produto.class, id));
  }
  
  @SuppressWarnings("unchecked")
  public List<Produto> getByCategoria(long idCategoria){
    String selectionQuery = "SELECT p FROM Produto p WHERE p.categoria.idCategoria = :idCategoria";
    List<Produto> resultado = entityManager.createQuery(selectionQuery).setParameter("idCategoria", idCategoria).getResultList();
    return resultado;
  }
  
  @SuppressWarnings("unchecked")
  @Override
  public List<Produto> getAll() {
      Query query = entityManager.createQuery("SELECT c FROM Produto c");
      return query.getResultList();
  }

  @Override
  public void save(Produto produto) {
      executeInsideTransaction(entityManager -> entityManager.persist(produto));
  }

  @Override
  public void update(Produto produto, String[] params) {
      executeInsideTransaction(entityManager -> entityManager.merge(produto));
  }

  @Override
  public void delete(Produto produto) {
      executeInsideTransaction(entityManager -> entityManager.remove(produto));
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
