package br.com.projeto.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.PropertyValueException;

import br.com.projeto.dao.Dao;
import br.com.projeto.dao.StatusPedidoDAO;
import br.com.projeto.entidades.StatusPedido;

public class StatusStatusPedidoController {
  static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("projeto");
  static EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

  private static class StatusPedidoDaoHolder {
    private static final StatusPedidoDAO statusPedidoDAO = new StatusPedidoDAO(entityManager);
  }

  @SuppressWarnings("rawtypes")
  public static Dao getStatusPedidoDao() {
    return StatusPedidoDaoHolder.statusPedidoDAO;
  }

  @SuppressWarnings("unchecked")
  public void saveStatusPedido(StatusPedido statusPedido) {
    try {
      getStatusPedidoDao().save(statusPedido);
    } catch (PropertyValueException e) {
      System.out.println("ERRO: " + e.getMessage());
    }
  }

  @SuppressWarnings("unchecked")
  public List<StatusPedido> getAll() {
    return getStatusPedidoDao().getAll();
  }

  @SuppressWarnings("unchecked")
  public static StatusPedido getStatusPedido(long idStatusPedido) {
    Optional<StatusPedido> statusPedido = getStatusPedidoDao().get(idStatusPedido);
    return statusPedido.orElseGet(() -> new StatusPedido());
  }

  @SuppressWarnings("unchecked")
  public void deleteStatusPedido(StatusPedido statusPedido) {
    getStatusPedidoDao().delete(statusPedido);
  }

  @SuppressWarnings("unchecked")
  public void updateStatusPedido(StatusPedido statusPedido, String[] params) {
    getStatusPedidoDao().update(statusPedido, params);
  }
}
