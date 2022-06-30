package pe.edu.upc.demo.ServiceInterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.Entities.Comentario;

public interface IComentarioService {

	public void insert(Comentario comentario);

	public List<Comentario> list();

	public void delete(int idComentario);

	Optional<Comentario> listIdComentario(int idComentario);

	public void update(Comentario comentario);

	public List<String[]> TrabajadorRecomendaciones();

}
