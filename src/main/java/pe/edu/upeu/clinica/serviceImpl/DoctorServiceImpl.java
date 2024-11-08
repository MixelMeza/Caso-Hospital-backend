package pe.edu.upeu.clinica.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.clinica.dao.DoctorDao;
import pe.edu.upeu.clinica.entity.Doctor;
import pe.edu.upeu.clinica.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorDao doctorDao;

    @Override
    public Doctor create(Doctor doctor) {
        return doctorDao.create(doctor);
    }

    @Override
    public Doctor update(Doctor doctor) {
        return doctorDao.update(doctor);
    }

    @Override
    public void delete(Long id) {
        doctorDao.delete(id);
    }

    @Override
    public Optional<Doctor> read(Long id) {
        return doctorDao.read(id);
    }

    @Override
    public List<Doctor> readAll() {
        return doctorDao.readAll();
    }
}
