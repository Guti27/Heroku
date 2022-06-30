package pe.edu.upc.demo.ServiceImplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.Entities.Contrato;
import pe.edu.upc.demo.Repositories.IContratoRepository;
import pe.edu.upc.demo.ServiceInterface.IContratoService;

@Service
public class ContratoServiceImpl implements IContratoService {

	@Autowired
	private IContratoRepository contratoRepository;

	@Override
	public void insert(Contrato contrato) {

		contratoRepository.save(contrato);
	}

	@Override
	public List<Contrato> list() {

		return contratoRepository.findAll();
	}

	@Override
	public void delete(int idcontrato) {

		contratoRepository.deleteById(idcontrato);
	}

	@Override
	public Optional<Contrato> listID(int idcontrato) {
		// TODO Auto-generated method stub
		return contratoRepository.findById(idcontrato);
	}

	@Override
	public void update(Contrato contrato) {

		contratoRepository.save(contrato);
	}

	@Override
	public List<String[]> SueldoPromedioRubro() {

		return contratoRepository.SueldoPromedioRubro();
	}

}
