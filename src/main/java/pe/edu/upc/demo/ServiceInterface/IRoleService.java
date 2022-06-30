package pe.edu.upc.demo.ServiceInterface;

import java.util.List;

import pe.edu.upc.demo.Entities.Role;

public interface IRoleService {
	public void insertar(Role r);

	List<Role> listar();

}
