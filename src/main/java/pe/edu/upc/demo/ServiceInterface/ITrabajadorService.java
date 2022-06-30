package pe.edu.upc.demo.ServiceInterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.Entities.Trabajador;

public interface ITrabajadorService {

	public void insert(Trabajador trabajador);

	public List<Trabajador> list();

	public void delete(int idTrabajador);

	Optional<Trabajador> listID(int idTrabajador);

	public void update(Trabajador trabajador);

	public List<String[]> CantidadTrabajadorepoRubro();

}
