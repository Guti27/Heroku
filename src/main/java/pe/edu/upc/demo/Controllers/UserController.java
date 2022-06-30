package pe.edu.upc.demo.Controllers;

import java.text.ParseException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.demo.Entities.Users;
import pe.edu.upc.demo.ServiceInterface.IUserService;

@Controller
@RequestMapping("/usuarios")
public class UserController {

	@Autowired
	private IUserService uService;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/nuevo")
	public String newUser(Model model) {
		model.addAttribute("u", new Users());
		return "user/usuario";
	}

	@PostMapping("/guardar")
	public String registrarUser(@Valid @ModelAttribute("u") Users objTel, BindingResult binRes, Model model,
			SessionStatus status) throws ParseException {
		if (binRes.hasErrors()) {
			model.addAttribute("listaUsuarios", uService.listar());
			return "user/usuario";
		} else {
			String p = objTel.getPassword();
			String pE = passwordEncoder.encode(p);
			Users us = new Users();
			us.setUsername(objTel.getUsername());
			us.setEnabled(objTel.getEnabled());
			us.setPassword(pE);

			int rpta = uService.insertar(us);
			if (rpta > 0) {
				model.addAttribute("mensaje1", "Este usuario ya existe, por favor, ingrese otro.");
				return "user/usuario";
			} else {

				// uService.insertar(us);
				model.addAttribute("mensaje", "Se guardó correctamente");
				model.addAttribute("listaUsuarios", uService.listar());
				status.setComplete();
			}
		}
		// model.addAttribute("listaUsuarios", uService.listar());
		// return "user/usuario";		
		return "redirect:/usuarios/listar";
		
		/*if (binRes.hasErrors()) {
            return "user/usuario";
        } else {
            String p = objTel.getPassword();
            String pE = passwordEncoder.encode(p);
            Users us = new Users();
            us.setUsername(objTel.getUsername());
            us.setEnabled(objTel.getEnabled());
            us.setPassword(pE);

            uService.insertar(us);
            model.addAttribute("mensaje", "Se guardó correctamente");
            // status.setComplete();
            return "redirect:/usuarios/listar";
        }*/
	}

	@GetMapping("/listar")
	public String listarUsuarios(Model model) {
		try {
			model.addAttribute("u", new Users());
			model.addAttribute("listaUsuarios", uService.listar());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/user/listaUsuario";
	}

}
