package es.indra.spring2.model;




import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Categoria")
public class Categoria {

	@Id
	@GeneratedValue
	@Column(name = "categoria_id")

	int catid;
	String nombre;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public Set<Producto> productos;
	
	public Categoria () {
		
	}
public Categoria (int catid) {
		
	}
	public int getCatid() {
		return catid;
	}
	public void setCatid(int catid) {
		this.catid = catid;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	 public String toString(){
		 
		 return catid + nombre;
	 }
}
