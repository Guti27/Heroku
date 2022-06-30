package pe.edu.upc.demo.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.edu.upc.demo.Entities.AvisoTrabajo;

public interface IAvisoTrabajosRepository extends JpaRepository<AvisoTrabajo, Integer> {

	@Query(value = "select t.id_tipo_trabajo,t.rubro,count(at.id_aviso_trabajo) from avisotrabajo at join tipotrabajo t on at.id_tipo_Trabajo= t.id_tipo_trabajo group by t.id_tipo_trabajo,t.rubro", nativeQuery = true)
	public List<String[]> CantidadTipoTrabajo();

}
