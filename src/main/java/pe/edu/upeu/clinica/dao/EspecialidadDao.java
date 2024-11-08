package pe.edu.upeu.clinica.dao;

import java.util.List;
import java.util.Optional;
import pe.edu.upeu.clinica.entity.Especialidad;

public interface EspecialidadDao {
    Especialidad create(Especialidad especialidad);
    Especialidad update(Especialidad especialidad);
    void delete(Long id);
    Optional<Especialidad> read(Long id);
    List<Especialidad> readAll();
}
