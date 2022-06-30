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

import pe.edu.upc.demo.Entities.TipoTrabajo;
import pe.edu.upc.demo.ServiceInterface.ITipoTrabajoService;

@Controller
@RequestMapping("/ttipotrabajo")
public class TipoTrabajoController {

	@Autowired
	private ITipoTrabajoService tipoTrabajoService;

	@GetMapping("/new")
	public String newTipoTrabajo(Model model) {
		model.addAttribute("tt", new TipoTrabajo());
		return "tipotrabajo/frmRegistro";
	}

	@PostMapping("/save")
	public String saveTipoTrabajo(@Valid TipoTrabajo tipt, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "tipotrabajo/frmRegistro";
		} else {
			tipoTrabajoService.insert(tipt);
			model.addAttribute("mensaje", "Se registró correctamente");
			return "redirect:/ttipotrabajo/list";
		}
	}

	@GetMapping("/list")
	public String listTipoTrabajo(Model model) {
		try {
			model.addAttribute("listaTipoTrabajo", tipoTrabajoService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/tipotrabajo/frmLista";
	}

	@RequestMapping("/delete")
	public String deleteTipoTrabajo(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				tipoTrabajoService.delete(id);
				model.put("listaTipoTrabajo", tipoTrabajoService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "tipotrabajo/frmLista";
	}

	// va a llevar el objeto y lo va a mostrar en el formulario

	@RequestMapping("/goupdate/{id}")
	public String goUpdateTipoTrabajo(@PathVariable int id, Model model) {

		Optional<TipoTrabajo> objTipT = tipoTrabajoService.listID(id);
		model.addAttribute("tiptr", objTipT.get());
		return "tipotrabajo/frmActualiza";
	}
	
	// guardar los cambios
		@PostMapping("/update")
		public String updateTipoTrabajo(TipoTrabajo tipt) {
			tipoTrabajoService.update(tipt);
			return "redirect:/ttipotrabajo/list";
		}
}
