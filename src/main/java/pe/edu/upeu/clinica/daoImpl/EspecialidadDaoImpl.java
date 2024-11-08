package pe.edu.upeu.clinica.daoImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.upeu.clinica.dao.EspecialidadDao;
import pe.edu.upeu.clinica.entity.Especialidad;
import pe.edu.upeu.clinica.repository.EspecialidadRepository;

@Component
public class EspecialidadDaoImpl implements EspecialidadDao {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    @Override
    public Especialidad create(Especialidad especialidad) {
        return especialidadRepository.save(especialidad);
    }

    @Override
    public Especialidad update(Especialidad especialidad) {
        return especialidadRepository.save(especialidad);
    }

    @Override
    public void delete(Long id) {
        especialidadRepository.deleteById(id);
    }

    @Override
    public Optional<Especialidad> read(Long id) {
        return especialidadRepository.findById(id);
    }

    @Override
    public List<Especialidad> readAll() {
        return especialidadRepository.findAll();
    }
}
