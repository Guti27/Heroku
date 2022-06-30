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

import pe.edu.upc.demo.Entities.Postulante;
import pe.edu.upc.demo.ServiceInterface.IAvisoTrabajoService;
import pe.edu.upc.demo.ServiceInterface.IPostulanteService;
import pe.edu.upc.demo.ServiceInterface.ITrabajadorService;

@Controller
@RequestMapping("/ppostulante")
public class PostulanteController {

	@Autowired
	private IPostulanteService postulanteService;

	@Autowired
	private ITrabajadorService tservie;
	@Autowired
	private IAvisoTrabajoService aService;

	@GetMapping("/new")
	public String newPostulante(Model model) {

		model.addAttribute("p", new Postulante());
		model.addAttribute("listaTrabajador", tservie.list());
		model.addAttribute("listaAvisoTrabajo", aService.list());
		return "postulante/frmRegistro";
	}

	@PostMapping("/save")
	public String savePostulante(@Valid Postulante p, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "postulante/frmRegistro";
		} else {
			postulanteService.insert(p);
			model.addAttribute("mensaje", "Se registró correctamente");
			return "redirect:/ppostulante/list";
		}
	}

	@GetMapping("/list")
	public String listPostulante(Model model) {
		try {
			model.addAttribute("listaPostulante", postulanteService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/postulante/frmLista";
	}

	@RequestMapping("/delete")
	public String deletePostulante(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				postulanteService.delete(id);
				model.put("listaTrabajador", postulanteService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "postulante/frmLista";
	}

	@RequestMapping("/goupdate/{id}")
	public String goUpdatePostulante(@PathVariable int id, Model model) {

		Optional<Postulante> objPos = postulanteService.listID(id);
		model.addAttribute("listaTrabajador", tservie.list());
		model.addAttribute("listaAvisoTrabajo", aService.list());
		model.addAttribute("pos", objPos.get());
		return "postulante/frmActualiza";
	}

	// guardar los cambios
	@PostMapping("/update")
	public String updatePostulante(Postulante p) {
		postulanteService.update(p);
		return "redirect:/ppostulante/list";
	}

	@RequestMapping("/reporte")
	public String cantidadTipoTrabajos(Map<String, Object> model) {

		model.put("listaPostulacionesTrabajo", postulanteService.PostulacionesTrabajo());
		return "postulante/report";
	}
}
