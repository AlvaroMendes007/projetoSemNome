package br.com.projeto.principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.projeto.entidades.Categoria;
import br.com.projeto.entidades.Produto;
import br.com.projeto.repository.CategoriaRepository;
import br.com.projeto.repository.ProdutoController;

@SpringBootApplication
public class ProjetoApplication {
  
	public static void main(String[] args) {
		SpringApplication.run(ProjetoApplication.class, args);
		
		ProdutoController pdao = new ProdutoController();
		CategoriaRepository cc = new CategoriaRepository();
		
		Categoria categoria = new Categoria();
		
		Produto produto = new Produto();
	}
}
