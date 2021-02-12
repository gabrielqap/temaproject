package br.com.temaproject.controller;

import java.util.List;

import br.com.temaproject.model.Card;
import br.com.temaproject.model.Class;
import br.com.temaproject.model.Type;
import br.com.temaproject.service.CardService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/carta")
public class CardController {
	private static CardService cardService = new CardService();
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public List<Card> get() {
        return cardService.cardGetAll();
    }
	
	@GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Card getById(@PathParam("id") int id) {
        return cardService.cardGetById(id);
    }
	
	@GET
    @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Card> getById(@PathParam("name") String name) {
        return cardService.cardGetByName(name);
    }
	
	@GET
    @Path("/class/{class}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Card> getByClass(@PathParam("class") Class cardClass) {
        return cardService.cardGetByClass(cardClass);
    }
	
	@GET
    @Path("/type/{type}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Card> getByType(@PathParam("type") Type type) {
        return cardService.cardGetByType(type);
    }
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response post(Card card) {
		return cardService.cardPost(card);
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") int id) {
		return cardService.cardDelete(id);
	}
}
