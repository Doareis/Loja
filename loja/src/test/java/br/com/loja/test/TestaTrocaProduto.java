package br.com.loja.test;

import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;

import br.com.loja.modelo.Carrinho;
import br.com.loja.modelo.Produto;

public class TestaTrocaProduto extends BaseServerTest {
	
	@Test
	public void test(){
		
		Produto produto = new Produto(6237, "XBox One", 2000.0, 2);
		Entity<String> entity = Entity.entity(new Gson().toJson(produto), MediaType.APPLICATION_JSON);
		target.path("carrinhos/1/produto/" + produto.getId()).request().put(entity);
		
		String conteudo = target.path("carrinhos/1").request().get(String.class);
		Carrinho carrinho = Carrinho.fromString(conteudo);
		
		List<Produto> produtos = carrinho.getProdutos();
		for(Produto produtoRetorno : produtos){
			if(produtoRetorno.getId() == produto.getId()){
				Assert.assertTrue(produtoRetorno.getNome().equals(produto.getNome()));
			}
		}
	}
}
