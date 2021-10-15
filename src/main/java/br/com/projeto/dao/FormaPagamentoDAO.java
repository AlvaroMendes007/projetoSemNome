package br.com.projeto.dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.projeto.entidades.FormaPagamento;

public class FormaPagamentoDAO implements Dao<FormaPagamento>{

  private final EntityManager entityManager;

  public FormaPagamentoDAO(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public Optional<FormaPagamento> get(long id) {
    return Optional.ofNullable(entityManager.find(FormaPagamento.class, id));
  }

  @Override
  public List<FormaPagamento> getAll() {
    Query query = entityManager.createQuery("SELECT fp FROM FormaPagamento fp");
    return query.getResultList();
  }

  @Override
  public void save(FormaPagamento formaPagamento) {
    executeInsideTransaction(entityManager -> entityManager.persist(formaPagamento));

  }

  @Override
  public void update(FormaPagamento formaPagamento, String[] params) {
    // formaPagamento.setStatusFormaPagamento(Objects.requireNonNull(params[0], "Name cannot be
    // null"));
    executeInsideTransaction(entityManager -> entityManager.merge(formaPagamento));

  }

  @Override
  public void delete(FormaPagamento formaPagamento) {
    executeInsideTransaction(entityManager -> entityManager.remove(formaPagamento));
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
