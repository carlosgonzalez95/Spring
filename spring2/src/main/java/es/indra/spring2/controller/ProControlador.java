package es.indra.spring2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.indra.spring2.model.Categoria;
import es.indra.spring2.model.Producto;
import es.indra.spring2.service.ServiceCategoria;
import es.indra.spring2.service.ServiceProducto;

@RestController
public class ProControlador {

	@Autowired
	ServiceProducto serviceProducto;
	

	@RequestMapping(value = "/Productos", method = RequestMethod.GET)
	public ResponseEntity<List<Producto>> listarProducto() {
		List<Producto> productos = this.serviceProducto.listarProducto();
		

		ResponseEntity<List<Producto>> response = new ResponseEntity<List<Producto>>(productos, HttpStatus.OK);

		return response;
	}

	@RequestMapping(value = "/Productos/{id}", method = RequestMethod.GET)
	public ResponseEntity<Producto> listarProdbyId(@PathVariable("id") int id) {
		Producto lp = this.serviceProducto.listarProdbyId(id);
		if (lp == null) {
			return new ResponseEntity<Producto>(lp, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Producto>(lp, HttpStatus.OK);

		}
	}

	@RequestMapping(value = "/Productos", method = RequestMethod.POST)
	public ResponseEntity<Void> guardarProducto(@RequestBody  Producto b) {
		this.serviceProducto.guardarProducto(b);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/Productos", method = RequestMethod.PUT)
	public ResponseEntity<Producto> actualizarProducto(@RequestBody Producto p) {
		Producto cprod = this.serviceProducto.actualizarProducto(p);
		if (cprod == null) {
			return new ResponseEntity<Producto>(cprod, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Producto>(cprod, HttpStatus.OK);
		}

	}
	@RequestMapping(value = "/Productos/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminarProcPorId(@PathVariable("id") int id) {
		boolean borrado = this.serviceProducto.eliminarProcPorId(id);
		if (borrado) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

		} else {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	@RequestMapping(value = "/Productos", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminarProducto(@RequestBody Producto b) {
		this.serviceProducto.eliminarProducto(b);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
