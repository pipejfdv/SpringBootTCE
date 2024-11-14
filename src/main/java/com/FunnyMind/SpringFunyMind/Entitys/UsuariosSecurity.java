package com.FunnyMind.SpringFunyMind.Entitys;

import com.FunnyMind.SpringFunyMind.Config.TipoUsuarioRol;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class UsuariosSecurity implements UserDetails {
    //entidad usuario para usar sus componentes
    private Usuarios usuario;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //se llama la clase "TipoUsuarioRol" para poderle asignar un rol ->String al usuario de acuerdo con "id_rol" -> int
        String rol = TipoUsuarioRol.tipoUsuarioRol(usuario.getId_rol());
        return Collections.singleton(new SimpleGrantedAuthority(rol));//se le pasa el rol en String y lo aplica para la seguridad
    }
    //toma los datos del usuario en este caso la contraseña
    @Override
    public String getPassword() {
        return usuario.getPassword();
    }
    //toma los datos del usuario en este caso el usuario
    @Override
    public String getUsername() {
        return usuario.getUsername();
    }
}
