package br.mywebapp.dao;

import javax.persistence.EntityManager;

import br.mywebapp.connection.ConnectionFactory;
import br.mywebapp.model.Categoria;

public class CategoriaDao {
	public Categoria save(Categoria categoria) {
		EntityManager em = ConnectionFactory.getConnection();
		try {
			em.getTransaction().begin();
			if (categoria.getId() == null) {
				em.persist(categoria);
			} else {
				em.merge(categoria);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return categoria;
 	}
}
