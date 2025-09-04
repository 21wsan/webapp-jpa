package org.wsan.apiservlet.webapp.headers.services;

import jakarta.inject.Inject;
import org.wsan.apiservlet.webapp.headers.configs.Service;
import org.wsan.apiservlet.webapp.headers.models.entities.Usuario;
import org.wsan.apiservlet.webapp.headers.repositories.UsuarioRepository;

import java.sql.SQLException;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    private UsuarioRepository usuarioRepository;

    //Inyeccion por contructor
    @Inject
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Optional<Usuario> login(String username, String password) {
        try {
            return Optional.ofNullable(usuarioRepository.porUsername(username)).filter(u -> u.getPassword().equals(password));
        } catch (SQLException throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }
}
