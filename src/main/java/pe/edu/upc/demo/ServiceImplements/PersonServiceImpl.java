package pe.edu.upc.demo.ServiceImplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.Entities.Person;
import pe.edu.upc.demo.Repositories.IPersonRepository;
import pe.edu.upc.demo.ServiceInterface.IPersonService;

@Service
public class PersonServiceImpl implements IPersonService {

	@Autowired
	private IPersonRepository personRepository;
	int rpta = 0;
	int rpta2 = 0;

	@Override
	public Integer insert(Person person) {
		rpta = personRepository.findByDNI(person.getDniPerson());
		return rpta;
	}

	@Override
	public Integer insert2(Person person) {
		rpta2 = personRepository.findByEmail(person.getEmailPerson());
		return rpta2;
	}

	@Override
	public void insert3(Person person) {
		personRepository.save(person);
	}

	@Override
	public List<Person> list() {
		// TODO Auto-generated method stub
		return personRepository.findAll();
	}

	@Override
	public void delete(int idPerson) {
		// TODO Auto-generated method stub
		personRepository.deleteById(idPerson);
	}

	@Override
	public Optional<Person> listID(int idPerson) {
		// TODO Auto-generated method stub
		return personRepository.findById(idPerson);
	}

	@Override
	public void update(Person person) {
		// TODO Auto-generated method stub
		personRepository.save(person);
	}

}
