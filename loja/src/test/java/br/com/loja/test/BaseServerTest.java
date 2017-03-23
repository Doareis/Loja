package br.com.loja.test;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;

import br.com.loja.servidor.Servidor;

public class BaseServerTest {

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
	
}
