package br.com.loja.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.junit.Assert;
import org.junit.Test;

import br.com.loja.modelo.Carrinho;

public class TestaBuscaCarrinho extends BaseServerTest {

	@Test
	public void testaServico(){
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080"); // TODO: ler do arquivo de propriedades
		
		Carrinho carrinho = Carrinho.fromString(
				target.path("/carrinhos/1").request().get(String.class));
		
		Assert.assertTrue(carrinho.getRua().equals("Rua Vergueiro 3185, 8 andar"));
	}
}
