package br.com.loja.test;

import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import org.junit.Assert;
import org.junit.Test;

import br.com.loja.modelo.Carrinho;
import br.com.loja.modelo.Produto;

public class TestaTrocaProduto extends BaseServerTest {
	
	@Test
	public void test(){
		
		Produto produto = new Produto(6237, "XBox One", 2000.0, 2);
		Entity<Produto> entity = Entity.entity(produto, MediaType.APPLICATION_XML);
		target.path("carrinhos/1").request().put(entity);
		Carrinho carrinho = target.path("carrinhos/1").request().get(Carrinho.class);
		
		// verifica alteracao
		List<Produto> produtos = carrinho.getProdutos();
		for(Produto produtoRetorno : produtos){
			if(produtoRetorno.getId() == produto.getId()){
				Assert.assertTrue(produtoRetorno.getNome().equals(produto.getNome()));
			}
		}
	}
}
