package es.indra.spring2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import es.indra.spring2.model.Producto;

@Service
public interface ServiceProducto {
	public List<Producto> listarProducto();

	public Producto listarProdbyId(int id);

	public Producto guardarProducto(Producto producto);

	public Producto actualizarProducto(Producto producto);

	public void eliminarProducto(Producto producto);

	public boolean eliminarProcPorId(int id);

}
