package br.com.temaproject.service;

import java.util.List;

import br.com.temaproject.model.Card;
import br.com.temaproject.model.Class;
import br.com.temaproject.model.Type;
import br.com.temaproject.repository.CardRepository;
import br.com.temaproject.repository.impl.CardRepositoryImpl;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.core.Response;

@Stateless
public class CardService {
	CardRepository cardRepository;
	
	public CardService() {
		cardRepository = new CardRepositoryImpl();
	}
	
	public List<Card>cardGetAll() {
		return (List<Card>) cardRepository.read();
	}
	
	public Card cardGetById(int id) {
		return cardRepository.read(id);
	}
	
	public Response cardPost(Card card) {
		boolean created;
		if(card.getAttack() < 0 || card.getAttack() > 10 || card.getDefense() < 0 || card.getDefense() > 10) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Incompatible body").build();
		}
		try{
			created = cardRepository.insert(card);
		} catch(Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
		if(created) {
			return Response.status(Response.Status.CREATED).entity(card).build();
		} else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error").build();
		}
	}
	
	public Response cardDelete(int id) {
		Card card = cardGetById(id);
		if(card == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		try {
			cardRepository.delete(id);
			return Response.status(Response.Status.OK).build();
		} catch(Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	public List<Card> cardGetByName(String name) {
		return (List<Card>) cardRepository.readByName(name);
	}
	
	public List<Card> cardGetByClass(Class className) {
		return (List<Card>) cardRepository.readByClass(className);
	}

	public List<Card> cardGetByType(Type type) {
		return (List<Card>) cardRepository.readByType(type);
	}
}
