package pe.edu.upc.demo;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import pe.edu.upc.demo.Entities.Role;
import pe.edu.upc.demo.Entities.Users;
import pe.edu.upc.demo.Repositories.UserRepository;

@SpringBootTest
class EasyChambaApplicationTests {

	@Autowired
	private UserRepository userepo;

	@Autowired
	private BCryptPasswordEncoder enco;

	@Test
	void contextLoads() {
		//Role rol = new Role();
		//rol.setId((long) 1);
		//rol.setRol("ROLE_ADMIN");
		
		//Users us = new Users();
		//us.setId((long) 1);
		//us.setUsername("admin");
		//us.setRoles(1);
		//us.setPassword(enco.encode("web"));
		//Users retorno = userepo.save(us);
		//assertTrue(retorno.getPassword().equalsIgnoreCase(us.getPassword()));	
	}

}
