package br.com.projeto.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.PropertyValueException;

import br.com.projeto.dao.Dao;
import br.com.projeto.dao.FormaPagamentoDAO;
import br.com.projeto.entidades.FormaPagamento;

public class FormaPagamentoController {
  static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("projeto");
  static EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

  private static class FormaPagamentoDaoHolder {
    private static final FormaPagamentoDAO formaPagamentoDAO = new FormaPagamentoDAO(entityManager);
  }

  @SuppressWarnings("rawtypes")
  public static Dao getFormaPagamentoDao() {
    return FormaPagamentoDaoHolder.formaPagamentoDAO;
  }

  @SuppressWarnings("unchecked")
  public void saveFormaPagamento(FormaPagamento formaPagamento) {
    try {
      getFormaPagamentoDao().save(formaPagamento);
    } catch (PropertyValueException e) {
      System.out.println("ERRO: " + e.getMessage());
    }
  }

  @SuppressWarnings("unchecked")
  public List<FormaPagamento> getAll() {
    return getFormaPagamentoDao().getAll();
  }

  @SuppressWarnings("unchecked")
  public static FormaPagamento getFormaPagamento(long idFormaPagamento) {
    Optional<FormaPagamento> formaPagamento = getFormaPagamentoDao().get(idFormaPagamento);
    return formaPagamento.orElseGet(() -> new FormaPagamento());
  }

  @SuppressWarnings("unchecked")
  public void deleteFormaPagamento(FormaPagamento formaPagamento) {
    getFormaPagamentoDao().delete(formaPagamento);
  }

  @SuppressWarnings("unchecked")
  public void updateFormaPagamento(FormaPagamento formaPagamento, String[] params) {
    getFormaPagamentoDao().update(formaPagamento, params);
  }
}
