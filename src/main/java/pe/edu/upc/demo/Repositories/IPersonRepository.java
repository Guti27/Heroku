package pe.edu.upc.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.demo.Entities.Person;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Integer> {
	@Query("select count(p.dniPerson) from Person p where p.dniPerson =:dniPerson")
	public int findByDNI(@Param("dniPerson") String dniPerson);
	
	@Query("select count(p.emailPerson) from Person p where p.emailPerson =:emailPerson")
	public int findByEmail(@Param("emailPerson") String emailPerson);

}
