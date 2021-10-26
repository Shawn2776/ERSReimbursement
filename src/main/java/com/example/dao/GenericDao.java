package com.example.dao;

import java.util.List;

public interface GenericDao <T> // Generic Interface
{
	List<T> getAll();
	T getById(int id);
	T getByUsername(String username);
	void update(T entity);
	void insert(T entity);
	void delete(T entity);
}