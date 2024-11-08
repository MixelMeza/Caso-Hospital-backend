package pe.edu.upeu.clinica.service;

import pe.edu.upeu.clinica.dto.LoginDto;

public interface AuthService {
    String login(LoginDto loginDto);
}
