package es.indra.spring2.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.indra.spring2.model.Categoria;
import es.indra.spring2.repository.CategoriaRepository;
import es.indra.spring2.service.ServiceCategoria;

@Component
class ServiceCatImpl implements ServiceCategoria {

	@Autowired
	CategoriaRepository categoriarepository;

	@Override
	public List<Categoria> listarCategoria() {
		return this.categoriarepository.findAll();
	}

	@Override
	public Categoria listarCatbyId(int catid) {
		Optional<Categoria> catOp = this.categoriarepository.findById(catid);
		if (catOp.isPresent()) {
			return catOp.get();
		} else {
			return null;
		}

	}

	@Override
	public Categoria guardarCategoria(Categoria categoria) {

		return this.categoriarepository.save(categoria);
	}

	@Override
	public void eliminarCategoria(Categoria categoria) {
		this.categoriarepository.delete(categoria);
	}

	@Override
	public Categoria actualizarCategoria(Categoria categoria) {
		if (this.categoriarepository.findById(categoria.getCatid()).isPresent()) {
			return this.categoriarepository.save(categoria);
		}
		return null;
	}

	@Override
	public boolean eliminarCatPorId(int catid) {
		Optional<Categoria> ct = this.categoriarepository.findById(catid);
		if (ct.isPresent()) {
			Categoria categoria = ct.get();
			this.categoriarepository.delete(categoria);
			return true;

		} else {
			return false;
		}

	}
}
