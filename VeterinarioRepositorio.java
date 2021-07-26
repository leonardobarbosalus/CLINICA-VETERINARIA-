package com.clinicaapp.clinicaapp.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.clinicaapp.clinicaapp.models.Veterinario;

public interface VeterinarioRepositorio extends CrudRepository<Veterinario, String> {
	
	Veterinario findById(Integer id);

}
