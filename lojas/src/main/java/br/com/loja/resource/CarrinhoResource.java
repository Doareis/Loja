package br.com.loja.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import br.com.loja.dao.CarrinhoDAO;
import br.com.loja.modelo.Carrinho;

@Path("carrinhos")
public class CarrinhoResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String buscaTodos(){
		CarrinhoDAO dao = new CarrinhoDAO();
		List<Carrinho> carrinhos = dao.buscaTodos();
		return new Gson().toJson(carrinhos);
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String busca(@PathParam("id") long id){
		CarrinhoDAO dao = new CarrinhoDAO();
		Carrinho carrinho = dao.busca(id);
		return carrinho.toXML();
	}
}
