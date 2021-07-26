package com.clinicaapp.clinicaapp.repositorio;

import org.springframework.data.repository.CrudRepository;


import com.clinicaapp.clinicaapp.models.Tutor;
import com.clinicaapp.clinicaapp.models.Veterinario;


public interface TutorRepositorio extends CrudRepository<Tutor, String> {
	
	Tutor findById(Integer id);

}
