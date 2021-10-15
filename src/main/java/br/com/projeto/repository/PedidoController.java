package br.com.projeto.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.PropertyValueException;

import br.com.projeto.dao.PedidoDAO;
import br.com.projeto.dao.Dao;
import br.com.projeto.entidades.Pedido;

public class PedidoController {
  static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("projeto");
  static EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

  private static class PedidoDaoHolder {
    private static final PedidoDAO pedidoDAO = new PedidoDAO(entityManager);
  }

  @SuppressWarnings("rawtypes")
  public static Dao getPedidoDao() {
    return PedidoDaoHolder.pedidoDAO;
  }

  @SuppressWarnings("unchecked")
  public void savePedido(Pedido pedido) {
    try {
      getPedidoDao().save(pedido);
    } catch (PropertyValueException e) {
      System.out.println("ERRO: " + e.getMessage());
    }
  }

  @SuppressWarnings("unchecked")
  public List<Pedido> getAll() {
    return getPedidoDao().getAll();
  }

  @SuppressWarnings("unchecked")
  public static Pedido getPedido(long idPedido) {
    Optional<Pedido> pedido = getPedidoDao().get(idPedido);
    return pedido.orElseGet(() -> new Pedido());
  }

  @SuppressWarnings("unchecked")
  public void deletePedido(Pedido pedido) {
    getPedidoDao().delete(pedido);
  }

  @SuppressWarnings("unchecked")
  public void updatePedido(Pedido pedido, String[] params) {
    getPedidoDao().update(pedido, params);
  }
}
