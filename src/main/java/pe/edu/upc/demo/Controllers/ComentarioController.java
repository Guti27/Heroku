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

import pe.edu.upc.demo.Entities.Comentario;
import pe.edu.upc.demo.ServiceInterface.IComentarioService;
import pe.edu.upc.demo.ServiceInterface.IContratoService;
import pe.edu.upc.demo.ServiceInterface.IEmpleadorService;

@Controller
@RequestMapping("/ccomentario")
public class ComentarioController {

	@Autowired
	private IComentarioService comentarioService;
	@Autowired
	private IContratoService cService;
	@Autowired
	private IEmpleadorService eService;

	@GetMapping("/new")
	public String newComentario(Model model) {
		model.addAttribute("c", new Comentario());
		model.addAttribute("listaContrato", cService.list());
		model.addAttribute("listaEmpleador", eService.list());

		return "comentario/frmRegistro";
	}

	@PostMapping("/save")
	public String saveComentario(@Valid Comentario co, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "comentario/frmRegistro";
		} else {
			comentarioService.insert(co);
			model.addAttribute("mensaje", "Se registro correctamente");
			return "redirect:/ccomentario/list";
		}
	}

	@GetMapping("/list")
	public String listComentario(Model model) {
		try {
			model.addAttribute("listaComentario", comentarioService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/comentario/frmLista";
	}

	@RequestMapping("/delete")
	public String deleteComentario(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				comentarioService.delete(id);
				model.put("listaComentario", comentarioService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}

		return "comentario/frmLista";
	}

	@RequestMapping("/goupdate/{id}")
	public String goUpdateComentario(@PathVariable int id, Model model) {
		Optional<Comentario> objCom = comentarioService.listIdComentario(id);
		model.addAttribute("listaContrato", cService.list());
		model.addAttribute("listaEmpleador", eService.list());
		model.addAttribute("co", objCom.get());
		return "comentario/frmActualiza";
	}

	@PostMapping("/update")
	public String updateComentario(Comentario c) {
		comentarioService.update(c);
		return "redirect:/ccomentario/list";

	}

	@RequestMapping("/reporte")
	public String cantidadTipoTrabajos(Map<String, Object> model) {

		model.put("listaTrabajadorRecomendaciones", comentarioService.TrabajadorRecomendaciones());
		return "comentario/report";
	}

}
