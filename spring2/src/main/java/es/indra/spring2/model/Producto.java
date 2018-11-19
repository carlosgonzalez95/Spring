package es.indra.spring2.model;

import javax.persistence.Entity;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
@Table(name = "Productos")
public class Producto  {

	@Id
	@GeneratedValue
	int id;
	String nombre;

	@ManyToOne
	@JoinColumn(name = "categoria_id")
	@JsonBackReference
	public Categoria categoria;
	
	public Producto() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
