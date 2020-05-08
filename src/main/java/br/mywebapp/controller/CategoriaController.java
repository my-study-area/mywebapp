package br.mywebapp.controller;

import java.io.Serializable;

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
	private CategoriaDao dao= new CategoriaDao();


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

}
