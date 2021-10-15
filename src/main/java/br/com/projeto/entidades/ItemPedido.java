package br.com.projeto.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_item_pedido")
public class ItemPedido {
  
  @Id
  private long idItemPedido;
      
  @Column(nullable = false)
  private float valorUnitario;
  
  @Column(nullable = false)
  private int quantidadeProduto;
  
  @ManyToOne
  @JoinColumn(name = "idPedido")
  private Pedido pedido;
  
  @ManyToOne
  @JoinColumn(name = "idProduto", nullable = false)
  private Produto produto;
  
  @ManyToOne
  @JoinColumn(name = "idCliente")
  private Cliente cliente;
  
  public ItemPedido() {
    super();
  }

  public ItemPedido(long idItemPedido, float valorUnitario, int quantidadeProduto, Pedido pedido, Produto produto,
      Cliente cliente) {
    super();
    this.idItemPedido = idItemPedido;
    this.valorUnitario = valorUnitario;
    this.quantidadeProduto = quantidadeProduto;
    this.pedido = pedido;
    this.produto = produto;
    this.cliente = cliente;
  }
  
  

}
