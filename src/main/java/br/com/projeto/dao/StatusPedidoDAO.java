package br.com.projeto.dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.projeto.entidades.StatusPedido;

public class StatusPedidoDAO implements Dao<StatusPedido>{
  private final EntityManager entityManager;

  public StatusPedidoDAO(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public Optional<StatusPedido> get(long id) {
    return Optional.ofNullable(entityManager.find(StatusPedido.class, id));
  }

  @Override
  public List<StatusPedido> getAll() {
    Query query = entityManager.createQuery("SELECT sp FROM StatusPedido sp");
    return query.getResultList();
  }

  @Override
  public void save(StatusPedido statusPedido) {
    executeInsideTransaction(entityManager -> entityManager.persist(statusPedido));

  }

  @Override
  public void update(StatusPedido statusPedido, String[] params) {
    // statusPedido.setStatusStatusPedido(Objects.requireNonNull(params[0], "Name cannot be
    // null"));
    executeInsideTransaction(entityManager -> entityManager.merge(statusPedido));

  }

  @Override
  public void delete(StatusPedido statusPedido) {
    executeInsideTransaction(entityManager -> entityManager.remove(statusPedido));
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
