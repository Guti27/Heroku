package pe.edu.upc.demo.ServiceImplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.Entities.Comentario;
import pe.edu.upc.demo.Repositories.IComentarioRepository;
import pe.edu.upc.demo.ServiceInterface.IComentarioService;

@Service
public class ComentarioServiceImpl implements IComentarioService {

	@Autowired
	private IComentarioRepository comentarioRepository;

	@Override
	public void insert(Comentario comentario) {
		// TODO Auto-generated method stub
		comentarioRepository.save(comentario);
	}

	@Override
	public List<Comentario> list() {
		// TODO Auto-generated method stub
		return comentarioRepository.findAll();
	}

	@Override
	public void delete(int idComentario) {
		// TODO Auto-generated method stub
		comentarioRepository.deleteById(idComentario);
	}

	@Override
	public Optional<Comentario> listIdComentario(int idComentario) {
		// TODO Auto-generated method stub
		return comentarioRepository.findById(idComentario);
	}

	@Override
	public void update(Comentario comentario) {
		// TODO Auto-generated method stub
		comentarioRepository.save(comentario);
	}

	@Override
	public List<String[]> TrabajadorRecomendaciones() {
		return comentarioRepository.TrabajadorRecomendaciones();
	}

}
