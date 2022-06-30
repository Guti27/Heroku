package pe.edu.upc.demo.ServiceInterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.Entities.Empleador;



public interface IEmpleadorService {
	public void insert(Empleador empleador);
	
	public List<Empleador> list();
	
	public void delete(int idEmpleador);
	
	Optional<Empleador> listId(int idEmpleador);
	
	public void update(Empleador empleador);

}
