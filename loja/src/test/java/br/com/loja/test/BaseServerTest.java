package br.com.loja.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;

import br.com.loja.servidor.Servidor;

public class BaseServerTest {

	protected static final String URI_LOCATION = "http://localhost:8080"; // TODO: ler do arquivo de propriedades
	protected HttpServer httpServer;
	protected WebTarget target;
	protected Client client;
	
	@Before
	public void iniciaServidor(){
		Servidor servidor = new Servidor();
		System.out.println("Starting server");
		httpServer = servidor.inicia();
		
		client = ClientBuilder.newClient();
		target = client.target(URI_LOCATION);
	}
	
	@After
	public void finaliza(){
		System.out.println("Shutting server down");
		httpServer.shutdown();
	}
	
}
