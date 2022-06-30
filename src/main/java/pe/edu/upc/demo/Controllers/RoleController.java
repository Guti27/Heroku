package pe.edu.upc.demo.Controllers;

import java.text.ParseException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.demo.Entities.Role;
import pe.edu.upc.demo.ServiceInterface.IRoleService;
import pe.edu.upc.demo.ServiceInterface.IUserService;



@Controller
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	private IRoleService rService;
	@Autowired
	private IUserService uService;

	@GetMapping("/nuevo")
	public String newRole(Model model) {
		model.addAttribute("r", new Role());
		model.addAttribute("listaUsuarios", uService.listar());
		return "role/role";		
	}

	@PostMapping("/guardar")
	public String registrarRole(@Valid Role objTel, BindingResult binRes, Model model) throws ParseException {
		if (binRes.hasErrors()) {
			return "role/role";
		} else {
			rService.insertar(objTel);
			model.addAttribute("mensaje", "Se guardó correctamente");
			// status.setComplete();
			return "redirect:/roles/listar";
		}
	}

	@GetMapping("/listar")
	public String listarRoles(Model model) {
		try {
			model.addAttribute("listaRoles", rService.listar());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/role/listaRole";
	}

}
