package pe.edu.upc.demo.Controllers;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.upc.demo.Entities.Empleador;
import pe.edu.upc.demo.ServiceInterface.IEmpleadorService;
import pe.edu.upc.demo.ServiceInterface.IPersonService;

@Controller
@RequestMapping("/eempleador")
public class EmpleadorController {

	@Autowired
	private IEmpleadorService empleadorService;
	@Autowired
	private IPersonService pService;

	@GetMapping("/new")
	public String newEmpleador(Model model) {

		model.addAttribute("e", new Empleador());
		model.addAttribute("listaPersonas", pService.list());

		return "empleador/frmRegistro";
	}

	@PostMapping("/save")
	public String saveEmpleador(@Valid Empleador em, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "empleador/frmRegistro";
		} else {
			empleadorService.insert(em);
			model.addAttribute("mensaje", "Se registro correctamente");
			return "redirect:/eempleador/list";
		}
	}

	@GetMapping("/list")
	public String listPerson(Model model) {
		try {
			model.addAttribute("listaEmpleador", empleadorService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/empleador/frmLista";
	}

	@RequestMapping("/delete")
	public String deleteEmpleador(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				empleadorService.delete(id);
				model.put("listaEmpleador", empleadorService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "empleador/frmLista";

	}

	@RequestMapping("/goupdate/{id}")
	public String goUpdateEmpleador(@PathVariable int id, Model model) {

		Optional<Empleador> objEm = empleadorService.listId(id);
		model.addAttribute("listaPersonas", pService.list());

		model.addAttribute("em", objEm.get());
		return "empleador/frmActualiza";
	}

	@PostMapping("/update")
	public String updateEmpleador(Empleador em) {
		empleadorService.update(em);
		return "redirect:/eempleador/list";

	}

}
