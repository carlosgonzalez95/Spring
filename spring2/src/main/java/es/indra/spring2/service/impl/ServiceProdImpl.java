package es.indra.spring2.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.indra.spring2.model.Producto;

import es.indra.spring2.repository.ProductoRepository;

import es.indra.spring2.service.ServiceProducto;

@Component
public class ServiceProdImpl implements ServiceProducto {
	@Autowired
	ProductoRepository productorepository;

	@Override
	public List<Producto> listarProducto() {
		return this.productorepository.findAll();
	}

	@Override
	public Producto listarProdbyId(int id) {
		Optional<Producto> proOp = this.productorepository.findById(id);
		if (proOp.isPresent()) {
			return proOp.get();
		} else {
			return null;
		}

	}

	@Override
	public Producto guardarProducto(Producto producto) {

		return this.productorepository.save(producto);
	}

	@Override
	public void eliminarProducto(Producto producto) {
		this.productorepository.delete(producto);
	}

	@Override
	public Producto actualizarProducto(Producto producto) {
		if (this.productorepository.findById(producto.getId()).isPresent()) {
			return this.productorepository.save(producto);
		}
		return null;
	}

	@Override
	public boolean eliminarProcPorId(int id) {
		Optional<Producto> pr = this.productorepository.findById(id);
		if (pr.isPresent()) {
			Producto producto = pr.get();
			this.productorepository.delete(producto);
			return true;

		} else {
			return false;
		}

	}

}
