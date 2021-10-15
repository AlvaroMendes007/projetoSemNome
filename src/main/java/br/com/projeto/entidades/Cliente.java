package br.com.projeto.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cliente")
public class Cliente {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long idCliente;
  
  @Column(nullable = false)
  private String nome;
  
  @Column
  private Date dataNascimento;
  
  @Column
  private String numeroTelefone;
  
  public Cliente() {
    super();
  }
  
  public Cliente(String nome, Date dataNascimento, String numeroTelefone) {
    super();
    this.nome = nome;
    this.dataNascimento = dataNascimento;
    this.numeroTelefone = numeroTelefone;
  }

  public Cliente(long idCliente, String nome, Date dataNascimento, String numeroTelefone) {
    super();
    this.idCliente = idCliente;
    this.nome = nome;
    this.dataNascimento = dataNascimento;
    this.numeroTelefone = numeroTelefone;
  }



  public long getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(long idCliente) {
    this.idCliente = idCliente;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Date getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(Date dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public String getNumeroTelefone() {
    return numeroTelefone;
  }

  public void setNumeroTelefone(String numeroTelefone) {
    this.numeroTelefone = numeroTelefone;
  }  

}
