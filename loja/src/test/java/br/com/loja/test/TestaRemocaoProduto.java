package br.com.loja.test;

import javax.ws.rs.core.Response;

import org.junit.Assert;
import org.junit.Test;

import br.com.loja.modelo.Carrinho;

public class TestaRemocaoProduto extends BaseServerTest{

	@Test
	public void test(){
		Response resposta = target.path("carrinhos/1/produto/3467").request().delete();
		Assert.assertEquals(Response.Status.OK.getStatusCode(), resposta.getStatus());
		Carrinho carrinho = Carrinho.fromString(target.path("carrinhos/1").request().get(String.class));
		
		Assert.assertEquals(1, carrinho.getProdutos().size());
	}
}
