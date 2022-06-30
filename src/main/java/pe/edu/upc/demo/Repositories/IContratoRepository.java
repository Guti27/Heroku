package pe.edu.upc.demo.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.edu.upc.demo.Entities.Contrato;

public interface IContratoRepository extends JpaRepository<Contrato, Integer> {

	@Query(value = "select tt.id_tipo_trabajo,tt.rubro,avg(c.sueldo)\r\n"
			+ "from tipotrabajo tt join trabajador t on tt.id_tipo_trabajo=t.id_tipo_trabajo\r\n"
			+ "			join postulante pos on pos.trabajador=t.id_trabajador\r\n"
			+ "			join contrato c on c.id_tpostulante=pos.id_postulante\r\n"
			+ "group by tt.id_tipo_trabajo,tt.rubro", nativeQuery = true)
	public List<String[]> SueldoPromedioRubro();
}
