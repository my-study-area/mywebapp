package br.mywebapp.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.mywebapp.model.Categoria;

public class TesteJPA {

	public static void main(String[] args) {
		System.out.println("TesteJPA");
		
		Categoria categoria = new Categoria();
		categoria.setDescricao("bebida");
		
		new Persistence();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mywebappPU");
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			em.persist(categoria);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.err.println(e);
		} finally {
			em.close();
		}
		
		emf.close();
		
		
		
	}
}
