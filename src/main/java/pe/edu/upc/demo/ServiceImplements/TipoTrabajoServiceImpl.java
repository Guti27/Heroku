package pe.edu.upc.demo.ServiceImplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.Entities.TipoTrabajo;
import pe.edu.upc.demo.Repositories.ITipoTrabajoRepository;
import pe.edu.upc.demo.ServiceInterface.ITipoTrabajoService;

@Service
public class TipoTrabajoServiceImpl implements ITipoTrabajoService {
	
	@Autowired
	private ITipoTrabajoRepository tipoTrabajoRepository;

	@Override
	public void insert(TipoTrabajo tipoTrabajo) {
		// TODO Auto-generated method stub
		tipoTrabajoRepository.save(tipoTrabajo);
	}

	@Override
	public List<TipoTrabajo> list() {
		// TODO Auto-generated method stub
		return tipoTrabajoRepository.findAll();
	}

	@Override
	public void delete(int idTipoTrabajo) {
		// TODO Auto-generated method stub
		tipoTrabajoRepository.deleteById(idTipoTrabajo);
	}

	@Override
	public Optional<TipoTrabajo> listID(int idTipoTrabajo) {
		// TODO Auto-generated method stub
		return tipoTrabajoRepository.findById(idTipoTrabajo);
	}

	@Override
	public void update(TipoTrabajo tipoTrabajo) {
		// TODO Auto-generated method stub
		tipoTrabajoRepository.save(tipoTrabajo);
	}

}
