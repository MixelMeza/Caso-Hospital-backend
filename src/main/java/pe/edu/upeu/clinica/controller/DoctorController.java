package pe.edu.upeu.clinica.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import pe.edu.upeu.clinica.entity.Doctor;
import pe.edu.upeu.clinica.service.DoctorService;

@RestController
@RequestMapping("/api/doctores")
@CrossOrigin(origins = "http://localhost:4200")

public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public ResponseEntity<List<Doctor>> readAll() {
        List<Doctor> doctores = doctorService.readAll();
        if (doctores.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(doctores, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Doctor> create(@Valid @RequestBody Doctor doctor) {
        try {
            Doctor newDoctor = doctorService.create(doctor);
            return new ResponseEntity<>(newDoctor, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> readById(@PathVariable("id") Long id) {
        Optional<Doctor> doctor = doctorService.read(id);
        return doctor.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                      .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> update(@PathVariable("id") Long id, @Valid @RequestBody Doctor doctor) {
        Optional<Doctor> existingDoctor = doctorService.read(id);
        if (existingDoctor.isPresent()) {
            doctor.setId(id);
            return new ResponseEntity<>(doctorService.update(doctor), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        try {
            doctorService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
