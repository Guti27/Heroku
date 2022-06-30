package pe.edu.upc.demo.ServiceInterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.Entities.AvisoTrabajo;

public interface IAvisoTrabajoService {

	public void insert(AvisoTrabajo avisoTrabajo);

	public List<AvisoTrabajo> list();

	public void delete(int idAvisoTrabajo);

	Optional<AvisoTrabajo> listId(int idAvisoTrabajo);

	public void update(AvisoTrabajo AvisoTrabajo);
	
	public List<String[]>CantidadTipoTrabajo();
}
