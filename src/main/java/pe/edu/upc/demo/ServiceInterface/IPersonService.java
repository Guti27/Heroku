package pe.edu.upc.demo.ServiceInterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.Entities.Person;

public interface IPersonService {
	
	public Integer insert(Person person);
	
	public Integer insert2(Person person);
	
	public void insert3(Person person);
	
	public List<Person> list();
	
	public void delete(int idPerson);
	Optional<Person> listID(int idPerson);
	
	public void update(Person person);

}
