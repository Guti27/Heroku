package pe.edu.upc.demo.ServiceInterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.Entities.Contrato;

public interface IContratoService {

	public void insert(Contrato contrato);

	public List<Contrato> list();

	public void delete(int idcontrato);

	Optional<Contrato> listID(int idcontrato);

	public void update(Contrato contrato);

	public List<String[]> SueldoPromedioRubro();

}
