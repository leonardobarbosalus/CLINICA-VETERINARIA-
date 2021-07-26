package com.clinicaapp.clinicaapp.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.clinicaapp.clinicaapp.models.Consulta;
import com.clinicaapp.clinicaapp.models.Veterinario;


public interface ConsultaRepositorio extends CrudRepository<Consulta, String> {
	
	Consulta findById(Integer id);	

}
