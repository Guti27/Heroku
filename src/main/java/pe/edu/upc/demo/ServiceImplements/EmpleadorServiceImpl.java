package pe.edu.upc.demo.ServiceImplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.Entities.Empleador;
import pe.edu.upc.demo.Repositories.IEmpleadorRepository;
import pe.edu.upc.demo.ServiceInterface.IEmpleadorService;



@Service
public class EmpleadorServiceImpl implements IEmpleadorService{
	@Autowired
	private IEmpleadorRepository empleadorRepository;

	@Override
	public void insert(Empleador empleador) {
		// TODO Auto-generated method stub
		empleadorRepository.save(empleador);
	}

	@Override
	public List<Empleador> list() {
		// TODO Auto-generated method stub
		return empleadorRepository.findAll();
	}

	@Override
	public void delete(int idEmpleador) {
		// TODO Auto-generated method stub
		empleadorRepository.deleteById(idEmpleador);
	}

	@Override
	public Optional<Empleador> listId(int idEmpleador) {
		// TODO Auto-generated method stub
		return empleadorRepository.findById(idEmpleador);
	}

	@Override
	public void update(Empleador empleador) {
		// TODO Auto-generated method stub
		empleadorRepository.save(empleador);
	}

	

}
