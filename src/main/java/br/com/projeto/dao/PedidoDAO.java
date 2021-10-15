package br.com.projeto.dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.projeto.entidades.Pedido;

public class PedidoDAO implements Dao<Pedido> {

  private final EntityManager entityManager;

  public PedidoDAO(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public Optional<Pedido> get(long id) {
    return Optional.ofNullable(entityManager.find(Pedido.class, id));
  }

  @Override
  public List<Pedido> getAll() {
    Query query = entityManager.createQuery("SELECT p FROM Pedido p");
    return query.getResultList();
  }

  @Override
  public void save(Pedido pedido) {
    executeInsideTransaction(entityManager -> entityManager.persist(pedido));

  }

  @Override
  public void update(Pedido pedido, String[] params) {
    // pedido.setStatusPedido(Objects.requireNonNull(params[0], "Name cannot be
    // null"));
    executeInsideTransaction(entityManager -> entityManager.merge(pedido));

  }

  @Override
  public void delete(Pedido pedido) {
    executeInsideTransaction(entityManager -> entityManager.remove(pedido));
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
