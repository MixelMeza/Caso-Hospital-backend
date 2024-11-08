package pe.edu.upeu.clinica.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upeu.clinica.entity.Rol;

public interface RolRepository extends JpaRepository<Rol,Long> {
}
