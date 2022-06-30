package pe.edu.upc.demo.ServiceImplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.Entities.Postulante;
import pe.edu.upc.demo.Repositories.IPostulanteRepository;
import pe.edu.upc.demo.ServiceInterface.IPostulanteService;

@Service
public class PostulanteServiceImpl implements IPostulanteService {

	@Autowired
	private IPostulanteRepository postulanteRepository;

	@Override
	public void insert(Postulante postulante) {

		postulanteRepository.save(postulante);
	}

	@Override
	public List<Postulante> list() {

		return postulanteRepository.findAll();
	}

	@Override
	public void delete(int idPostulante) {

		postulanteRepository.deleteById(idPostulante);
	}

	@Override
	public Optional<Postulante> listID(int idPostulante) {

		return postulanteRepository.findById(idPostulante);
	}

	@Override
	public void update(Postulante postulante) {

		postulanteRepository.save(postulante);

	}

	@Override
	public List<String[]> PostulacionesTrabajo() {

		return postulanteRepository.PostulacionesTrabajo();
	}

}
