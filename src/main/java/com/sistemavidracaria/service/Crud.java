package com.sistemavidracaria.service;

import java.util.List;

public interface Crud <T> {

	public void salvar(T t);
	public void excluir(int id);
	public void atualizar(T t);
	public List<T> listarTodos();
	
}
