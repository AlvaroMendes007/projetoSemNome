package br.com.projeto.principal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.projeto.dao.CategoriaDAO;
import br.com.projeto.entidades.Categoria;
import br.com.projeto.dao.Dao;

@SpringBootApplication
public class ProjetoApplication {
		
	static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("projeto");
	static EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
	
	public static void main(String[] args) {
		Categoria categoria = new Categoria();
		SpringApplication.run(ProjetoApplication.class, args);

		categoria.setNome("testeCategoria10");

		saveCategoria(categoria);
	}
	
	private static class CategoriaDaoHolder {
        private static final CategoriaDAO categoriaDAO = new CategoriaDAO(entityManager);
    }
	
	public static void saveCategoria(Categoria categoria) {
		getCategoriaDao().save(categoria);
    }
	
	public static Dao getCategoriaDao() {
        return CategoriaDaoHolder.categoriaDAO;
    }

}
