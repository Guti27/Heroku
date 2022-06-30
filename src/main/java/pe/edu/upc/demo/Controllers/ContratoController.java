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

import pe.edu.upc.demo.Entities.Contrato;
import pe.edu.upc.demo.ServiceInterface.IContratoService;
import pe.edu.upc.demo.ServiceInterface.IPostulanteService;

@Controller
@RequestMapping("/ccontrato")
public class ContratoController {

	@Autowired
	private IContratoService contratoService;

	@Autowired
	private IPostulanteService pService;

	@GetMapping("/new")
	public String newContrato(Model model) {

		model.addAttribute("c", new Contrato());
		model.addAttribute("listaPostulante", pService.list());
		return "contrato/frmRegistro";
	}

	@PostMapping("/save")
	public String saveContrato(@Valid @ModelAttribute("c") Contrato c, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			model.addAttribute("listaPostulante", pService.list());
			return "contrato/frmRegistro";
		} else {
			contratoService.insert(c);
			model.addAttribute("mensaje", "Se registró correctamente");
			return "redirect:/ccontrato/list";
		}
	}

	@GetMapping("/list")
	public String listContrato(Model model) {
		try {
			model.addAttribute("listaContrato", contratoService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/contrato/frmLista";
	}

	@RequestMapping("/delete")
	public String deleteContrato(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				contratoService.delete(id);
				model.put("listaContrato", contratoService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "contrato/frmLista";
	}

	@RequestMapping("/goupdate/{id}")
	public String goUpdateContrato(@PathVariable int id, Model model) {

		Optional<Contrato> objPos = contratoService.listID(id);
		model.addAttribute("listaPostulante", pService.list());
		model.addAttribute("c", objPos.get());
		return "contrato/frmActualiza";
	}

	@PostMapping("/update")
	public String updateContrato(@Valid @ModelAttribute("c") Contrato c, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			model.addAttribute("listaPostulante", pService.list());
			return "contrato/frmRegistro";
		} else {
			contratoService.update(c);
			return "redirect:/ccontrato/list";
		}
	}

	@RequestMapping("/reporte")
	public String cantidadTipoTrabajos(Map<String, Object> model) {

		model.put("listaSueldoPromedioRubro", contratoService.SueldoPromedioRubro());
		return "contrato/report";
	}

}
