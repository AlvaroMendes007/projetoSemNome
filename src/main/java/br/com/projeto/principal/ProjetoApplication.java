package br.com.projeto.principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.projeto.controller.ProdutoController;

@SpringBootApplication
public class ProjetoApplication {
  
	public static void main(String[] args) {
		SpringApplication.run(ProjetoApplication.class, args);
		
		ProdutoController pdao = new ProdutoController();
		
		System.out.println(pdao.getByCategoria(1));
		
		
	}
}
