package es.indra.spring2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import es.indra.spring2.model.Categoria;

@Service
public interface ServiceCategoria {

	public List<Categoria> listarCategoria();
	


	public Categoria listarCatbyId(int catid);

	public Categoria guardarCategoria(Categoria categoria);

	public Categoria actualizarCategoria(Categoria categoria);

	public void eliminarCategoria(Categoria categoria);

	public boolean eliminarCatPorId(int catid);

}