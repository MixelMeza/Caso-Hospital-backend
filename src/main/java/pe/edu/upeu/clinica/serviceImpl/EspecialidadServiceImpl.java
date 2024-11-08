package pe.edu.upeu.clinica.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.clinica.dao.EspecialidadDao;
import pe.edu.upeu.clinica.entity.Especialidad;
import pe.edu.upeu.clinica.service.EspecialidadService;

@Service
public class EspecialidadServiceImpl implements EspecialidadService {

    @Autowired
    private EspecialidadDao especialidadDao;

    @Override
    public Especialidad create(Especialidad especialidad) {
        return especialidadDao.create(especialidad);
    }

    @Override
    public Especialidad update(Especialidad especialidad) {
        return especialidadDao.update(especialidad);
    }

    @Override
    public void delete(Long id) {
        especialidadDao.delete(id);
    }

    @Override
    public Optional<Especialidad> read(Long id) {
        return especialidadDao.read(id);
    }

    @Override
    public List<Especialidad> readAll() {
        return especialidadDao.readAll();
    }
}
