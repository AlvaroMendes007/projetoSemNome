package br.com.projeto.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_status_pedido")
public class StatusPedido {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long idStatusPedido;

  @Column(nullable = false)
  private String descricaoStatusPedido;

  public StatusPedido() {
    super();
  }

  public StatusPedido(String descricaoStatusPedido) {
    super();
    this.descricaoStatusPedido = descricaoStatusPedido;
  }

  public StatusPedido(long idStatusPedido, String descricaoStatusPedido) {
    super();
    this.idStatusPedido = idStatusPedido;
    this.descricaoStatusPedido = descricaoStatusPedido;
  }

  public long getIdStatusPedido() {
    return idStatusPedido;
  }

  public void setIdStatusPedido(long idStatusPedido) {
    this.idStatusPedido = idStatusPedido;
  }

  public String getDescricaoStatusPedido() {
    return descricaoStatusPedido;
  }

  public void setDescricaoStatusPedido(String descricaoStatusPedido) {
    this.descricaoStatusPedido = descricaoStatusPedido;
  }

}
