package br.com.projeto.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.PropertyValueException;

import br.com.projeto.dao.CategoriaDAO;
import br.com.projeto.dao.Dao;
import br.com.projeto.entidades.Categoria;

public class CategoriaRepository {

  static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("projeto");
  static EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

  private static class CategoriaDaoHolder {
    private static final CategoriaDAO categoriaDAO = new CategoriaDAO(entityManager);
  }

  @SuppressWarnings("rawtypes")
  public static Dao getCategoriaDao() {
    return CategoriaDaoHolder.categoriaDAO;
  }

  @SuppressWarnings("unchecked")
  public void saveCategoria(Categoria categoria) {
    try {
      getCategoriaDao().save(categoria);
    } catch (PropertyValueException e) {
      System.out.println("ERRO: " + e.getMessage());
    }
  }

  @SuppressWarnings("unchecked")
  public List<Categoria> getAll() {
    return getCategoriaDao().getAll();
  }

  @SuppressWarnings("unchecked")
  public static Categoria getCategoria(long idCategoria) {
    Optional<Categoria> categoria = getCategoriaDao().get(idCategoria);
    return categoria.orElseGet(() -> new Categoria("Categoria com id: " + idCategoria + " não existe"));
  }

  @SuppressWarnings("unchecked")
  public void deleteCategoria(Categoria categoria) {
    getCategoriaDao().delete(categoria);
  }

  @SuppressWarnings("unchecked")
  public void updateCategoria(Categoria categoria, String[] params) {
    getCategoriaDao().update(categoria, params);
  }

}
