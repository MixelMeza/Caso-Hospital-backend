package pe.edu.upeu.clinica.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import pe.edu.upeu.clinica.entity.Especialidad;
import pe.edu.upeu.clinica.service.EspecialidadService;

@RestController
@RequestMapping("/api/especialidades")
@CrossOrigin(origins = "http://localhost:4200")

public class EspecialidadController {

    @Autowired
    private EspecialidadService especialidadService;

    @GetMapping
    public ResponseEntity<List<Especialidad>> readAll() {
        List<Especialidad> especialidades = especialidadService.readAll();
        if (especialidades.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(especialidades, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Especialidad> create(@Valid @RequestBody Especialidad especialidad) {
        try {
            Especialidad newEspecialidad = especialidadService.create(especialidad);
            return new ResponseEntity<>(newEspecialidad, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Especialidad> readById(@PathVariable("id") Long id) {
        Optional<Especialidad> especialidad = especialidadService.read(id);
        return especialidad.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                           .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Especialidad> update(@PathVariable("id") Long id, @Valid @RequestBody Especialidad especialidad) {
        Optional<Especialidad> existingEspecialidad = especialidadService.read(id);
        if (existingEspecialidad.isPresent()) {
            especialidad.setId(id);
            return new ResponseEntity<>(especialidadService.update(especialidad), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        try {
            especialidadService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
