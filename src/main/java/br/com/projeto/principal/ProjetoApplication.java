package br.com.projeto.principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.projeto.controller.CategoriaController;
import br.com.projeto.entidades.Categoria;

@SpringBootApplication
public class ProjetoApplication {
  
	public static void main(String[] args) {
		Categoria categoria = new Categoria();
		SpringApplication.run(ProjetoApplication.class, args);
		CategoriaController cc = new CategoriaController();
		
		categoria = cc.getCategoria(1);
		cc.updateCategoria(categoria, new String[] {"testandoUpdateFalha"});
		
	}
}
