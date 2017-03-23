package br.com.loja.test;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
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
		
		URI uri = URI.create("http://localhost:8080");
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(uri);
		
		Entity<String> entity = Entity.entity(carrinho.toJson(), MediaType.APPLICATION_JSON);
		Response resposta = target.path("/carrinhos").request().post(entity);
		
		// verifica o status da resposta
		Assert.assertEquals(201, resposta.getStatus());

		String location = resposta.getHeaderString("Location");
		String carrinhoInserido = client.target(location).request().get(String.class);
		Carrinho carrinhoResposta = Carrinho.fromString(carrinhoInserido);
		
		Assert.assertTrue(carrinhoResposta.getProdutos().isEmpty() == false);
		Assert.assertTrue(carrinhoResposta.getProdutos().get(0).getNome().equals("Impressora multifuncional"));
	}
}
