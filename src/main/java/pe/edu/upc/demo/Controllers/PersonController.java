package pe.edu.upc.demo.Controllers;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.demo.Entities.Person;
import pe.edu.upc.demo.ServiceInterface.IPersonService;

@Controller
@RequestMapping("/ppersons")
public class PersonController {

	@Autowired
	private IPersonService personService;

	@GetMapping("/inicio")
	public String inicio() {
		return "inicio/inicio";
	}

	@GetMapping("/new")
	public String newPerson(Model model) {
		model.addAttribute("p", new Person());
		return "persona/frmRegistro";
	}

	@PostMapping("/save")
	public String savePerson(@Valid @ModelAttribute("p") Person pe, BindingResult binRes, Model model,
			SessionStatus status) {
		if (binRes.hasErrors()) {
			return "persona/frmRegistro";
		} else {
			int rpta = personService.insert(pe);
			int rpta2 = personService.insert2(pe);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Este DNI ya ha sido registrado, por favor, ingrese otro.");
				return "persona/frmRegistro";
			}
			if (rpta2 > 0) {
				model.addAttribute("mensaje1", "Este correo ya ha sido registrado, por favor, ingrese otro.");
				return "persona/frmRegistro";
			}

			else {

				personService.insert3(pe);
				model.addAttribute("mensaje", "Se guardó correctamente");
				model.addAttribute("listaPersona", personService.list());
				status.setComplete();
			}
			return "redirect:/ppersons/list";
		}
	}

	@GetMapping("/list")
	public String listPerson(Model model) {
		try {
			model.addAttribute("p", new Person());
			model.addAttribute("listaPersonas", personService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "persona/frmLista";
	}

	@RequestMapping("/delete")
	public String deletePerson(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				personService.delete(id);
				model.put("listaPersonas", personService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "persona/frmLista";
	}

	// va a llevar el objeto y lo va a mostrar en el formulario

	@RequestMapping("/goupdate/{id}")
	public String goUpdatePerson(@PathVariable int id, Model model) {

		Optional<Person> objPer = personService.listID(id);
		model.addAttribute("pe", objPer.get());
		return "persona/frmActualiza";
	}

	// guardar los cambios
	@PostMapping("/update")
	public String updatePerson(@Valid @ModelAttribute("pe") Person p, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "persona/frmActualiza";
		} else {
			/*
			 * int rpta = personService.insert(p); int rpta2 = personService.insert2(p); if
			 * (rpta > 0) { model.addAttribute("mensaje",
			 * "Este DNI ya ha sido registrado, por favor, ingrese otro."); return
			 * "persona/frmActualiza"; } if (rpta2 > 0) { model.addAttribute("mensaje1",
			 * "Este correo ya ha sido registrado, por favor, ingrese otro."); return
			 * "persona/frmActualiza"; }
			 * 
			 * else {
			 */
			personService.update(p);
			// }
			return "redirect:/ppersons/list";
		}
	}

}
