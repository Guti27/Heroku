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

import pe.edu.upc.demo.Entities.AvisoTrabajo;
import pe.edu.upc.demo.ServiceInterface.IAvisoTrabajoService;
import pe.edu.upc.demo.ServiceInterface.IEmpleadorService;
import pe.edu.upc.demo.ServiceInterface.ITipoTrabajoService;

@Controller
@RequestMapping("/aavisoTrabajo")
public class AvisoTrabajoController {

	@Autowired
	private IAvisoTrabajoService avisoTrabajoService;
	@Autowired
	private ITipoTrabajoService tService;
	@Autowired
	private IEmpleadorService eService;

	@GetMapping("/new")
	public String newAvisoTrabajo(Model model) {

		model.addAttribute("at", new AvisoTrabajo());
		model.addAttribute("listaEmpleador", eService.list());
		model.addAttribute("listaTipoTrabajo", tService.list());
		return "avisoTrabajo/frmRegistro";
	}

	@PostMapping("/save")
	public String saveAvisoTrabajo(@Valid @ModelAttribute("at") AvisoTrabajo at, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			model.addAttribute("listaEmpleador", eService.list());
			model.addAttribute("listaTipoTrabajo", tService.list());
			return "avisoTrabajo/frmRegistro";
		} else {
			avisoTrabajoService.insert(at);
			model.addAttribute("mensaje", "Se registró correctamente");
			model.addAttribute("listaAvisoTrabajo", avisoTrabajoService.list());
			return "redirect:/aavisoTrabajo/list";
		}
	}

	@GetMapping("/list")
	public String listAvisoTrabajo(Model model) {
		try {
			model.addAttribute("listaAvisoTrabajo", avisoTrabajoService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/avisoTrabajo/frmLista";
	}

	@RequestMapping("/delete")
	public String deleteAvisoTrabajo(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				avisoTrabajoService.delete(id);
				model.put("listaAvisoTrabajo", avisoTrabajoService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "avisoTrabajo/frmLista";
	}

	@RequestMapping("/goupdate/{id}")
	public String goUpdateAvisoTrabajo(@PathVariable int id, Model model) {

		Optional<AvisoTrabajo> objTra = avisoTrabajoService.listId(id);
		model.addAttribute("listaEmpleador", eService.list());
		model.addAttribute("listaTipoTrabajo", tService.list());

		model.addAttribute("at", objTra.get());
		return "avisoTrabajo/frmActualiza";
	}

	@PostMapping("/update")
	public String updateAvisoTrabajo(@Valid @ModelAttribute("at") AvisoTrabajo at, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			model.addAttribute("listaEmpleador", eService.list());
			model.addAttribute("listaTipoTrabajo", tService.list());
			return "avisoTrabajo/frmRegistro";
		} else {
			avisoTrabajoService.update(at);
			return "redirect:/aavisoTrabajo/list";
		}
	}
	@RequestMapping("/reporte")
	public String cantidadTipoTrabajos(Map<String, Object> model) {

		model.put("listaCantidadTipoTrabajo", avisoTrabajoService.CantidadTipoTrabajo());
		return "avisoTrabajo/report";
	}

}
