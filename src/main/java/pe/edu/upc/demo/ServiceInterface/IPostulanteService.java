package pe.edu.upc.demo.ServiceInterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.Entities.Postulante;

public interface IPostulanteService {

	public void insert(Postulante postulante);

	public List<Postulante> list();

	public void delete(int idPostulante);

	Optional<Postulante> listID(int idPostulante);

	public void update(Postulante postulante);

	public List<String[]> PostulacionesTrabajo();

}
