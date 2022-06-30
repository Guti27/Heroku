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

import pe.edu.upc.demo.Entities.Trabajador;
import pe.edu.upc.demo.ServiceInterface.IPersonService;
import pe.edu.upc.demo.ServiceInterface.ITipoTrabajoService;
import pe.edu.upc.demo.ServiceInterface.ITrabajadorService;

@Controller
@RequestMapping("/ttrabajador")
public class TrabajadorController {

	@Autowired
	private ITrabajadorService trabajadorService;
	@Autowired
	private IPersonService pService;
	@Autowired
	private ITipoTrabajoService tService;

	@GetMapping("/new")
	public String newTrabajador(Model model) {

		model.addAttribute("t", new Trabajador());
		model.addAttribute("listaPersonas", pService.list());
		model.addAttribute("listaTipoTrabajo", tService.list());
		return "trabajador/frmRegistro";
	}

	@PostMapping("/save")
	public String saveTrabajador(@Valid Trabajador t, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "trabajador/frmRegistro";
		} else {
			trabajadorService.insert(t);
			model.addAttribute("mensaje", "Se registró correctamente");
			return "redirect:/ttrabajador/list";
		}
	}

	@GetMapping("/list")
	public String listTrabajador(Model model) {
		try {
			model.addAttribute("listaTrabajador", trabajadorService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/trabajador/frmLista";
	}

	@RequestMapping("/delete")
	public String deleteTrabajador(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				trabajadorService.delete(id);
				model.put("listaTrabajador", trabajadorService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "trabajador/frmLista";
	}

	@RequestMapping("/goupdate/{id}")
	public String goUpdateTrabajador(@PathVariable int id, Model model) {

		Optional<Trabajador> objTra = trabajadorService.listID(id);
		model.addAttribute("listaPersonas", pService.list());
		model.addAttribute("listaTipoTrabajo", tService.list());

		model.addAttribute("tra", objTra.get());
		return "trabajador/frmActualiza";
	}

	// guardar los cambios
	@PostMapping("/update")
	public String updateTrabajador(Trabajador t) {
		trabajadorService.update(t);
		return "redirect:/ttrabajador/list";
	}

	@RequestMapping("/reporte")
	public String cantidadTipoTrabajos(Map<String, Object> model) {

		model.put("listaCantidadTrabajadorepoRubro", trabajadorService.CantidadTrabajadorepoRubro());
		return "trabajador/report";
	}

}
