package pe.edu.upc.demo.ServiceImplements;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.demo.Entities.Role;
import pe.edu.upc.demo.Entities.Users;
import pe.edu.upc.demo.Repositories.UserRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Busca al usuario con el repositorio
		Users user = userRepository.findByUsername(username);

		// Mapear una lista de authority con la de spring security
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		// Role_User, role_admin
		for (Role role : user.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getRol()));
		}

		// Crear un usuario UserDetails que va ir en sesion y retornarlo
		return new User(user.getUsername(), user.getPassword(), user.getEnabled(), true, true, true, authorities);
	}

}
