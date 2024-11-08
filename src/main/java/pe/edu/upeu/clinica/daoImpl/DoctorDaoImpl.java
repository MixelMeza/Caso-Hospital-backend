package pe.edu.upeu.clinica.daoImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.upeu.clinica.dao.DoctorDao;
import pe.edu.upeu.clinica.entity.Doctor;
import pe.edu.upeu.clinica.repository.DoctorRepository;

@Component
public class DoctorDaoImpl implements DoctorDao {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor create(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor update(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public void delete(Long id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public Optional<Doctor> read(Long id) {
        return doctorRepository.findById(id);
    }

    @Override
    public List<Doctor> readAll() {
        return doctorRepository.findAll();
    }
}
