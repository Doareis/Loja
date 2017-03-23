package br.com.loja.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.loja.modelo.Carrinho;

public class TestaBuscaCarrinho extends BaseServerTest {

	@Test
	public void testaServico(){
		
		Carrinho carrinho = Carrinho.fromString(
				target.path("/carrinhos/1").request().get(String.class));
		
		Assert.assertTrue(carrinho.getRua().equals("Rua Vergueiro 3185, 8 andar"));
	}
}
