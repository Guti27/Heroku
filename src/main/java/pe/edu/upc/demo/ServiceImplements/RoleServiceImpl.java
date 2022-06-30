package pe.edu.upc.demo.ServiceImplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.Entities.Role;
import pe.edu.upc.demo.Repositories.RoleRepository;
import pe.edu.upc.demo.ServiceInterface.IRoleService;



@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private RoleRepository rr;

	@Override
	public void insertar(Role r) {
		// TODO Auto-generated method stub
		rr.save(r);
	}

	@Override
	public List<Role> listar() {
		// TODO Auto-generated method stub
		return rr.findAll();
	}

}
