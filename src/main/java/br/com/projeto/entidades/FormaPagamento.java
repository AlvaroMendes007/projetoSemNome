package br.com.projeto.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "tb_forma_pagamento")
public class FormaPagamento {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long idFormaPagamento;
  
  @Column(nullable = false)
  private String descricaoFormaPagamento;
  
  public FormaPagamento() {
    super();
  }
  
  public FormaPagamento(String descricaoFormaPagamento) {
    super();
    this.descricaoFormaPagamento = descricaoFormaPagamento;
  }

  public FormaPagamento(long idFormaPagamento, String descricaoFormaPagamento) {
    super();
    this.idFormaPagamento = idFormaPagamento;
    this.descricaoFormaPagamento = descricaoFormaPagamento;
  }

  public long getIdFormaPagamento() {
    return idFormaPagamento;
  }

  public void setIdFormaPagamento(long idFormaPagamento) {
    this.idFormaPagamento = idFormaPagamento;
  }

  public String getDescricaoFormaPagamento() {
    return descricaoFormaPagamento;
  }

  public void setDescricaoFormaPagamento(String descricaoFormaPagamento) {
    this.descricaoFormaPagamento = descricaoFormaPagamento;
  }

}
