package com.clinicaapp.clinicaapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.clinicaapp.clinicaapp.models.Animal;
import com.clinicaapp.clinicaapp.models.Consulta;
import com.clinicaapp.clinicaapp.models.Veterinario;
import com.clinicaapp.clinicaapp.repositorio.AnimalRepositorio;
import com.clinicaapp.clinicaapp.repositorio.ConsultaRepositorio;


@Controller
public class ConsultaController {
	
	@Autowired
	private ConsultaRepositorio vr;
	
	@RequestMapping(value="/cadastrarConsulta", method = RequestMethod.GET)
	public String form() {
		return "veterinario/formCadastrarConsulta";
	}
	
	@RequestMapping(value="/cadastrarConsulta", method = RequestMethod.POST)
	public String form(Consulta consulta) {
		
		vr.save(consulta);
		
		return "redirect:/formCadastrarConsulta";
	}
	
	
	@RequestMapping("/consultas")
	public ModelAndView listaConsultas() {
		
		ModelAndView model = new ModelAndView("index");
		Iterable< Consulta> consultas = vr.findAll();
		model.addObject("consultas",consultas);
		
		return model;
	}
	

}
