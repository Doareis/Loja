package br.com.loja.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
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
		return this.id;
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

	public String toJson() {
		return new Gson().toJson(this);
	}

	public static Carrinho fromString(String carrinho) {
		return new Gson().fromJson(carrinho, Carrinho.class);
	}

	public String toXml() {
		return new XStream().toXML(this);
	}
	
}
