package br.com.loja.resource;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;

import com.google.gson.Gson;

import br.com.loja.dao.CarrinhoDAO;
import br.com.loja.modelo.Carrinho;

@Path("carrinhos")
public class CarrinhoResource {

	private CarrinhoDAO dao = new CarrinhoDAO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public JSONArray buscaTodos(){
		return  new JSONArray(dao.buscaTodos());
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Carrinho busca(@PathParam("id") long id){
		Carrinho carrinho = dao.busca(id);
		return carrinho;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insereCarrinho(String conteudo){
		Gson gson = new Gson();
		Carrinho carrinho = gson.fromJson(conteudo, Carrinho.class);
		dao.adiciona(carrinho);
		URI uri = URI.create("carrinhos/" + carrinho.getId());
		return Response.created(uri).build();
	}
}
