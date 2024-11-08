package pe.edu.upeu.clinica.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.clinica.entity.Especialidad;

public interface EspecialidadService {
	 Especialidad create(Especialidad especialidad);
	    Especialidad update(Especialidad especialidad);
	    void delete(Long id);
	    Optional<Especialidad> read(Long id);
	    List<Especialidad> readAll();
}
