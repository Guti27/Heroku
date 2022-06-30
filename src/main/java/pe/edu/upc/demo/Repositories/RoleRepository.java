package pe.edu.upc.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.demo.Entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	public Role findByRol(String rol);
}
