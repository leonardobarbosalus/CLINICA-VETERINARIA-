package com.clinicaapp.clinicaapp.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.clinicaapp.clinicaapp.models.Animal;
import com.clinicaapp.clinicaapp.models.Veterinario;


public interface AnimalRepositorio extends CrudRepository<Animal, String> {
	
	Animal findById(Integer id);

}
