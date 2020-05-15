package br.mywebapp.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.mywebapp.FacesMessages;
import br.mywebapp.dao.ProdutoDao;
import br.mywebapp.model.Produto;

@Named
@RequestScoped
public class ProdutoController implements Serializable{

	private static final long serialVersionUID = 1L;
	Produto produto = new Produto();
	ProdutoDao dao = new ProdutoDao();
	private FacesMessages msg = new FacesMessages();
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public List<Produto> getProdutos() {
		 List<Produto> produtos = new ArrayList<>();
		 produtos = dao.listarTodas();
		return produtos;
	}

	public void save() {
		dao.save(produto);
		produto = new Produto();
		msg.info("Cadastro realizado com sucesso!");
	}
}
