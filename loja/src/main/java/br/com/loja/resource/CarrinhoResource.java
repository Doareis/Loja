package br.com.loja.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.loja.dao.CarrinhoDAO;
import br.com.loja.modelo.Carrinho;

@Path("carrinhos")
public class CarrinhoResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String busca(){
		CarrinhoDAO dao = new CarrinhoDAO();
		Carrinho carrinho = dao.busca(1L);
		return carrinho.toXML();
	}
}
