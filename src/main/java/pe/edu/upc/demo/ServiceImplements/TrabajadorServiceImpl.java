package pe.edu.upc.demo.ServiceImplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.Entities.Trabajador;
import pe.edu.upc.demo.Repositories.ITrabajadorRepositoy;
import pe.edu.upc.demo.ServiceInterface.ITrabajadorService;

@Service
public class TrabajadorServiceImpl implements ITrabajadorService {

	@Autowired
	private ITrabajadorRepositoy trabajadorRepository;

	@Override
	public void insert(Trabajador trabajador) {

		trabajadorRepository.save(trabajador);

	}

	@Override
	public List<Trabajador> list() {

		return trabajadorRepository.findAll();
	}

	@Override
	public void delete(int idTrabajador) {

		trabajadorRepository.deleteById(idTrabajador);

	}

	@Override
	public Optional<Trabajador> listID(int idTrabajador) {

		return trabajadorRepository.findById(idTrabajador);
	}

	@Override
	public void update(Trabajador trabajador) {

		trabajadorRepository.save(trabajador);

	}

	@Override
	public List<String[]> CantidadTrabajadorepoRubro() {

		return trabajadorRepository.CantidadTrabajadorepoRubro();
	}

}
