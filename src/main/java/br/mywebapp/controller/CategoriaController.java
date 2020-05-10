package br.mywebapp.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.mywebapp.dao.CategoriaDao;
import br.mywebapp.model.Categoria;

@Named
@RequestScoped
public class CategoriaController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	public CategoriaController() {
	}

	private Categoria categoria = new Categoria();
	private CategoriaDao dao = new CategoriaDao();


	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public void save() {
		dao.save(categoria);
		categoria = new Categoria();
	}

	public List<Categoria> getCategorias() {
		 List<Categoria> categorias = new ArrayList<>();
		 categorias = dao.findAll();
		return categorias;
	}

	public String remove(Integer id) {
		dao.remove(id);
		return null;
	}

	public CategoriaDao getDao() {
		return dao;
	}

	public void setDao(CategoriaDao dao) {
		this.dao = dao;
	}
}
