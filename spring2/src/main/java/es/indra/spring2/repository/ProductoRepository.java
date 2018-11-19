package es.indra.spring2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.indra.spring2.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
