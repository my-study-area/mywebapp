package br.mywebapp.dao;

import java.util.List;

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
	
	public List<Categoria >findAll() {
		EntityManager em = ConnectionFactory.getConnection();
		List<Categoria> categorias = null;
		try {
			categorias = em.createQuery("from Categoria c").getResultList();
		} catch (Exception e) {
			System.err.println();
		} finally {
				em.close();
		}
		return categorias;
	}
	
	public Categoria remove(Integer id) {
		EntityManager em = ConnectionFactory.getConnection();
		Categoria categoria = null;
		try {
			em.getTransaction().begin();
			categoria = em.find(Categoria.class, id);
			em.remove(categoria);
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
