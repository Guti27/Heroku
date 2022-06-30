package pe.edu.upc.demo.ServiceImplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.Entities.AvisoTrabajo;
import pe.edu.upc.demo.Repositories.IAvisoTrabajosRepository;
import pe.edu.upc.demo.ServiceInterface.IAvisoTrabajoService;

@Service
public class AvisoTrabajoServiceImpl implements IAvisoTrabajoService {
	@Autowired
	private IAvisoTrabajosRepository avisoTrabajoRepository;

	@Override
	public void insert(AvisoTrabajo avisoTrabajo) {

		avisoTrabajoRepository.save(avisoTrabajo);
	}

	@Override
	public List<AvisoTrabajo> list() {

		return avisoTrabajoRepository.findAll();
	}

	@Override
	public void delete(int idAvisoTrabajo) {
		avisoTrabajoRepository.deleteById(idAvisoTrabajo);

	}

	@Override
	public Optional<AvisoTrabajo> listId(int idAvisoTrabajo) {

		return avisoTrabajoRepository.findById(idAvisoTrabajo);
	}

	@Override
	public void update(AvisoTrabajo AvisoTrabajo) {
		avisoTrabajoRepository.save(AvisoTrabajo);

	}

	@Override
	public List<String[]> CantidadTipoTrabajo() {
		
		return avisoTrabajoRepository.CantidadTipoTrabajo();
	}

}
