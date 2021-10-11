package br.com.projeto.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pedido")
public class Pedido {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long idPedido;
  
  @Column
  private float valorTotal;
  
  @Column
  private Date dataPedido;
  
  @ManyToOne
  @JoinColumn(name = "idFormaPagamento")
  private FormaPagamento formaPagamento;
  
  @ManyToOne
  @JoinColumn(name = "idStatusPedido")
  private StatusPedido statusPedido;
  
  public Pedido() {
    super();
  }
  
  public Pedido(float valorTotal, Date dataPedido, FormaPagamento formaPagamento,
      StatusPedido statusPedido) {
    super();
    this.valorTotal = valorTotal;
    this.dataPedido = dataPedido;
    this.formaPagamento = formaPagamento;
    this.statusPedido = statusPedido;
  }

  public Pedido(long idPedido, float valorTotal, Date dataPedido, FormaPagamento formaPagamento,
      StatusPedido statusPedido) {
    super();
    this.idPedido = idPedido;
    this.valorTotal = valorTotal;
    this.dataPedido = dataPedido;
    this.formaPagamento = formaPagamento;
    this.statusPedido = statusPedido;
  }

  public long getIdPedido() {
    return idPedido;
  }

  public void setIdPedido(long idPedido) {
    this.idPedido = idPedido;
  }

  public float getValorTotal() {
    return valorTotal;
  }

  public void setValorTotal(float valorTotal) {
    this.valorTotal = valorTotal;
  }

  public Date getDataPedido() {
    return dataPedido;
  }

  public void setDataPedido(Date dataPedido) {
    this.dataPedido = dataPedido;
  }

  public FormaPagamento getFormaPagamento() {
    return formaPagamento;
  }

  public void setFormaPagamento(FormaPagamento formaPagamento) {
    this.formaPagamento = formaPagamento;
  }

  public StatusPedido getStatusPedido() {
    return statusPedido;
  }

  public void setStatusPedido(StatusPedido statusPedido) {
    this.statusPedido = statusPedido;
  }
  
}
