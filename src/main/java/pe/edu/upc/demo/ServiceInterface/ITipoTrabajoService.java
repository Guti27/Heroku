package pe.edu.upc.demo.ServiceInterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.Entities.TipoTrabajo;

public interface ITipoTrabajoService {

	public void insert(TipoTrabajo tipoTrabajo);

	public List<TipoTrabajo> list();

	public void delete(int idTipoTrabajo);

	Optional<TipoTrabajo> listID(int idTipoTrabajo);

	public void update(TipoTrabajo tipoTrabajo);

}
