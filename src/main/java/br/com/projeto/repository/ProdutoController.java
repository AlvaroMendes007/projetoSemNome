package br.com.projeto.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.PropertyValueException;

import br.com.projeto.dao.ProdutoDAO;
import br.com.projeto.dao.Dao;
import br.com.projeto.entidades.Produto;

public class ProdutoController {
  static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("projeto");
  static EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

  private static class ProdutoDaoHolder {
    private static final ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);
  }

  @SuppressWarnings("rawtypes")
  public static Dao getProdutoDao() {
    return ProdutoDaoHolder.produtoDAO;
  }

  @SuppressWarnings("unchecked")
  public void saveProduto(Produto produto) {
    try {
      getProdutoDao().save(produto);
    } catch (PropertyValueException e) {
      System.out.println("ERRO: " + e.getMessage());
    }
  }

  @SuppressWarnings("unchecked")
  public List<Produto> getAll() {
    return getProdutoDao().getAll();
  }

  @SuppressWarnings("unchecked")
  public static Produto getProduto(long idProduto) {
    Optional<Produto> produto = getProdutoDao().get(idProduto);
    return produto
        .orElseGet(() -> new Produto(idProduto, "Produto com id: " + idProduto + " não existe", null, idProduto, null));
  }

  public static List<Produto> getByCategoria(long idCategoria) {
    return ProdutoDaoHolder.produtoDAO.getByCategoria(idCategoria);
  }

  @SuppressWarnings("unchecked")
  public void deleteProduto(Produto produto) {
    getProdutoDao().delete(produto);
  }

  @SuppressWarnings("unchecked")
  public void updateProduto(Produto produto, String[] params) {
    getProdutoDao().update(produto, params);
  }
}
