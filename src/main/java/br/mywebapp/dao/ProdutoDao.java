package br.mywebapp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.mywebapp.connection.ConnectionFactory;
import br.mywebapp.model.Produto;

public class ProdutoDao {
	public Produto save(Produto produto) {
		EntityManager em = ConnectionFactory.getConnection();

		try {
			em.getTransaction().begin();
			em.persist(produto);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return produto;
	}

	public List<Produto> listarTodas() {
		EntityManager em = ConnectionFactory.getConnection();
		
		List<Produto> produtos = null;
		try {
			produtos = em.createQuery("from Produto p").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return produtos;
	}
}
