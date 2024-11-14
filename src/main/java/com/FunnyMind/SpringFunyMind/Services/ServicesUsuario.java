package com.FunnyMind.SpringFunyMind.Services;

import com.FunnyMind.SpringFunyMind.Entitys.Usuarios;
import com.FunnyMind.SpringFunyMind.Entitys.UsuariosSecurity;
import com.FunnyMind.SpringFunyMind.Repository.RepositoryUsuario;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServicesUsuario implements UserDetailsService {
    @Autowired
    private RepositoryUsuario repositoryUsuario;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    //método para invocar todos los datos de los usuarios en una tabla, solo para (ADMIN & PSICOLOGO)
    public List<com.FunnyMind.SpringFunyMind.Entitys.Usuarios> listarUsuarios() {
        return repositoryUsuario.findAll();
    }

    public Optional<Usuarios> getUsario(int id) {
        //Es recomendable crear un registro de las personas que se van para tener feedback
        return repositoryUsuario.findById(id);
    }

    public Optional<com.FunnyMind.SpringFunyMind.Entitys.Usuarios> getDatosUsuario() {
        //atra vez de security y su repositorio "Authentication" me valida la autenticación
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //Tomo el username del usuario logeado
        String username = authentication.getName();
        //lo busco en la base de datos para retornar la entidad
        Usuarios usuario = repositoryUsuario.findByUsername(username);
        //si el usuario es diferente de null significa que si encontro una entidad, la busca y lo retorna en "Optional" en caso que no lo regresa en "Optional.empty()"
        return usuario != null ? repositoryUsuario.findById(usuario.getId_usuario()) : Optional.empty();
    }

    //métodos que de los usuarios crear cuenta y actualizar datos
    public void crearActualizarUsuario(com.FunnyMind.SpringFunyMind.Entitys.Usuarios usuario) {
        String encriptacion = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(encriptacion);
        repositoryUsuario.save(usuario);
    }

    public void eliminarUsuario(int id) {
        //Es recomendable crear un registro de las personas que se van para tener feedback
        repositoryUsuario.deleteById(id);
    }

    @Override //la clase nos trae un objeto de "UserDetails" con el método reservado de "loadUserByUsername"
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //crea un objeto de tipo "Usuarios" donde del repositorio traera el usuario
        Usuarios usuario = repositoryUsuario.findByUsername(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        //al obtener el objeto y que exista se crea el objeto o entidad con dicha información para que valide sus credenciales
        return new UsuariosSecurity(usuario);
    }
}
