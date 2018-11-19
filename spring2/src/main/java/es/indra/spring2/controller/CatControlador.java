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

import es.indra.spring2.service.ServiceCategoria;

@RestController
public class CatControlador {

	@Autowired
	ServiceCategoria serviceCategoria;

	@RequestMapping(value = "/Categorias", method = RequestMethod.GET)
	public ResponseEntity<List<Categoria>> listarCategoria() {
		List<Categoria> allCategorias = this.serviceCategoria.listarCategoria();

		ResponseEntity<List<Categoria>> response = new ResponseEntity<List<Categoria>>(allCategorias, HttpStatus.OK);

		return response;
	}

	@RequestMapping(value = "/Categorias/{catid}", method = RequestMethod.GET)
	public ResponseEntity<Categoria> listarCatpbyId(@PathVariable("catid") int catid) {
		Categoria lc = this.serviceCategoria.listarCatbyId(catid);
		if (lc == null) {
			return new ResponseEntity<Categoria>(lc, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Categoria>(lc, HttpStatus.OK);
		}

	}

	@RequestMapping(value = "/Categorias", method = RequestMethod.POST)
	public ResponseEntity<Void> guardarCategoria(@RequestBody Categoria b) {
		this.serviceCategoria.guardarCategoria(b);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/Categorias", method = RequestMethod.PUT)
	public ResponseEntity<Categoria> actualizarCategoria(@RequestBody Categoria c) {
		Categoria ccat = this.serviceCategoria.actualizarCategoria(c);
		if (ccat == null) {
			return new ResponseEntity<Categoria>(ccat, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Categoria>(ccat, HttpStatus.OK);
		}

	}

	@RequestMapping(value = "/Categorias/{catid}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminarCatPorId(@PathVariable("catid") int catid) {
		boolean borrado = this.serviceCategoria.eliminarCatPorId(catid);
		if (borrado) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

		} else {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/Categorias", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminarCategoria(@RequestBody Categoria b) {
		this.serviceCategoria.eliminarCategoria(b);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}