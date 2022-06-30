package pe.edu.upc.demo.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.edu.upc.demo.Entities.Postulante;

public interface IPostulanteRepository extends JpaRepository<Postulante, Integer> {

	@Query(value = "select at.id_aviso_trabajo,t.rubro,count(p.id_postulante) from postulante p join avisotrabajo at on p.aviso_trabajo=at.id_aviso_trabajo join tipotrabajo t on t.id_tipo_trabajo=at.id_tipo_Trabajo group by at.id_aviso_trabajo,t.rubro", nativeQuery = true)
	public List<String[]> PostulacionesTrabajo();
}
