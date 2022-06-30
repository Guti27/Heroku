package pe.edu.upc.demo.ServiceInterface;

import java.util.List;

import pe.edu.upc.demo.Entities.Users;

public interface IUserService {
	public Integer insertar(Users u);

	List<Users> listar();

}
