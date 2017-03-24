package br.com.loja.test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Assert;
import org.junit.Test;

import br.com.loja.modelo.Carrinho;
import br.com.loja.modelo.Produto;

public class TestaAdicaoCarrinho extends BaseServerTest{

	@Test
	public void test(){
		Carrinho carrinho = new Carrinho();
		carrinho.adiciona(new Produto(123L, "Impressora multifuncional", 500.0, 1));
		carrinho.setRua("Av Paulista, 1000");
		carrinho.setCidade("São Paulo");
		carrinho.setId(2L);
		
		Entity<Carrinho> entity = Entity.entity(carrinho, MediaType.APPLICATION_XML);
		Response resposta = target.path("/carrinhos").request().post(entity);
		
		// verifica o status da resposta
		Assert.assertEquals(Response.Status.CREATED.getStatusCode(), resposta.getStatus());

		String location = resposta.getHeaderString("Location");
		Carrinho carrinhoResposta = client.target(location).request().get(Carrinho.class);
		
		Assert.assertTrue(carrinhoResposta.getProdutos().isEmpty() == false);
		Assert.assertTrue(carrinhoResposta.getProdutos().get(0).getNome().equals("Impressora multifuncional"));
	}
}
