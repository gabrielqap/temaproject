package br.com.temaproject.repository;

import java.util.Collection;

public interface GameRepository<T> {
	void delete(int id);
	boolean insert(T item);
	T read(int id);
	Collection<T> read();
}
