package br.com.temaproject.repository;

import java.util.Collection;

import br.com.temaproject.model.Card;
import br.com.temaproject.model.Class;
import br.com.temaproject.model.Type;

public interface CardRepository extends GameRepository<Card>{
	Collection<Card> readByName(String name);
	Collection<Card> readByClass(Class className);
	Collection<Card> readByType(Type type);
}
