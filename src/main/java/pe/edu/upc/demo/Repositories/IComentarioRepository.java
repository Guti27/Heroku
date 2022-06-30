package pe.edu.upc.demo.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.demo.Entities.Comentario;

@Repository
public interface IComentarioRepository extends JpaRepository<Comentario, Integer> {

	@Query(value = "select p.dni_person,p.name_person,count(com.id_comentario)\r\n"
			+ "from person p join trabajador t on p.id_person=t.id_person\r\n"
			+ "			join postulante pos on pos.trabajador=t.id_trabajador\r\n"
			+ "			join contrato c on c.id_tpostulante=pos.id_postulante\r\n"
			+ "			join comentario com on com.id_contrato=c.id_contrato\r\n"
			+ "			where com.add_comentario='Recomendado'\r\n"
			+ "group by p.dni_person,p.name_person", nativeQuery = true)
	public List<String[]> TrabajadorRecomendaciones();

}
