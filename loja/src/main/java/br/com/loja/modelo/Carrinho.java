package br.com.loja.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class Carrinho implements Serializable{

	private static final long serialVersionUID = 6719631551295787414L;
	
	private List<Produto> produtos = new ArrayList<Produto>();
	private String rua;
	private String cidade;
	private long id;

	public void adiciona(Produto produto) {
		produtos.add(produto);
	}

	public void para(String rua, String cidade) {
		this.rua = rua;
		this.cidade = cidade;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}
	
	public String getCidade(){
		return this.cidade;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public long getId() {
		return id;
	}
	
	public void remove(long id) {
		Produto produto = new Produto();
		produto.setId(id);
		produtos.remove(produto);
	}
	
	public void troca(Produto produto) {
		remove(produto.getId());
		adiciona(produto);
	}

	public void trocaQuantidade(Produto produto) {
		for (Produto p : produtos) {
			if(p.getId() == produto.getId()) {
				p.setQuantidade(produto.getQuantidade());
				return;
			}
		}
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public String toXML() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}

}
