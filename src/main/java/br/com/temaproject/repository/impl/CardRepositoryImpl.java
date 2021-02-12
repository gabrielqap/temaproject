package br.com.temaproject.repository.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import br.com.temaproject.model.Card;
import br.com.temaproject.model.Class;
import br.com.temaproject.model.Type;
import br.com.temaproject.repository.CardRepository;
import jakarta.ejb.Stateless;

@Stateless
public class CardRepositoryImpl implements CardRepository {
	
	private HashMap<Integer, Card> cards;
	
	public CardRepositoryImpl() {
		cards = new HashMap<>();
	}
	
	@Override
	public void delete(int id) {
		cards.remove(id);
	}

	@Override
	public boolean insert(Card card) {
		Iterator<Entry<Integer, Card>> it = cards.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, Card> set = (Map.Entry<Integer, Card>) it.next();
			Card cardIt = set.getValue();
			if(cardIt.getName().equals(card.getName())) {
				return false;
			}
		}
		card.setId(generateId(cards.size() + 1));
		cards.put(card.getId(), card);
		return true;
	}

	@Override
	public Card read(int id) {
		return cards.get(id);
	}

	@Override
	public Collection<Card> read() {
		return new ArrayList<Card>(cards.values());
	}
	
	private int generateId(final int possible)
    {
        if(cards.containsKey(possible)) {
             return generateId(possible + 1);
        }
        return possible;
    }

	@Override
	public Collection<Card> readByName(String name) {
		List<Card> cardsToReturn = new ArrayList<>();
		Iterator<Entry<Integer, Card>> it = cards.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, Card> set = (Map.Entry<Integer, Card>) it.next();
			if(set.getValue().getName().equals(name)) {
				cardsToReturn.add(set.getValue());
			}
		}
		return cardsToReturn;
	}
	
	@Override
	public Collection<Card> readByClass(Class className) {
		List<Card> cardsToReturn = new ArrayList<>();
		Iterator<Entry<Integer, Card>> it = cards.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, Card> set = (Map.Entry<Integer, Card>) it.next();
			if(set.getValue().getCardClass().equals(className)) {
				cardsToReturn.add(set.getValue());
			}
		}
		return cardsToReturn;
	}

	@Override
	public Collection<Card> readByType(Type type) {
		List<Card> cardsToReturn = new ArrayList<>();
		Iterator<Entry<Integer, Card>> it = cards.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, Card> set = (Map.Entry<Integer, Card>) it.next();
			if(set.getValue().getType().equals(type)) {
				cardsToReturn.add(set.getValue());
			}
		}
		return cardsToReturn;
	}
}
