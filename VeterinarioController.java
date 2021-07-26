package com.clinicaapp.clinicaapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.clinicaapp.clinicaapp.models.Veterinario;
import com.clinicaapp.clinicaapp.repositorio.VeterinarioRepositorio;

@Controller
public class VeterinarioController {
	
	@Autowired
	private VeterinarioRepositorio vr;
	
	@RequestMapping(value="/cadastrarVeterinario", method = RequestMethod.GET)
	public String form() {
		return "veterinario/formVeterinario";
	}
	
	@RequestMapping(value="/cadastrarVeterinario", method = RequestMethod.POST)
	public String form(Veterinario veterinario) {
		
		vr.save(veterinario);
		
		return "redirect:/cadastrarVeterinario";
	}
	
	
	@RequestMapping("/veterinarios")
	public ModelAndView listaVeterinarios() {
		
		ModelAndView model = new ModelAndView("index");
		Iterable< Veterinario> veterinarios = vr.findAll();
		model.addObject("veterinarios",veterinarios);
		
		return model;
	}
	

	@RequestMapping("/alterar/{id}")
	public ModelAndView alterarVeterinario(@PathVariable("id") Integer id) {

		ModelAndView model = new ModelAndView("formAlterarVeterinario");
		Veterinario veterinario = vr.findById(id);
		model.addObject("veterinario",veterinario);
		return model;
		
	}
	
	@RequestMapping("/excluir/{id}")
	public String deletarVeterinario(@PathVariable("id") Integer id) {
		Veterinario veterinario = vr.findById(id);
		vr.delete(veterinario);
		return "redirect:/cadastrarVeterinario";
		
	}

}
