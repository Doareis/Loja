package br.com.loja.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.loja.modelo.Carrinho;
import br.com.loja.servidor.Servidor;

public class TestaServico {

	private HttpServer httpServer;
	
	@Before
	public void iniciaServidor(){
		Servidor servidor = new Servidor();
		System.out.println("Starting server");
		httpServer = servidor.inicia();
	}
	
	@After
	public void finaliza(){
		System.out.println("Shutting server down");
		httpServer.shutdown();
	}
	
	@Test
	public void testaServico(){
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080"); // TODO: ler do arquivo de propriedades
		
		String carrinhoJson = target.path("/carrinhos").request().get(String.class);
		
		Carrinho carrinho = Carrinho.fromString(carrinhoJson);
		Assert.assertTrue(carrinho.getRua().equals("Rua Vergueiro 3185, 8 andar"));
	}
}
