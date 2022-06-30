package pe.edu.upc.demo.Controllers;

import java.util.Arrays;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import pe.edu.upc.demo.Entities.Role;
import pe.edu.upc.demo.Entities.Users;
import pe.edu.upc.demo.Repositories.RoleRepository;
import pe.edu.upc.demo.Repositories.UserRepository;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	boolean alreadySetup = false;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		 /*Users user = new Users(); user.setId((long) 1); user.setUsername("admin");
		 user.setPassword("123"); user.setPassword(passwordEncoder.encode("123"));
		 //user.setRoles(roleRepository.findByRol("ROLE_ADMIN"));
		 //user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
		 user.setEnabled(true); userRepository.save(user);
		 
		 //Users user2 = new Users(); //user2.setUsername("user");
		 //user2.setPassword("123");
		 //user2.setPassword(passwordEncoder.encode("123"));
		 //user2.setRoles(roleRepository.findByRol("ROLE_USER"));
		 //user2.setEnabled(true); //userRepository.save(user2);
		 
		 Role rol = new Role(); rol.setRol("ROLE_ADMIN"); rol.setUser(user);
		 roleRepository.save(rol);
		 
		 //Role rol2 = new Role(); //rol2.setRol("ROLE_USER");
		 //roleRepository.save(rol2);
		 
		 alreadySetup = true;*/
		 
	}
}
