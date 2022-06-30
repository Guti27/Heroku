package pe.edu.upc.demo.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.edu.upc.demo.Entities.Trabajador;

public interface ITrabajadorRepositoy extends JpaRepository<Trabajador, Integer> {

	@Query(value = "select  tt.id_tipo_trabajo,tt.rubro,count(id_trabajador) from trabajador t join tipotrabajo tt on t.id_tipo_trabajo=tt.id_tipo_trabajo join person p on p.id_person=t.id_person group by tt.id_tipo_trabajo,tt.rubro", nativeQuery = true)
	public List<String[]> CantidadTrabajadorepoRubro();
}
