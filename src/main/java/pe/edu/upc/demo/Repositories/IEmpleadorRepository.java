package pe.edu.upc.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.demo.Entities.Empleador;

@Repository
public interface IEmpleadorRepository extends JpaRepository<Empleador, Integer>{

}
