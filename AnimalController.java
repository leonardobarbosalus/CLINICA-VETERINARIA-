package com.clinicaapp.clinicaapp;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.clinicaapp.clinicaapp.models.Animal;
import com.clinicaapp.clinicaapp.models.Tutor;
import com.clinicaapp.clinicaapp.models.Veterinario;
import com.clinicaapp.clinicaapp.repositorio.AnimalRepositorio;


@Controller
public class AnimalController {
	
	@Autowired
	private AnimalRepositorio vr;
	
	@RequestMapping(value="/cadastrarAnimal", method = RequestMethod.GET)
	public String form() {
		return "animal/cadastrarAnimal";
	}
	
	@RequestMapping(value="/cadastrarAnimal", method = RequestMethod.POST)
	public String form(Animal animal) {
		
		vr.save(animal);
		
		return "redirect:/cadastrarAnimal";
	}
	
	@RequestMapping("/alterar/{id}")
	public ModelAndView alterarAnimal(@PathVariable("id") Integer id) {

		ModelAndView model = new ModelAndView("formAlterarAnimal");
		Animal animal = vr.findById(id);
		model.addObject("animal",animal);
		return model;
		
	}
	
	@RequestMapping("/excluir/{id}")
	public String deletarVeterinario(@PathVariable("id") Integer id) {
		Animal animal = vr.findById(id);
		vr.delete(animal);
		return "redirect:/cadastrarAnimal";
		
	}

}
