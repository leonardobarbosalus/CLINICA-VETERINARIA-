package com.clinicaapp.clinicaapp;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.clinicaapp.clinicaapp.models.Animal;
import com.clinicaapp.clinicaapp.models.Tutor;
import com.clinicaapp.clinicaapp.models.Veterinario;
import com.clinicaapp.clinicaapp.repositorio.TutorRepositorio;


@Controller
public class TutorController {
	
	@Autowired
	private TutorRepositorio vr;
	

	
	@RequestMapping(value="/cadastrarTutor", method = RequestMethod.GET)
	public String form() {
		return "tutor/formTutor";
	}
	
	@RequestMapping(value="/cadastrarTutor", method = RequestMethod.POST)
	public String form(Tutor tutor) {
		
		vr.save(tutor);
		
		return "redirect:/cadastrarTutor";
	}
	
	@RequestMapping("/listartutores")
	public ModelAndView listarTutores() {
		ModelAndView model = new ModelAndView("index");
		Iterable<Tutor> tutores = vr.findAll();
		model.addObject("tutores",tutores);
		return model;
	}
	
	@RequestMapping("/alterar/{id}")
	public ModelAndView alterarTutor(@PathVariable("id") Integer id) {

		ModelAndView model = new ModelAndView("formAlterarTutor");
		Tutor tutor = vr.findById(id);
		model.addObject("tutor",tutor);
		return model;
		
	}
	
	@RequestMapping("/excluir/{id}")
	public String deletarVeterinario(@PathVariable("id") Integer id) {
		Tutor tutor = vr.findById(id);
		vr.delete(tutor);
		return "redirect:/cadastrarTutor";
		
	}

	

}
